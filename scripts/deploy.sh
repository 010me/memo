#!/usr/bin/env bash

REPOSITORY=/home/ec2-user/cicdproject
cd$REPOSITORY

APP_NAME=cicdproject
JAR_NAME=$(ls$REPOSITORY/build/libs/|grep'SNAPSHOT.jar'|tail -n 1)
JAR_PATH=$REPOSITORY/build/libs/$JAR_NAME

CURRENT_PID=$(pgrep -f$APP_NAME)

# shellcheck disable=SC1073
# shellcheck disable=SC1035
# shellcheck disable=SC1020
# shellcheck disable=SC1072
# shellcheck disable=SC1019
# shellcheck disable=SC1069
# shellcheck disable=SC1009
if[-z$CURRENT_PID]
then
echo"> 종료할것 없음."
else
echo"> kill -9$CURRENT_PID"
kill-15$CURRENT_PID
sleep 5
fi

echo">$JAR_PATH배포"
nohup java -jar$JAR_PATH>/dev/null2>/dev/null</dev/null&