FROM openjdk:11
COPY target/AppPatient-0.0.1-SNAPSHOT.jar AppPatient-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/AppPatient-0.0.1-SNAPSHOT.jar"]

