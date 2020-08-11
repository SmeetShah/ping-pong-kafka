FROM openjdk:8-jdk-alpine

WORKDIR /usr/app
ARG JAR_FILE
COPY ${JAR_FILE} /usr/app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
