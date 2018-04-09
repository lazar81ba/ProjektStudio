FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/bot-rest-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS="-agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=n"

ENV SERVER_PORT=8080
ENV DEBUG_PORT=8000

EXPOSE $SERVER_PORT
EXPOSE $DEBUG_PORT

CMD ["java" ,"-Djava.security.egd=file:/dev/./urandom", "-jar" ,"/app.jar"]
