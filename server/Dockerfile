FROM gcr.io/distroless/static-debian11
WORKDIR /app
USER apprunner
COPY target/presys-server.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
