FROM openjdk:11
COPY "./target/client-0.0.1-SNAPSHOT.jar" "client-0.0.1-SNAPSHOT.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","client-0.0.1-SNAPSHOT.jar"]