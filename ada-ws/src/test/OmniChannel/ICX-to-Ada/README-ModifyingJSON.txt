==============================
MODIFYING an existing JSON
=================================
        - This is one way to modify an existing JSON using "jq".
        - jq can be installed on Windows, Mac, Linux ...
        - jq is installed on mccg01-eng for your use
        - https://stedolan.github.io/jq/manual/
        - https://stedolan.github.io/jq/tutorial/

Sample JSON
============

jnarain-mbp:workspace jnarain$ cat ConferenceAccepted.json
{
    "responseData": {
      "cduId": "fffae60b01f903200aee3250270f0000",
      "customerPkey": 2471,
      "to": "11",
      "memberName": "suresh"
    },
    "success": true,
    "message": "Success/Error message"
}


jq COMMAND to EDIT a Sample JSON
=================================
Example: "key": "value" = "sessionId": "ffe077c5000e001e0aee324fa0640000" is being added to ConferenceAccepted.json under responseData.
	
jnarain-mbp:workspace jnarain$ cat cmd.txt
jq '.responseData |= . + {"sessionId": "ffe077c5000e001e0aee324fa0640000"}' ConferenceAccepted.json > tmp.json


RUN COMMAND to EDIT a Sample JSON and Save in a TEMP File
==========================================================
jnarain-mbp:workspace jnarain$ jq '.responseData |= . + {"sessionId": "ffe077c5000e001e0aee324fa0640000"}' ConferenceAccepted.json > tmp.json

        MODIFIED Sample JSON
        =====================
        jnarain-mbp:workspace jnarain$ cat tmp.json
        {
          "responseData": {
          "cduId": "fffae60b01f903200aee3250270f0000",
          "customerPkey": 2471,
          "to": "11",
          "memberName": "suresh",
          "sessionId": "ffe077c5000e001e0aee324fa0640000"
        },
        "success": true,
        "message": "Success/Error message"
        }


RUN COMMAND to EDIT a Sample JSON
==================================
Example: An existing "value" for a "key" can be modified -- "sessionId": "ffe077c5000e001e0aee324fa0641234"

jnarain-mbp:workspace jnarain$ jq '.responseData |= . + {"sessionId": "ffe077c5000e001e0aee324fa0641234"}' tmp.json
{
  "responseData": {
    "cduId": "fffae60b01f903200aee3250270f0000",
    "customerPkey": 2471,
    "to": "11",
    "memberName": "suresh",
    "sessionId": "ffe077c5000e001e0aee324fa0641234"
  },
  "success": true,
  "message": "Success/Error message"
}
