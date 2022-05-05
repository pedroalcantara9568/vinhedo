# Vinhedo

- #### Docker

````
docker -v

Docker version 20.10.8, build 3967b7d
  ````

- #### docker-compose

````
docker-compose -v

docker-compose version 1.29.2, build 5becea4c
  ````


- #### Java 11
````
java -version

java version "11.0.12" 2021-07-20 LTS
OpenJDK Runtime Environment AdoptOpenJDK (build 11.0.9.1+1)
OpenJDK 64-Bit Server VM AdoptOpenJDK (build 11.0.9.1+1, mixed mode)
````

## Ambiente Linux

### Publicar imagem da aplicação:

````
./gradlew bootBuildImage
````

### Executar container
```
docker-compose -f docker-compose.yml up -d
``` 

## Ambiente Windows


````
./gradlew bootBuildImage
````

### Executar container
```
docker-compose -f docker-compose.yml up -d
``` 

# Swagger
http://localhost:8080/swagger-ui.html

