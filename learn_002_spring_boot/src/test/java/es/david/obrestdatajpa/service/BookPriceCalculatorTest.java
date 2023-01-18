package es.david.obrestdatajpa.service;

import static org.junit.jupiter.api.Assertions.*;

import es.david.obrestdatajpa.entities.Book;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class BookPriceCalculatorTest {
    @Test
    void calculatePriceTest() {

        // configuracion de la prueba
        Book book = new Book(1L, "El señor de los anillos", "Author", 1000, 49.99, LocalDate.now(), true);
        BookPriceCalculator calculator = new BookPriceCalculator();

        // se ejecuta el comportamiento a testear
        double price = calculator.calculatePrice(book);
        System.out.println(price);

        // comprobaciones aserciones
        assertTrue(price > 0);
        assertEquals(57.98 , price);

    }
}
