#!/bin/bash

cd ../BotRest
mvn clean install

cd ..
docker-compose build
docker-compose up -d

docker tag projektstudio_bot-rest mkuzmik/app
docker push mkuzmik/app

docker commit database mkuzmik/app
docker push mkuzmik/app