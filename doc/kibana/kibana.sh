#!/bin/sh
#
# Simple Redis init.d script conceived to work on Linux systems
# as it does use of the /proc filesystem.

### BEGIN INIT INFO
# Provides:     redis_6379
# Default-Start:        2 3 4 5
# Default-Stop:         0 1 6
# Short-Description:    Redis data structure server
# Description:          Redis data structure server. See https://redis.io
### END INIT INFO

KIBANA_HOME=/usr/server/kibana7.2
EXEC=$KIBANA_HOME/bin/kibana
PID_FILE=$KIBANA_HOME/kibana.pid

case "$1" in
start)
  if [ -f $PID_FILE ]; then
    echo "$PIDFILE exists, process is already running or crashed"
  else
    echo "Starting ..."
    nohup $EXEC 2>&1 &
    if [[ $? -eq 0 ]]; then
      echo $! >${PID_FILE}
    fi
  fi
  ;;
stop)
  if [ ! -f $PID_FILE ]; then
    echo "$PIDFILE does not exist, process is not running"
  else
    echo "Stopping ..."
    kill -9 $(cat ${PID_FILE})
    if [[ $? -eq 0 ]]; then
      rm -f ${PID_FILE}
    else
      exit 1
    fi
  fi
  ;;
*)
  echo "Please use start or stop as first argument"
  ;;
esac
