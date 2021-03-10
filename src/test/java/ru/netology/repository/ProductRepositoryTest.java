package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    Book book1 = new Book(1, "BookName1", 1000, "Author1", 500, 2019);
    Book book2 = new Book(2, "BookName2", 500, "Author2", 550, 2017);
    Book book3 = new Book(3, "BookName3", 700, "Author3", 400, 2020);
    Book book4 = new Book(4, "BookName4", 400, "Author2", 200, 2016);

    @BeforeEach
    public void setUp() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);
    }

    @Test
    void shouldRemoveByIDIfExistingElement() {
        repository.removeById(3);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book1, book2, book4};
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldRemoveByIdNotFoundException() {
        assertThrows(NotFoundException.class, () -> repository.removeById(5));
    }
}
