FROM openjdk:8
EXPOSE 8080
ADD target/Banking_app_java.jar Banking_app_java.jar
ENTRYPOINT ["java","-jar","/Banking_app_java.jar"]
