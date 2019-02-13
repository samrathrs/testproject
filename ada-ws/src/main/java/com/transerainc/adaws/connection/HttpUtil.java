package com.transerainc.adaws.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import com.transerainc.adaws.constants.AdaConstants;
import com.transerainc.adaws.exception.CommunicationException;
import com.transerainc.adaws.exception.ServerNotFoundException;
import com.transerainc.adaws.model.ServerData;
import com.transerainc.tam.util.HttpStatus;
import com.transerainc.tam.util.IOUtil;

/**
 * @author rajeev.lochanam
 */
@Component
public class HttpUtil {
    private static Logger LOGGER = LoggerFactory.getLogger(HttpUtil.class.getName());

    private static final String HTTPS_PROTOCOL = "https://";
    private static final String HTTP_PROTOCOL = "http://";
    private static final int CONNECT_TIMEOUT = 5000;
    private static final String ENCODING = "UTF-8";
    
    private String response = null;
    private int responseCode = -1;

    /**
     * @param strUrl
     * @param params
     */
    public void doPost(final String strUrl, final Map<String, String> params) {
        try {
            postEncoded(strUrl, createUrlParams(params));
        } catch (final UnsupportedEncodingException e) {
            LOGGER.error("Unsupported encoding", e);
        }
    }

    /**
     * @param strUrl
     * @param encodedContent
     */
    private void postEncoded(final String strUrl, final String encodedContent) {
        try {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("Opening the URL: {}", strUrl);
            }
            final URL url = new URL(strUrl);
            final URLConnection conn = url.openConnection();
            if (conn instanceof HttpURLConnection) {
                final HttpURLConnection newConn = (HttpURLConnection) conn;
                wrapHttpConnection(newConn);

                newConn.setRequestMethod("POST");
                newConn.setDoOutput(true);
                final byte[] content = encodedContent.getBytes();
                newConn.setRequestProperty("Content-Length", String.valueOf(content.length));
                final OutputStream out = newConn.getOutputStream();
                out.write(content);
                out.flush();

                newConn.connect();
                final InputStream input = newConn.getInputStream();

                responseCode = newConn.getResponseCode();
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.info("responseCode: {}", responseCode);
                }

                if (isExpectedResponseCode()) {
                    response = getResponseAsString(input);
                    if (LOGGER.isInfoEnabled()) {
                        LOGGER.info("response: {}", response);
                    }
                }
                newConn.disconnect();
            }

        } catch (final Exception ex) {
            LOGGER.error("Post exception to " + strUrl, ex);
        }

    }

    /**
     * @param input
     * @return
     * @throws IOException
     */
    private String getResponseAsString(final InputStream input) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        final StringBuffer sb = new StringBuffer();
        final char[] buffer = new char[1024];
        int count = 0;
        while ((count = reader.read(buffer)) >= 0) {
            if (count > 0) {
                sb.append(buffer, 0, count);
            }
        }
        return sb.toString();
    }

    /**
     * @return
     */
    public String getResponse() {
        return response;
    }

    /**
     * @return
     */
    public boolean isExpectedResponseCode() {
        return responseCode >= 200 && responseCode < 400;
    }

    /**
     * @return
     */
    public int getResponseCode() {
        return responseCode;
    }

    /**
     * @param params
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String createUrlParams(final Map<String, String> params) throws UnsupportedEncodingException {
        if (params == null) { return ""; }

        final StringBuffer sb = new StringBuffer();

        for (final Iterator<Map.Entry<String, String>> it = params.entrySet().iterator(); it.hasNext();) {
            final Map.Entry<String, String> entry = it.next();
            sb.append(URLEncoder.encode(entry.getKey(), ENCODING));
            sb.append("=");
            String value = entry.getValue();
            value = value == null ? "" : value;
            sb.append(URLEncoder.encode(value, ENCODING));

            if (it.hasNext()) {
                sb.append('&');
            }
        }
        return sb.toString();
    }

    /**
     * @param conn
     */
    private void wrapHttpConnection(final HttpURLConnection conn) {
        try {
            conn.setConnectTimeout(CONNECT_TIMEOUT);
        } catch (final Exception e) {
            // running in 1.4. Ignore
        }
    }

    /**
     * @param params
     * @param serverData
     * @param isSecure
     * @param tacgContextPath
     * @return
     * @throws ServerNotFoundException
     */
    // public String doHttpPost(final Map<String, String> params, final ServerData serverData, final boolean isSecure,
    // final String tacgContextPath) throws ServerNotFoundException {
    public String doHttpPost(final String params, final ServerData serverData, final boolean isSecure,
            final String tacgContextPath) throws ServerNotFoundException {
        final String tacgUrl = (isSecure ? HTTPS_PROTOCOL : HTTP_PROTOCOL) + serverData.getHost() + ":"
                + serverData.getPort() + tacgContextPath;
        String tacgResponse = null;
        try {
            LOGGER.info("Posting request to TACG with the param : {} ", params);
            // tacgResponse = com.transerainc.tam.util.HttpUtil.doHttpPost(tacgUrl, params);
            tacgResponse = com.transerainc.tam.util.HttpUtil.doHttpXMLPost(tacgUrl, params);

        } catch (final SocketTimeoutException e) {
            // TODO: Ignoring in this release. TACG should respond before it makes the call back to ADA. Issue should be
            // fixed and then remove this catch block
        } catch (final HttpException e) {
            LOGGER.error("Exception occured while connecting to " + tacgUrl, e);
            throw new ServerNotFoundException(e);
        } catch (final IOException e) {
            LOGGER.error("Exception occured while connecting to " + tacgUrl, e);
            throw new ServerNotFoundException(e);
        }

        return tacgResponse;
    }

    /**
     * @param paramBody
     * @param hostPort
     * @param isSecure
     * @param tacgContextPath
     * @return
     * @throws ServerNotFoundException
     */
    public String doHeartBeatPost(final String paramBody, final String hostPort, final boolean isSecure,
            final String tacgContextPath) throws ServerNotFoundException {
        final String tacgUrl = (isSecure ? HTTPS_PROTOCOL : HTTP_PROTOCOL) + hostPort + tacgContextPath;
        HttpStatus tacgResponse = null;
        try {
            LOGGER.info("Posting heart beat to TACG: {} . Xml: and data: {}", tacgUrl,paramBody);
            // tacgResponse = com.transerainc.tam.util.HttpUtil.doHttpPost(tacgUrl, params);
            tacgResponse = com.transerainc.tam.util.HttpUtil.doHttpXMLPostReturningStatus(tacgUrl, paramBody);

        } catch (final HttpException e) {
            LOGGER.error("Exception occured while connecting to " + tacgUrl, e);
            throw new ServerNotFoundException(e);
        } catch (final IOException e) {
            LOGGER.error("Exception occured while connecting to " + tacgUrl, e);
            throw new ServerNotFoundException(e);
        }
        return tacgResponse.getResponse();
    }

    /**
     * @param url
     * @param data
     * @param headers
     * @return
     * @throws CommunicationException
     */
    public String doHttpJSONPut(final String url, final String data, final Map<String, String> headers)
            throws CommunicationException {
        return doHttpPut(url, data, headers, AdaConstants.CONTENT_TYPE_JSON);
    }

    /**
     * @param url
     * @param data
     * @param headers
     * @return
     * @throws CommunicationException
     */
    public static String doHttpJsonPost(final String url, final String data) {
    	String response = null;
        try {
            LOGGER.info("Posting request to URL: {}, with the data payload : {} ", url, data);
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            
	    		RestTemplate restTemplate = new RestTemplate();
	            HttpEntity<String> requestEntity = new HttpEntity<String>(data, headers);
	
	    		ResponseEntity<String> userEntity = restTemplate.postForEntity(url, requestEntity,String.class);
	
			if (userEntity != null) {
				response = userEntity.getBody();
			}
	    		LOGGER.info("Response from {}: {}", url, response);
        } catch (final Exception e) {
            LOGGER.error("Exception occured while connecting to URL: {}, with Exception: {}", url, e);
            throw e;
        }
    	
    	return response;
    }
    
    /**
     * @param url
     * @param data
     * @param headers
     * @return
     * @throws CommunicationException
     */
    public static String doHttpJsonPost(final String url, final String data, HttpServletResponse res) {
    	String response = null;
        try {
            LOGGER.info("Posting request to URL: {}, with the data payload : {} ", url, data);
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            
	    		RestTemplate restTemplate = new RestTemplate();
	        HttpEntity<String> requestEntity = new HttpEntity<String>(data, headers);
	
	    		ResponseEntity<String> userEntity = restTemplate.postForEntity(url, requestEntity, String.class);
	
			if (userEntity != null) {
				response = userEntity.getBody();
				res.setStatus(userEntity.getStatusCode().value());
			} else {
				LOGGER.error("NULL Http POST Response from {}: {}, statusCode= {}", url, response, res);
				res.setStatus(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR.value());
			}
	    		LOGGER.info("Response from {}: {}, statusCode= {}", url, response, res);
	    		
        } catch (final HttpServerErrorException hse) {
        		res.setStatus(hse.getStatusCode().value());
        		
        } catch (final HttpClientErrorException hce) {
        		res.setStatus(hce.getStatusCode().value());
    		
        } catch (final Exception e) {
        		res.setStatus(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR.value());
        		LOGGER.error("Exception occured while connecting to URL: {}, with Exception: {}", url, e);
            throw e;
        }
    	
    	return response;
    }

    /**
     * @param url
     * @param data
     * @param headers
     * @return
     * @throws CommunicationException
     */
    public String doHttpPut(final String url, final String data, final Map<String, String> headers,
            final String contentType) throws CommunicationException {

        final PutMethod method = new PutMethod(url);

        if (headers != null) {
            for (final Map.Entry<String, String> param : headers.entrySet()) {
                method.setRequestHeader(StringUtils.trim(param.getKey()), StringUtils.trim(param.getValue()));
            }
        }

        final HttpClient client = new HttpClient();
        try {
            method.setRequestEntity(new StringRequestEntity(data, contentType, AdaConstants.UTF8));
            client.executeMethod(method);
            return IOUtil.getInputAsString(method.getResponseBodyAsStream());
        } catch (final IOException e) {
            final String errorMsg = String.format("Exception while posting data url %s with params %s and headers %s",
                    url, data, headers);
            throw new CommunicationException(errorMsg, e);
        } finally {
            releaseResources(method, client);
        }

    }

    /**
     * @param strUrl
     * @param params
     */
    public void doGet(final String strUrl, final Map<String, String> params) {
        String fullUrl = strUrl;
        try {
            fullUrl = createGetUrl(strUrl, params);
            final URL url = new URL(fullUrl);
            final HttpURLConnection uc = (HttpURLConnection) url.openConnection();
            wrapHttpConnection(uc);

            final InputStream in = uc.getInputStream();
            response = getResponseAsString(in);
            responseCode = uc.getResponseCode();

            in.close();

        } catch (final UnsupportedEncodingException e) {
            // lastError = e;
            LOGGER.error("Unsupported encoding", e);
        } catch (final MalformedURLException e) {
            // lastError = e;
            LOGGER.error("Invalid URL: " + strUrl, e);
        } catch (final IOException e) {
            // lastError = e;
            LOGGER.error("Get request failed to " + fullUrl);
        }
    }

    private String createGetUrl(String url, final Map<String, String> params) throws UnsupportedEncodingException {

        if (url == null) { return null; }

        url = url.trim();

        if (StringUtils.isNotEmpty(url) && params != null && !params.isEmpty()) {

            final StringBuffer sb = new StringBuffer();
            sb.append(url);

            if (url.indexOf('?') == -1) {
                sb.append('?');
            } else if (!url.endsWith("?")) {
                sb.append('&');
            }

            sb.append(createUrlParams(params));

            return sb.toString();

        } else {
            return url;
        }
    }

    /**
     * @param method
     * @param client
     */
    private static void releaseResources(final HttpMethod method, final HttpClient client) {
        if (method != null) {
            try {
                method.releaseConnection();
            } catch (final Exception e) {
                // ignore
            }
        }
        if (client != null) {
            try {
                client.getHttpConnectionManager().closeIdleConnections(0);
            } catch (final Exception e) {
                // ignore
            }
        }
    }
    /**
     * @param url
     * @param data
     * @param headers
     * @return
     * @throws CommunicationException
     */
    public static String doHttpJsonPostAuth(final String url, final String data, final String authorization) {
    	String response = null;
        try {
            LOGGER.info("Posting request to URL: {}, with the data payload : {}, and authorization: {}", 
            		url, 
            		data, 
            		authorization);
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set(HttpHeaders.AUTHORIZATION, authorization);
            
    		RestTemplate restTemplate = new RestTemplate();
    		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
            HttpEntity<String> requestEntity = new HttpEntity<String>(data, headers);

    		ResponseEntity<String> userEntity = restTemplate.postForEntity(url, requestEntity,String.class);
			if (userEntity != null) {
				response = userEntity.getBody();
			}
    		LOGGER.debug("Response from {}: {}", url, response);
        } catch (final Exception e) {
            LOGGER.error("Exception occured while connecting to URL: {}, with Exception: {}", url, e);
            throw e;
        }
    	
    	return response;
    }
    
}
