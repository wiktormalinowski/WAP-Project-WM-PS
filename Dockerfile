FROM openjdk:17-jdk

WORKDIR /auction-app
COPY target/auction-app-1.0.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]