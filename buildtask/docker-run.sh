#!/usr/bin/env bash

CMD=$1

if [ ! -n "$CMD" ] ;then
    CMD=./entrypoint.sh
fi

docker rm -f greeting-app || echo "No started service found"

docker run -t -p 8080:8080 --rm --name=greeting-app \
         stardustdocker/aws-sample-webapp \
         $CMD &