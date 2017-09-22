FROM openjdk:8-jre-alpine

COPY target/*.jar /usr/app/presys.jar
WORKDIR /usr/app

ENV LDAP_URL="" \
    LDAP_DOMAIN="" \
    LDAP_BASEDN="" \
    JWT_PASSWORD="" \
    PRESYSDB_URL="" \
    PRESYSDB_USERNAME="" \
    PRESYSDB_PASSWORD=""

EXPOSE 8080

CMD ["java", "-XX:+UnlockExperimentalVMOptions", \
    "-XX:+UseCGroupMemoryLimitForHeap", \
    "-Dspring.profiles.active=nais", \
    "-jar", "/usr/app/presys.jar"]
