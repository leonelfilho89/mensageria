//RABBIT - qualquer pasta
docker run -d \
  --name rabbit-estudo \
  -p 1992:5672 \
  -p 1993:15672 \
  rabbitmq:3-management

//JAVA - raiz pasta java
mvn spring-boot:run

//NODE - raiz pasta node
node index.js
