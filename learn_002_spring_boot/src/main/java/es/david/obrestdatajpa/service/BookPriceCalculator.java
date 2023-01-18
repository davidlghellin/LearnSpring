package es.david.obrestdatajpa.service;

import es.david.obrestdatajpa.entities.Book;

public class BookPriceCalculator {

    public double calculatePrice(Book book) {
        // pasamos todo a centimos, para no tener posibles errores de precisión
        double price = book.getPrice() * 100;

        if (book.getPages() > 300) {
            price += 500.0;
        }
        price += 299.0;
        // volvemos a tener el precio en euros
        return price / 100;
    }
}
