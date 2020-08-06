FROM openjdk:8-jdk-alpine

WORKDIR /usr/app
COPY build/libs/ping-pong-game-${project.version}.jar /usr/app/app.jar
EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]