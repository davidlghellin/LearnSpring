package es.david.obrestdatajpa;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import es.david.obrestdatajpa.entities.Book;
import es.david.obrestdatajpa.repository.BookRepository;

@SpringBootApplication
public class ObRestDatajpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObRestDatajpaApplication.class, args);

		BookRepository repository = context.getBean(BookRepository.class);

		// Ejemplo que lo hacemos aquí, lo llevariamos a un servicio - controlador
		Book b = new Book(null, "uno", "one", 22, 20.0, LocalDate.of(2022, 10, 12), false);
		Book b2 = new Book(null, "dos", "two", 22, 20.0, LocalDate.of(2022, 10, 12), false);

		// almacenamos
		repository.save(b);
		repository.save(b2);

		// recuperamos
		List<Book> libros = repository.findAll();
		System.out.println("Tenemos los siguientes libros: " + libros.size());
		System.out.println("Tenemos los siguientes libros: " + libros);
		repository.deleteById(1L);
		System.out.println("Tenemos los siguientes libros: " + repository.findAll().size());
	}

}
