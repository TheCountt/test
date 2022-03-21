FROM java:8

# Install maven
RUN apt-get update
RUN apt-get install -y maven

WORKDIR /tests

# Prepare by downloading dependencies
ADD pom.xml /tests/pom.xml
RUN ["mvn", "dependency:resolve"]
#RUN ["mvn", "verify"]

# Adding source, compile and package into a fat jar
ADD src /tests/src
RUN ["mvn", "package"]

EXPOSE 4567
CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "target/unicorn-0.0.1-SNAPSHOT.jar"]
#CMD["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "target/sparkexample-jar-with-dependencies.jar"]
