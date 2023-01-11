# SpringBoot

Página de creación de proyectos <https://start.spring.io>

```sh
docker network create sonar-network
```

Para lanzar

```sh
mvn clean compile exec:java -Dexec.mainClass="es.david.obrestdatajpa.ObRestDatajpaApplication"
```

## Entidad Book

- Book
- BookRepository
- BookService
- BookController

Se ha habilitado el primer endpoint muy simple.

```sh
http get 127.0.0.1:8080/hola
curl -i  127.0.0.1:8080/hola
```

Por otro lado se ha añadido el swagger.
<http://localhost:8080/swagger-ui/index.html>

```sh
http get 127.0.0.1:8080/api/books
```
