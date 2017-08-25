Presys — Server
===============

## Kjøre applikasjonen lokalt

1. Opprett lokal konfigurasjon, eksempelvis `application.properties` i gjeldende mappe:

	```
	spring.datasource.url=jdbc:oracle:thin:@localhost
	spring.datasource.username=presysbruker
	spring.datasource.password=presysbruker
	spring.datasource.driver-class-name=oracle.jdbc.driver.OracleDriver
	
	jwt.password=somesecret
	
	ldap.url=ldap://ldapgw.test.local
	ldap.basedn=dc=test,dc=local
	ldap.domain=TEST.LOCAL
	```
	
2. Start applikasjonen

	```
	mvn spring-boot:run
	```
	
	`spring-boot:run` vil sette `dev` som gjeldende profil, slik at en kan ha innstillinger i en `application-dev.properties`-fil også.

