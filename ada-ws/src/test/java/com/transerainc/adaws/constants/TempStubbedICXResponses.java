package com.transerainc.adaws.constants;

public interface TempStubbedICXResponses {

	final String RESPONSE_1 = "{ \"mmResponse\": { \"responseData\": { \"omniChannelQueueId\": 0 }, \"success\": true, \"message\": \"Success/Error message\" }}";
	final String RESPONSE_2 = "{ \"mmResponse\": { \"responseData\": { \"cduId\": \"ffe9fded01d703200aee3250270f0000\", \"omniChannelQueueId\": 0 }, \"success\": true, \"message\": \"Success/Error message\" } }";
	final String RESPONSE_3 = "{ \"mmResponse\": { \"responseData\": { \"status\": 1, \"sendTime\": \"1492581616575\" }, \"success\": true, \"message\": \"Success/Error message\" } }";
	final String RESPONSE_4 = "{ \"mmResponse\": { \"responseData\": { \"agentset\": [ { \"id\": 14, \"username\": \"amar\", \"preferredName\": \"Amar\" } ], \"omniChannelQueueId\": 5 }, \"success\": true, \"message\": \"Success/Error message\" } }";
	final String RESPONSE_5 = "{ \"mmResponse\": { \"responseData\": { \"status\": 1, \"sendTime\": \"19-Apr-17 06.58.16 AM\" }, \"success\": true, \"message\": \"Success/Error message\" } }";
	final String RESPONSE_6 = "{ \"mmResponse\": { \"responseData\": { \"emailBody\": \"<Email body>\"}, \"success\": true, \"message\": \"Success/Error message\"}}";
	final String RESPONSE_7 = "{ \"mmResponse\": { \"responseData\": { \"size\": 30,\"filePath\": \"/opt/file-store/attachments/Temp\"}, \"success\": true, \"message\": \"Success/Error message\"}}";
	final String RESPONSE_8 = "{ \"mmResponse\": { \"responseData\": { \"emailDrafts\": [ { \"outboundId\": 445, \"cduId\": \"19cf9000000101200aee3250270f0000\", \"subject\": \"test subject\", \"messageTitle\": \"Plain text summary\"} ] }, \"success\": true, \"message\": \"Success/Error message\"}}";
	final String RESPONSE_9 = "{ \"mmResponse\": { \"responseData\": { \"sessionId\": \"ffe077c5000e001e0aee324fa0640000\", \"agents\": [ { \"id\": 1, \"name\": \"Agent1\", \"status\": \"Available\" }, { \"id\": 2, \"name\": \"Agent2\", \"status\": \"Unavailable\" }, { \"id\": 3, \"name\": \"Agent3\",\"status\": \"Occupied\" } ], \"success\": true, \"message\": \"Success/Error message\"}}}";	
	final String RESPONSE_10 = "{ \"mmResponse\": {\"responseData\": { \"sessionId\": \"ffe077c5000e001e0aee324fa0640000\",\"queues\": [{\"id\": 1,\"name\": \"emailQ1\"},{ \"id\": 2,\"name\": \"emailQ2\"}]}, \"success\": true,\"message\": \"Success/Error message\"}}";
	final String LOGIN_RESPONSE = "{ \"mmResponse\": {\"action\": \"OmniChannelAgentLogin\",\"responseData\": {\"channels\": [{\"id\": 1,\"name\": \"Email\", \"omniChannelQueues\": [{\"id\": 111,\"name\": \"Email Q1\"},{\"id\": 222,\"name\": \"Email Q2\"}]},{\"id\": 3,\"name\": \"Chat\",\"omniChannelQueues\": [{\"id\": 333,\"name\": \"Email Q1\"},{\"id\": 444,\"name\": \"Chat Q2\"}]}],\"fileServer\": \"<host>:<port>/file-server\"},\"success\": true, \"message\": \"Authentication successful\"}} ";
	final String STATE_CHANGE_RESP1 = "{ \"mmResponse\": { \"responseData\": {}, \"success\": true, \"message\": \"Success/Error message\"} }";
	final String STATE_CHANGE_RESP2 = "{ \"mmResponse\" :{ \"responseData\": { \"auxCodeId\": 2715, \"auxCodeName\": \"defaultIdle\" }, \"success\": true, \"message\": \"Success/Error message\" } } ";
	
}
