FROM adoptopenjdk:11-jdk-hotspot
RUN addgroup spring
RUN adduser spring --ingroup spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} api.jar
ENTRYPOINT ["java", "-jar", "/api.jar"]

#docker run -p 8080:8080 --user 1001  powerapp:latest .
