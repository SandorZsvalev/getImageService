FROM eclipse-temurin:17-alpine
LABEL authors="BlackBullet19"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} irs.jar

ENTRYPOINT ["java", "-jar", "./irs.jar"]