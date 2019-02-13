curl  -i \
  -XPOST -H "Content-type: application/xml" \
  --data @tacg_response.xml \
  http://10.0.0.24:8080/ada-ws/handleTacgResponse
