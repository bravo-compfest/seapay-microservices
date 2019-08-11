FROM openjdk:11 as build

WORKDIR /opt/seapay
VOLUME /opt/seapay
EXPOSE 8080

RUN apt-get update
RUN apt-get install -y build-essential postgresql-client vim

# VOLUME /tmp
# COPY seapay-catalog/build/libs/*.jar app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]