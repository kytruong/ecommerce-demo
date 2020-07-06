FROM openjdk:8-jre-alpine

ADD ./build/libs/zuul-service-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/zuul-service-0.0.1-SNAPSHOT.jar"]

EXPOSE 8762