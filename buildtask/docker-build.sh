#!/usr/bin/env bash

mvn clean package -Dmaven.test.skip=true
docker build --no-cache=true -f ./buildtask/Dockerfile -t stardustdocker/aws-sample-webapp:latest ./
