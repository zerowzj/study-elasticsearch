#!/bin/bash
#定时清除elk索引，7天
DATE=`date -d "7 days ago" +%Y.%m.%d`
echo $DATE

curl -XDELETE "172.26.130.33:9200/log-basic-mdm-${DATE}"

curl -XDELETE "172.26.130.33:9200/log-service-admin-platform-${DATE}"

curl -XDELETE "172.26.130.33:9200/log-service-admin-web-${DATE}"

curl -XDELETE "172.26.130.33:9200/log-service-schedule-task-${DATE}"

curl -XDELETE "172.26.130.33:9200/log-service-student-client-${DATE}"

curl -XDELETE "172.26.130.33:9200/log-service-teacher-client-${DATE}"

curl -XDELETE "172.26.130.33:9200/log-zuul-server-${DATE}"

curl -XDELETE "172.26.130.33:9200/log-remix-collector-${DATE}"

curl -XDELETE "172.26.130.33:9200/log-remix-data-${DATE}"

curl -XDELETE "172.26.130.33:9200/log-service-video-processer-${DATE}"
