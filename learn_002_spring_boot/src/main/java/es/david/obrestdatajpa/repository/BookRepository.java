package es.david.obrestdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.david.obrestdatajpa.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
