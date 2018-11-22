#!/bin/bash

docker pull mkuzmik/db
docker run --name database_0 -p 5432:5432 -d mkuzmik/db

docker pull mkuzmik/app
docker run --name bot-app --link database_0:postgres -p 8080:8080 -d mkuzmik/app