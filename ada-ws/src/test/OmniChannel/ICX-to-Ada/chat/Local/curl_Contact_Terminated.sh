curl  -i \
  -XPOST -H "Content-type: application/json" \
  --data @ContactTerminated.json \
  http://10.0.10.190:8080/ada-ws/handleOmni/chat/contactTerminate
