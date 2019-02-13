/**
 * 
 */
package com.transerainc.adaws.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;
import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.constants.AdaConstants;
import com.transerainc.adaws.model.AdaRequest;
import com.transerainc.adaws.model.AnalyzerContact;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.util.PropertiesUtil;
import com.transerainc.adaws.util.SignatureHelper;
import com.transerainc.tam.config.AccessDetails.AnalyzerAccessDetails;
import com.transerainc.tam.config.AccessDetailsHelper;
import com.transerainc.tide.pojo.ActivityType;
import com.transerainc.tide.pojo.FilterGroup;
import com.transerainc.tide.pojo.FilterGroup.Operator;
import com.transerainc.tide.pojo.IntervalUnit;
import com.transerainc.tide.pojo.Query;
import com.transerainc.tide.pojo.QueryFilter.OperatorType;
import com.transerainc.tide.pojo.QueryType;
import com.transerainc.tide.pojo.ValueQueryFilter;
import com.transerainc.tide.pojo.aggregation.AggregateQueryProperties;
import com.transerainc.tide.pojo.aggregation.AggregateQueryProperties.Axis;
import com.transerainc.tide.pojo.aggregation.AggregateQueryProperties.RequestType;
import com.transerainc.tide.pojo.aggregation.Aggregation;
import com.transerainc.tide.pojo.aggregation.Aggregation.AggregationType;

/**
 * @author pgujjeti
 *
 */
@Service
public class AnalyzerService {

	private static final String[] INT_COLS = new String[] { "agentName__s",
			"ani__s", "sid", "entrypointName__s", "cstts", "cetts",
			"channelType__s", "inboundTranscript__s", "terminationType__s",
			"talkDuration__l", "outboundTranscript__s", "subject__s", "customerName__s", "dnis__s", "callDirection__s" };

	private final Logger lgr = LoggerFactory.getLogger(AnalyzerService.class);

	@Autowired
	private PropertiesUtil propertiesUtil;

	@Autowired
	SignatureHelper signatureHelper;
	
	@Autowired
	private DesktopConfigManager configMap;

	private AnalyzerAccessDetails analyzerAccessDetails;

	private static String signedKey;

	public AnalyzerService() {
		super();
	}

	@PostConstruct
	public void init() throws Exception {
		String configAgentUrl = propertiesUtil
				.getAdaProperty(AdaConstants.CONFIG_AGENT_URL_PROPERTY_KEY);
		// Fetch the analyzer access details from ConfigAgent
		AccessDetailsHelper aac = new AccessDetailsHelper(configAgentUrl);
		if (aac.getAccessDetails() != null) {
			analyzerAccessDetails = aac.getAccessDetails()
					.getAnalyzerAccessDetails();
			if (analyzerAccessDetails != null) {
				signedKey = signatureHelper.computeSignature(
						analyzerAccessDetails.getFrom(),
						analyzerAccessDetails.getApiKey());
			}
		}
	}

	public List<AnalyzerContact> getContactHistoryByANI(String tenantId,
			String ani, String customerPhoneNumber, long startTime, long endTime) {
		ValueQueryFilter aniFilter = createFilter("ani__s", ani);
		ValueQueryFilter currStateFilter = createFilter("currentState__s", "ended");
		ValueQueryFilter customerPhoneFilter = createFilter("customerPhoneNumber__s", customerPhoneNumber);

		List<ValueQueryFilter[]> valueQueryFilterList = new ArrayList<ValueQueryFilter[]>();
		valueQueryFilterList.add(new ValueQueryFilter[] { customerPhoneFilter, aniFilter });
		valueQueryFilterList.add(new ValueQueryFilter[] { currStateFilter });
		return getContactHistory(valueQueryFilterList, startTime, endTime, tenantId);
	}

	public List<AnalyzerContact> getContactHistoryByAgent(String tenantId,
			String agentId, long startTime, long endTime) {
		ValueQueryFilter agentIdFilter = createFilter("agentId__s", agentId);
		ValueQueryFilter currStateFilter = createFilter("currentState__s", "ended");

		List<ValueQueryFilter[]> valueQueryFilterList = new ArrayList<ValueQueryFilter[]>();
		valueQueryFilterList.add(new ValueQueryFilter[] { agentIdFilter, currStateFilter });
		return getContactHistory(valueQueryFilterList, startTime, endTime, tenantId);
	}


