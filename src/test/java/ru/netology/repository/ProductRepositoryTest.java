package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;

public class ProductRepositoryTest {
    Product book1 = new Book(1, "Чудо-чудное", 2, "Я");
    Product book2 = new Book(2, "Диво-дивне", 5, "Он");
    Product book3 = new Book(3, "Прекрасное долёко", 9, "Она");

    Product smartphone1 = new Smartphone(11, "POP 32ГБ красный", 5200, "POP6");
    Product smartphone2 = new Smartphone(22, "Росфон 64ГБ синий", 15000, "Росфон1");
    Product smartphone3 = new Smartphone(33, "iphone 128ГБ", 62000, "iphone7");

    @Test
    public void saveAndRemoveTest() {
        ProductRepository repo = new ProductRepository();
        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(smartphone1);
        repo.add(smartphone2);
        repo.add(smartphone3);
        repo.removeById(22);
        repo.findAll();

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3, smartphone1, smartphone3};
        Assertions.assertArrayEquals(expected, actual);
    }
}