package de.neuefische.mucjava222orderdbweb;

import de.neuefische.mucjava222orderdbweb.model.Product;
import org.junit.jupiter.api.Test;

class ProductTest {

    @Test
    void testRecord() {
        Product product1 = new Product("Banane", "1");
        Product product2 = new Product("Banane", "1");

        System.out.println(product1.id());
        System.out.println(product1.name());

        System.out.println(product1);

        System.out.println(product1.equals(product2));

        Product copy = new Product(product1.name() + "copy", product1.id());
        System.out.println(copy);
    }
}