	public String getTranscript(String transcriptId, String tenantId) {
		HttpEntity<?> requestEntity = buildRequestEntity(tenantId);
		String awsUrl = analyzerAccessDetails.getBaseUrl()
				+ "/blobs/csrs/" + transcriptId;

		String transcript = null;
		try {
			URI serviceUrl = new URI(awsUrl);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> userEntity = restTemplate.exchange(
					serviceUrl, HttpMethod.GET, requestEntity, String.class);

			if (userEntity != null) {
				transcript = userEntity.getBody();
			}
			lgr.debug("Response from {}: {}", serviceUrl, transcript);
		} catch (Exception e) {
			lgr.error("Exception while fetching transcript from URL {}", awsUrl,
					e);
		}
		return transcript;
	}

	public String getTenantNameByLoginName(String loginName) {
		HttpEntity<?> requestEntity = buildRequestEntityWithUsername(loginName);
		String awsUrl = analyzerAccessDetails.getBaseUrl()
				+ "/security/tenants";

		String tenantNameResponseBody = null;
		try {
			URI serviceUrl = new URI(awsUrl);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> userEntity = restTemplate.exchange(awsUrl,
					HttpMethod.GET, requestEntity, String.class);

			if (userEntity != null) {
				tenantNameResponseBody = userEntity.getBody();
			}
			lgr.debug("Response from {}: {}", serviceUrl,
					tenantNameResponseBody);
		} catch (Exception e) {
			lgr.error("Exception while fetching tenantName from AWS URL {}",
					awsUrl, e);
		}
		return tenantNameResponseBody;
	}

	public String getUserDetailsInfoByLoginName(String loginName, String tenantId) {
		HttpEntity<?> requestEntity = buildRequestEntity(tenantId);
		String awsUrl = analyzerAccessDetails.getBaseUrl()
				+ "/auxiliary-data/user-data/user?login__s="
				+ loginName;

		String userDetailsInfoResponseBody = null;
		try {
			URI serviceUrl = new URI(awsUrl);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> userEntity = restTemplate.exchange(awsUrl,
					HttpMethod.GET, requestEntity, String.class);

			if (userEntity != null) {
				userDetailsInfoResponseBody = userEntity.getBody();
			}
			lgr.debug("Response from {}: {}", serviceUrl,
					userDetailsInfoResponseBody);
		} catch (Exception e) {
			lgr.error("Exception while fetching tenantName from AWS URL {}",
					awsUrl, e);
		}
		return userDetailsInfoResponseBody;
	}

