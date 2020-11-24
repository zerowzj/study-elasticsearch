#!/bin/bash
#
ES_HOME=/usr/server/es7.2
tt=org.elasticsearch.bootstrap.Elasticsearch
#
get_pid() {
  pid=$(ps -ef | grep $tt | grep -v grep | awk '{print $2}')
  echo "$pid"
}
#
status() {
  pid=$(get_pid)
  if [ -z "$pid" ]; then
    echo "No ES Server running"
  else
    echo "ES Server running on $pid"
  fi
  exit 0
}
#
start() {
  echo "Starting server ..."
  pid=$(get_pid)
  if [ -n "$pid" ]; then
    /usr/bin/sudo kill -9 $pid
  fi
  $ES_HOME/bin/elasticsearch -d
  sleep 1
  pid=$(get_pid)
  if [ $? -eq 0 ]; then
    echo "STARTED PID: $pid"
  else
    echo "ERROR: Start failure![code: $?]"
  fi
  exit 0
}
#
stop() {
  echo "Stopping server ... "
  pid=$(get_pid)
  if [ -z "$pid" ]; then
    echo "ERROR: No server to stop!"
    return 0
  fi
  #sudo kill $pid
  /usr/bin/sudo kill -9 $pid
  if [ $? -eq 0 ]; then
    echo "STOPPED PID: $pid"
  else
    echo "ERROR: Stop failure![code: $?]"
  fi
  exit 0
}
#
case $1 in
start)
  start
  ;;
stop)
  stop
  ;;
status)
  status
  ;;
*)
  echo "Usage: $0 {start|stop|status}"
  exit 0
  ;;
esac
