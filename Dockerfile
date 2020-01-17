FROM maven:3.6.0-jdk-11-slim AS build

COPY src /home/app1/src
COPY pom.xml /home/app1
RUN mvn -f /home/app1/pom.xml package


FROM anapsix/alpine-java

COPY --from=build /home/app1/target/vanyRestApi-0.0.1-SNAPSHOT.jar /opt/lib/app.jar

COPY ./projectConfig/EntryPoint.sh /EntryPoint.sh

RUN chmod +x /EntryPoint.sh

# Execuiting the run.sh file
ENTRYPOINT ["/EntryPoint.sh"]
