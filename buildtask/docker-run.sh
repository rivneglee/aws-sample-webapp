#!/usr/bin/env bash

CMD=$1

if [ ! -n "$CMD" ] ;then
    CMD=./entrypoint.sh
fi

docker rm -f greeting-app || echo "No started service found"

docker run -t -e NODE_NAME=${NODE_NAME} -p 80:8080 --rm --name=greeting-app stardustdocker/aws-sample-webapp