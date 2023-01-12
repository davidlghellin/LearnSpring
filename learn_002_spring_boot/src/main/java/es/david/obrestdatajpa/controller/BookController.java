package es.david.obrestdatajpa.controller;

import java.util.List;

import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import es.david.obrestdatajpa.entities.Book;
import es.david.obrestdatajpa.repository.BookRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class BookController {

    private final Logger log = LoggerFactory.getLogger(BookController.class);

    // CRUD sobre libros

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Buscar todos
    @GetMapping("/api/books")
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    // Buscar un libro
    @GetMapping("/api/book/{id}")
    public ResponseEntity<Book> findById(@PathVariable /*para mapear la variable del path*/ Long id) {
        Optional<Book> bookOpt = bookRepository.findById(id);
        return bookOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un libro
    @PostMapping("/api/books")
    public Book create(@RequestBody Book book, @RequestHeader HttpHeaders header){ //el parseo de json a book nos lo da jackson
        log.warn(header.get("User-Agent")+"");

        return bookRepository.save(book);
    }

    // Actualizar
    @PutMapping("/api/book")
    public ResponseEntity<Book> update(@RequestBody Book book){
        if(book.getId() == null ){ // si no tiene id quiere decir que sí es una creación
            log.warn("Trying to update a non existent book");
            return ResponseEntity.badRequest().build();
        }
        if(!bookRepository.existsById(book.getId())){
            log.warn("Trying to update a non existent book");
            return ResponseEntity.notFound().build();
        }

        // El proceso de actualización
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result); // el libro devuelto tiene una clave primaria
    }


    // Borrar

}
