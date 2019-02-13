curl  -i \
  -XPOST -H "Content-type: application/json" \
  --data @ConferenceAccepted.json \
  http://mccg01-eng.transerainc.com:9412/ada-ws/handleOmni/chat/conferenceAccept
