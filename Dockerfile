FROM openjdk:22-jdk-slim


ADD target/WebAppSpringSecurity-0.0.1-SNAPSHOT.jar WebAppSpringSecurity.jar

ENTRYPOINT ["java", "-jar", "WebAppSpringSecurity.jar"]