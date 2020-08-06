FROM openjdk:8-jdk-alpine

WORKDIR /usr/app
COPY build/libs/ping-pong-game-0.1.0.jar /usr/app/app.jar
EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]