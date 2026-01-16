FROM ghcr.io/navikt/baseimages/temurin:11
WORKDIR /app
USER apprunner
COPY target/presys-server.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
