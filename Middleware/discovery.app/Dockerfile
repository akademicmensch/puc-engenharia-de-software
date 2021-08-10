FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/discovery.app.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]