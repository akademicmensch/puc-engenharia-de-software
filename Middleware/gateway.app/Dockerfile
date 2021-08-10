FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/gateway.app.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]