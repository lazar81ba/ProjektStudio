# ProjektStudio

## Overview
This repository contains university project.

## How to run

This project require a few tool to run:
- Java 8
- Maven
- Docker
- Docker Compose

If you are using Windows or Mac, you will additionally need:
- VirtualBox
- Docker Machine

## For Mac and Windows only
We need to create virtual machine for docker:

```
# run this command only once
docker-machine create --driver virtualbox --virtualbox-cpu-count "1" --virtualbox-memory "2048" docker-bot
```
Remember, when you create docker-bot machine, it remains on you computer until you delete it. You need
to run above command only once.

Once docker-machine is created, we should start it:
```
# run this command every time after restart of your computer
docker-machine start docker-bot
# WINDOWS : run this command and follow instructions
docker-machine env docker-bot
# MAC : run this command every time after opening new terminal
eval $(docker-machine env docker-bot)
```

## Build an current version of this project
To build project you need to run below command in these subdirectories: \BotRest
```
# run this command after any changes in application code
mvn  clean install
```

Once you app is successfully built, you need to proceed to parrent directory and execute below command:
```
docker-compose up
```

```
# run these commands every time you want to restart an application
docker-compose build
docker-compose up -d
```

You can check IP address of you docker machine by command:
```
docker-machine ip docker-bot
```

You can access your app by typing in you browser:
```
<your docker-machine ip address>:8080
# for example: 192.168.99.100:8080
```

## Connecting to databases

Requirements:
- Postgres

```
psql -h <docker machine ip address> -p <database port> -U postgres
# for example: psql -h 192.168.99.100 -p 5432 -U postgres
```

Then you can type SQL directly to database.

## Authors
- Bartłomiej Łazarczyk
- Jakub Kacorzyk
