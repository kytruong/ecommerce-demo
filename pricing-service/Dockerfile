FROM openjdk:8-jre-alpine

ADD ./build/libs/pricing-service-0.0.1-SNAPSHOT.jar /app/

CMD java -Xmx1024m -jar /app/pricing-service-0.0.1-SNAPSHOT.jar

EXPOSE 9002