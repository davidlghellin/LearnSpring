package es.david.obrestdatajpa.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;

import org.springframework.http.*;

import es.david.obrestdatajpa.entities.Book;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerTest {
    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @DisplayName("Comprobar StatusCode")
    @Test
    void helloStatusCode() {
        ResponseEntity<String> response = testRestTemplate.getForEntity("/hola", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @DisplayName("Comprobar hola StatusCodeValue")
    @Test
    void helloStatusCodeValue() {
        ResponseEntity<String> response = testRestTemplate.getForEntity("/hola", String.class);

        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void helloBody() {
        ResponseEntity<String> response = testRestTemplate.getForEntity("/hola", String.class);

        assertEquals("Hola mundo\n", response.getBody());
    }

    @Test
    void findAllStatusCode() {
        ResponseEntity<Book[]> response = testRestTemplate.getForEntity("/api/books", Book[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void findAllStatusCodeValue() {
        ResponseEntity<Book[]> response = testRestTemplate.getForEntity("/api/books", Book[].class);
        // este test y el anterior es lo mismo porque es estatus de ok es 200
        assertEquals(200, response.getStatusCodeValue());
        // otro test podria ser comprobar el tamaño:
        // List<Book> books = Arrays.asList(response.getBody());
    }

    @Test
    void findOneById() {

        ResponseEntity<Book> response = testRestTemplate.getForEntity("/api/books/1", Book.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void create() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = "{\n"
                + "\"title\": \"Libro creado desde Spring Test\",\n"
                + "\"author\": \"Yuval Noah\",\n"
                + "\"pages\": 650,\n"
                + "\"price\": 19.99,\n"
                + "\"releaseDate\": \"2019-12-01\",\n"
                + "\"online\": false\n"
                + "}";

        HttpEntity<String> request = new HttpEntity<>(json, headers);

        ResponseEntity<Book> response = testRestTemplate.exchange("/api/books", HttpMethod.POST, request, Book.class);
        Book result = response.getBody();

        // no lo estamos insertando
        assertEquals(1L, result.getId());
    }

    @Test
    public void createByBook() throws URISyntaxException {
        Book b = new Book(null, "uno", "one", 22, 20.0, LocalDate.of(2022, 10, 12), false);

        final String baseUrl = "http://localhost:" + port + "/api/books/";
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");

        HttpEntity<Book> request = new HttpEntity<>(b, headers);

        ResponseEntity<String> result = testRestTemplate.postForEntity(uri, request, String.class);

        assertEquals(200, result.getStatusCodeValue());
    }

}
