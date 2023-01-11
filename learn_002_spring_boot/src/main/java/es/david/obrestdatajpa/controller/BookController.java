package es.david.obrestdatajpa.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import es.david.obrestdatajpa.entities.Book;
import es.david.obrestdatajpa.repository.BookRepository;

@RestController
public class BookController {

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

    // Crear un libro

    // Actualizar

    // Borrar

}
