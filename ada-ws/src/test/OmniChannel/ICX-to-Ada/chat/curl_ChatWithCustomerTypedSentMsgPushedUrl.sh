curl  -i \
  -XPOST -H "Content-type: application/json" \
  --data @ChatCustomerTypedMsg.json \
  http://mccg01-eng.transerainc.com:9412/ada-ws/handleOmni/chat/messageReception
