curl  -i \
  -XPOST -H "Content-type: application/json" \
  --data @ContactArrival.json \
  http://10.0.10.242:8080/ada-ws/handleOmni/chat/contactArrival
