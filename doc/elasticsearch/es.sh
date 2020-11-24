#!/bin/bash

ES_HOME=/usr/server/es7.2

get_pid() {
  pid=$(ps -ef | grep $ES_HOME | grep -v grep | awk '{print $2}')
  echo "$pid"
}

status() {
  pid=$(get_pid)
  if [ -z "$pid" ]; then
    echo "No ES Server running"
  else
    echo "ES Server running on $pid"
  fi
  exit 0
}

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
  echo "Usage: $0 {start|stop|restart|status}"
  exit 0
  ;;
esac
