package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;
import ru.netology.manager.ProductManager;

public class ProductManagerTest {
    Product book1 = new Book(1, "Чудо-чудное", 2, "Я");
    Product book2 = new Book(2, "Диво-дивне", 5, "Он");
    Product book3 = new Book(3, "Прекрасное долёко", 9, "Она");

    Product smartphone1 = new Smartphone(11, "POP 32ГБ красный", 5200, "POP6");
    Product smartphone2 = new Smartphone(22, "Росфон 64ГБ синий", 15000, "Росфон1");
    Product smartphone3 = new Smartphone(33, "iphone 128ГБ", 62000, "iphone7");

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    @Test
    public void shouldSearchByText() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("но");
        Product[] expected = {book1, book3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByText1() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("on");
        Product[] expected = {smartphone3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveBySearchId() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        manager.removeById(11);
        manager.findAll();

        Product[] actual = manager.findAll();
        Product[] expected = {book1, book2, book3, smartphone2, smartphone3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveBySearchId1() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        manager.removeById(11);
        manager.findAll();

        Product[] actual = manager.searchBy("ос");
        Product[] expected = {smartphone2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldEmpty() {
        manager.findAll();

        Product[] actual = manager.findAll();
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void matchesTest() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("грибы");
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }
}
