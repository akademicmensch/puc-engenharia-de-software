FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/auth-core.app.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]