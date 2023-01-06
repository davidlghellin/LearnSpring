# SpringJPA

Para poder ejecutar este ejemplo básico

```sh
mvn clean compile exec:java -Dexec.mainClass="es.david.ObSprindatajpaApplication"
```

## Dockerizar

Podemos meter la aplicación simple en el docker.

```sh
docker build -t dockerbasico .
docker run dockerbasico
```

Con estos tamaños

```sh
docker images          
REPOSITORY      TAG            IMAGE ID       CREATED              SIZE
dockerbasico    latest         bb268a4ccb45   About a minute ago   135MB
```

## Config de SonarQube

Se ha creado el docker-compose aparte, para poder usarlo usaremos la misma red.
Para hacerlo funcionar arrancaremos como siempre el docker-compose.
Debemos añadir el usario en administración -> generar un token y añadirlo en el pom.

```sh
mvn sonar:sonar
```