	private List<AnalyzerContact> getContactHistory(
			List<ValueQueryFilter[]> valueQueryFilterList, long startTime, long endTime,
			String tenantId) {

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<?> requestEntity = buildRequestEntity(tenantId);

		Query q = new Query();
		q.setAnchorId(UUID.randomUUID().toString());
		q.setActivityType(ActivityType.INTERACTION);
		q.setNumberOfRecords(1000); // max of 1000 records
		q.setDateBegin(new long[] { startTime });
		q.setDateEnd(new long[] { endTime });

		AggregateQueryProperties aqp = new AggregateQueryProperties();
		aqp.setComputeInterval(0);
		aqp.setComputeIntervalUnit(IntervalUnit.NONE);
		aqp.setQueryType(QueryType.TEMPORAL);
		aqp.setIntervalAxis(Axis.ROW);
		aqp.setComputeSummaries(false);

		q.setAggregateQueryProperties(aqp);

		// set filters
		// ValueQueryFilter agentFilter = createFilter("agentId__s", agentId);
		FilterGroup fg = null;
		List<FilterGroup> fgList = new ArrayList<FilterGroup>();
		for (ValueQueryFilter[] filter : valueQueryFilterList) {
			fg = new FilterGroup();
			boolean flag = false;
			for (ValueQueryFilter f : filter) {
				String columnName = f.getColumnName();
				if ("ani__s".equals(columnName) || "customerPhoneNumber__s".equals(columnName)) {
					flag = true;
					break;
				}
			}
			if (flag) {
				fg.setOperator(Operator.OR);
			} else {
				fg.setOperator(Operator.AND);
			}
			fg.setValueFilters(filter);
			fgList.add(fg);
		}
		FilterGroup[] fgGroup = fgList.toArray(new FilterGroup[fgList.size()]);
		q.setFilterGroups(fgGroup);

		List<Aggregation> aggregations = new ArrayList<>();
		int id = 0;
		for (String cname : INT_COLS) {
			Aggregation a = new Aggregation(id++);
			a.setAggregationType(AggregationType.VALUE);
			a.setComputeColumnName(cname);
			aggregations.add(a);
		}
		q.setAggregations(
				aggregations.toArray(new Aggregation[aggregations.size()]));

		String awsUrl = analyzerAccessDetails.getBaseUrl() + "/csrs";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(awsUrl)
				.queryParam("anchorId", q.getAnchorId())
				.queryParam("q", new Gson().toJson(q));

		List<AnalyzerContact> contacts = new ArrayList<>();
		try {
			URI serviceUrl = builder.build().encode().toUri();

			ResponseEntity<String> userEntity = restTemplate.exchange(
					serviceUrl, HttpMethod.GET, requestEntity, String.class);

			if(userEntity == null) {
				return contacts;
			}
			String response = userEntity.getBody();
			lgr.info("Request: {}, and Response from {}: {}", requestEntity, serviceUrl, response);

			// parse data
			BufferedReader reader = new BufferedReader(
					new StringReader(response));
			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				if (line.equals(RequestType.SEG_PROFILE.name())) {
					break;
				}
				sb.append(line);
				sb.append("\n");
			}
			String metadataJson = sb.toString();
			lgr.debug("{} : metadata is {}", q.getAnchorId(), metadataJson);
			// Parse the csv now
			Iterable<CSVRecord> records = CSVFormat.RFC4180
					.withFirstRecordAsHeader().parse(reader);
			for (CSVRecord record : records) {
				// Read in the order of the INT_COLS array
				AnalyzerContact contact = new AnalyzerContact();
				contact.setAgentName(record.get("_0"));
				contact.setAni(record.get("_1"));
				contact.setSid(record.get("_2"));
				contact.setEntrypointName(record.get("_3"));
				contact.setCstts(NumberUtils.createLong(record.get("_4")));
				contact.setCetts(NumberUtils.createLong(record.get("_5")));
				contact.setChannelType(record.get("_6"));
				String transcript = record.get("_7");
				String outboundTranscript = record.get("_10");
				if (StringUtils.isEmpty(transcript)) {
					// Get the outboundTrascript__s, if outboundTrascript__s is
					// empty
					transcript = outboundTranscript;
				}
				contact.setTranscript(transcript);
				contact.setOutboundTranscript(outboundTranscript);
				contact.setTerminationType(record.get("_8"));
				if (!"null".equals(record.get("_9"))) {
					contact.setTalkDuration(
							NumberUtils.createLong(record.get("_9")));
				} else {
					contact.setTalkDuration(0L);
				}
				contact.setSubject(record.get("_11"));
				contact.setCustomerName(record.get("_12"));
				contact.setDnis(record.get("_13"));
				contact.setCallDirection(record.get("_14"));
				
				contacts.add(contact);
			}
			reader.close();
		} catch (IOException e) {
			lgr.error("Exception while fetching contacts from URL {}", awsUrl,
					e);
		}
		return contacts;
	}
	
	public void publishConsulting(AdaRequest adaRequest) {
		
		final DesktopConfiguration conf = configMap
				.getConfigForAgent(adaRequest.getagentSessionId());
		final String tenantId = conf.getEnterpriseId();		
		final String requestData = "{ \"timestamp\": \"now\", \"attrMap\": { } }";			
		String requestStr = null;
		String awsUrl = null;
		String dest = null;
		String result = null;
		
		// Send message for CARs
		awsUrl = analyzerAccessDetails.getBaseUrl()
				+ "/cars/incoming/active/acd";
		dest = "car";	
		requestStr = prepareRequest(adaRequest, requestData, dest);
		if (org.apache.commons.lang3.StringUtils.isNotBlank(requestStr)) {
			result = buildSendRequestEntityWithConsultInfo(tenantId, requestStr, awsUrl);
			if (org.apache.commons.lang3.StringUtils.isNotBlank(result)) {
				lgr.info("Consulting info sent successfully for CAR: ", awsUrl);
			} else {
				lgr.error("Consulting info was not sent successfully to CAR:", awsUrl);
			}
		}
		
		// Send message for AARs
		awsUrl = analyzerAccessDetails.getBaseUrl()
				+ "/aars/incoming/active/acd";
		dest = "aar";
		requestStr = prepareRequest(adaRequest, requestData, dest);
		if (org.apache.commons.lang3.StringUtils.isNotBlank(requestStr)) {
			result = buildSendRequestEntityWithConsultInfo(tenantId, requestStr, awsUrl);
			if(org.apache.commons.lang3.StringUtils.isNotBlank(result)) {
				lgr.info("Consulting info sent successfully for AAR: ", awsUrl);
			} else {
				lgr.error("Consulting info was not sent successfully to AAR:", awsUrl);
			}
		}	
	}
	public String getTenantCustomerData(String tenantId) {
		HttpEntity<?> requestEntity = buildRequestEntity(tenantId);
		String awsUrl = analyzerAccessDetails.getBaseUrl()
				+ "/auxiliary-data/resources/customer";
		String tenantCustomerData = null;
		try {
			URI serviceUrl = new URI(awsUrl);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> userEntity = restTemplate.exchange(serviceUrl,
					HttpMethod.GET, requestEntity, String.class);

			if (userEntity != null) {
				tenantCustomerData = userEntity.getBody();
			}
			lgr.debug("Response from {}: {}", serviceUrl,
					tenantCustomerData);
		} catch (Exception e) {
			lgr.error("Exception while fetching tenant customer data from AWS URL {}",
					awsUrl, e);
		}
		return tenantCustomerData;
	}
	
	private HttpEntity<?> buildRequestEntity(String tenantId) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("From", analyzerAccessDetails.getFrom());
		headers.set("Authorization", signedKey + "; tenantId=" + tenantId);
		HttpEntity<?> requestEntity = new HttpEntity<Object>(headers);
		return requestEntity;
	}

	private HttpEntity<?> buildRequestEntityWithUsername(String username) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("From", analyzerAccessDetails.getFrom());
		headers.set("Authorization", signedKey + "; user=" + username);
		HttpEntity<?> requestEntity = new HttpEntity<Object>(headers);
		return requestEntity;
	}

	private String buildSendRequestEntityWithConsultInfo(String tenantId, String requestStr, String awsUrl) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("From", analyzerAccessDetails.getFrom());
		headers.set("Authorization", signedKey + "; tenantId=" + tenantId);
		HttpEntity<?> requestEntity = new HttpEntity<Object>(requestStr, headers);
		
		// Send message to awsUrl
		String response = null;
		try {
			URI serviceUrl = new URI(awsUrl);
			lgr.info("Posting request to URL: {}, with the data payload : {} ",
					serviceUrl, requestStr);
			RestTemplate restTemplate = new RestTemplate();	
			ResponseEntity<String> respEntity = restTemplate.exchange(
					serviceUrl, HttpMethod.POST, requestEntity, String.class);
			
			if (respEntity != null) {
				response = respEntity.getBody();
			}
			lgr.info("Response from {}: {}: {}", awsUrl, response, requestEntity);
		} catch (Exception e) {
			lgr.error("Exception while saving UC Consulting details at URL {} : requestEntity {} : exception {}", 
					awsUrl, requestEntity, e);
		}
		return response;
	}

	private ValueQueryFilter createFilter(String colName, String ani) {
		ValueQueryFilter aniFilter = new ValueQueryFilter();
		aniFilter.setColumnName(colName);
		aniFilter.setOperator(OperatorType.EQUAL);
		aniFilter.setValue(ani);
		return aniFilter;
	}

	public void setPropertiesUtil(PropertiesUtil propertiesUtil) {
		this.propertiesUtil = propertiesUtil;
	}

	public String prepareRequest(
			AdaRequest adaRequest, String requestData, String destination) {
		
		final DesktopConfiguration conf = configMap
				.getConfigForAgent(adaRequest.getagentSessionId());
		
		String eventName = null;
		if (adaRequest.getConsultingType().equals("UC")) {
			eventName = "ucConsulting";
		}
		
		try {
			JSONObject requestJson = new JSONObject(requestData);
			requestJson.put("timestamp", adaRequest.getConsultTime());
			requestJson.put("eventName", eventName);
			if ("car".equals(destination)) {
				requestJson.put("entityId", adaRequest.getContactId());
			} else if ("aar".equals(destination)) {
				requestJson.put("entityId", adaRequest.getagentSessionId());
			}
			
			JSONObject attrMapObject = requestJson.getJSONObject("attrMap");
			attrMapObject.put("contactId", adaRequest.getContactId());
			attrMapObject.put("consultType", adaRequest.getConsultingType());
			attrMapObject.put("contactType", adaRequest.getContactType());
			attrMapObject.put("agentSessionId", adaRequest.getagentSessionId());
			attrMapObject.put("agentId", conf.getAgentId());

			attrMapObject.put("ucContact", adaRequest.getUcContact());
			lgr.debug("prepareRequest(): with : {}", requestJson.toString());
			return requestJson.toString();
		} catch (JSONException jsonException) {
			lgr.error("Error occurred: prepareRequest(): with JSONException: {}", jsonException);
		}
		return null;
	}
}
