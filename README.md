# Instructions to check the task

## Pre-requisites

Make sure you have at least Java version 11

In the root of the project, parent project, run: 

```bash
mvn clean package spring-boot:repackage
```
# Running the app

From terminal:

```bash
java -jar event-service-rest/target/event-service-rest-0.0.1-SNAPSHOT.jar
```

**Running Swagger**

Just open your browser in this address http://localhost:8080/swagger-ui/

Then you can try to create a new event and retrieve them from the Swagger UI