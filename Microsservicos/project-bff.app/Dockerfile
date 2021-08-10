FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/project-bff.app.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]