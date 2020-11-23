#!/bin/bash
today=`date +%Y.%m.%d`

a='log-basic-mdm-'${today}
b='log-service-admin-platform-'${today}
c='log-service-admin-web-'${today}
d='log-service-schedule-task-'${today}
e='log-service-student-client-'${today}
f='log-service-teacher-client-'${today}
g='log-zuul-server-'${today}
h='log-wechat-'${today}
i='log-remix-collector-'${today}
j='log-remix-data-'${today}
k='log-service-video-processer-'${today}


curl -f -XPOST -H 'Content-Type: application/json' -H 'kbn-xsrf: anything' "http://172.26.130.33:5601/api/saved_objects/index-pattern/${a}" -d"{\"attributes\":{\"title\":\"${a}\",\"timeFieldName\":\"@timestamp\"}}"

curl -f -XPOST -H 'Content-Type: application/json' -H 'kbn-xsrf: anything' "http://172.26.130.33:5601/api/saved_objects/index-pattern/${b}" -d"{\"attributes\":{\"title\":\"${b}\",\"timeFieldName\":\"@timestamp\"}}"

curl -f -XPOST -H 'Content-Type: application/json' -H 'kbn-xsrf: anything' "http://172.26.130.33:5601/api/saved_objects/index-pattern/${c}" -d"{\"attributes\":{\"title\":\"${c}\",\"timeFieldName\":\"@timestamp\"}}"

curl -f -XPOST -H 'Content-Type: application/json' -H 'kbn-xsrf: anything' "http://172.26.130.33:5601/api/saved_objects/index-pattern/${d}" -d"{\"attributes\":{\"title\":\"${d}\",\"timeFieldName\":\"@timestamp\"}}"

curl -f -XPOST -H 'Content-Type: application/json' -H 'kbn-xsrf: anything' "http://172.26.130.33:5601/api/saved_objects/index-pattern/${e}" -d"{\"attributes\":{\"title\":\"${e}\",\"timeFieldName\":\"@timestamp\"}}"

curl -f -XPOST -H 'Content-Type: application/json' -H 'kbn-xsrf: anything' "http://172.26.130.33:5601/api/saved_objects/index-pattern/${f}" -d"{\"attributes\":{\"title\":\"${f}\",\"timeFieldName\":\"@timestamp\"}}"

curl -f -XPOST -H 'Content-Type: application/json' -H 'kbn-xsrf: anything' "http://172.26.130.33:5601/api/saved_objects/index-pattern/${g}" -d"{\"attributes\":{\"title\":\"${g}\",\"timeFieldName\":\"@timestamp\"}}"

curl -f -XPOST -H 'Content-Type: application/json' -H 'kbn-xsrf: anything' "http://172.26.130.33:5601/api/saved_objects/index-pattern/${h}" -d"{\"attributes\":{\"title\":\"${h}\",\"timeFieldName\":\"@timestamp\"}}"

curl -f -XPOST -H 'Content-Type: application/json' -H 'kbn-xsrf: anything' "http://172.26.130.33:5601/api/saved_objects/index-pattern/${i}" -d"{\"attributes\":{\"title\":\"${i}\",\"timeFieldName\":\"@timestamp\"}}"

curl -f -XPOST -H 'Content-Type: application/json' -H 'kbn-xsrf: anything' "http://172.26.130.33:5601/api/saved_objects/index-pattern/${j}" -d"{\"attributes\":{\"title\":\"${j}\",\"timeFieldName\":\"@timestamp\"}}"

curl -f -XPOST -H 'Content-Type: application/json' -H 'kbn-xsrf: anything' "http://172.26.130.33:5601/api/saved_objects/index-pattern/${k}" -d"{\"attributes\":{\"title\":\"${k}\",\"timeFieldName\":\"@timestamp\"}}"
