package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product item1 = new Product(1, "Бананы", 40);
    Product item2 = new Product(222, "апельсины", 30);
    Product item3 = new Product(3, "орехи", 20);

    @Test
    public void deletingAnNonExistingElement() {
        ShopRepository repo = new ShopRepository();

        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(333);
        });
    }

    @Test
    public void deletingNonExistentNonExistent() {
        ShopRepository repo = new ShopRepository();

        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        repo.removeById(3);

        Product[] expected = {item1, item2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

}