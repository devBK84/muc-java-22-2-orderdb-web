package de.neuefische.mucjava222orderdbweb.service;

import de.neuefische.mucjava222orderdbweb.model.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductsTest {

    @Test
    void testRecord() {
        Product product1 = new Product("Erdbeeren", "8");
        Product product2 = new Product("Birne", "55");

        System.out.println(product1.name());
        System.out.println(product2.id());

        System.out.println(product1);
        System.out.println(product1.equals(product2));
    }

}