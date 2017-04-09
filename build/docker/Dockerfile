FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /app
ADD postcode-search-1.0-SNAPSHOT.jar postcode-search-1.0-SNAPSHOT.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/postcode-search-1.0-SNAPSHOT.jar"]
