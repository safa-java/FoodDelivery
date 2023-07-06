#base docker image 
FROM openjdk:17
LABEL maintainer="fooditems.net"
ADD target/FoodDeliveryApp-0.0.1-SNAPSHOT.jar FoodDeliveryApp.jar
ENTRYPOINT ["java","-jar","FoodDeliveryApp.jar"]
