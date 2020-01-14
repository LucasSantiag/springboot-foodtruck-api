FROM openjdk:8

ADD target/blablalba api-foodtruck.jar

EXPOSE 8086

ENTRYPOINT ["java", "-jar", "api-foodtruck.jar"]

