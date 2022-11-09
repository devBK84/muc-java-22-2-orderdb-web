package de.neuefische.mucjava222orderdbweb.service;

import de.neuefische.mucjava222orderdbweb.model.Order;
import de.neuefische.mucjava222orderdbweb.model.Product;
import de.neuefische.mucjava222orderdbweb.repository.OrderRepository;
import de.neuefische.mucjava222orderdbweb.repository.ProductRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ShopServiceTest {

    ProductRepository productRepository = mock(ProductRepository.class);

    OrderRepository orderRepository = mock(OrderRepository.class);

    ShopService shopService = new ShopService(orderRepository,productRepository);

    @Test
    void listProducts_ShouldReturnCorrectOrder() {
        List<Products> expList = new ArrayList<>();

        when(productRepository.list()).thenReturn(new ArrayList<>());
        List<Product> result = shopService.listProducts();

        assertEquals(expList, result);
        verify(productRepository).list();
    }

    @Test
    void getProductByName_ShouldReturnAValidProducts() {

        String givenOrderName = "tshirt";
        Product exProducts = new Product(givenOrderName,"69");


        when(productRepository.get("69")).thenReturn(exProducts);
        Product result = shopService.getProduct("69");
        assertEquals(result, exProducts);

        verify(productRepository).get(any());
    }

    @Test
    void listOrders() {
        List<Order> expList = new ArrayList<>();

        when(orderRepository.list()).thenReturn(new ArrayList<>());
        List<Order> result = shopService.listOrders();

        assertEquals(expList, result);
        verify(orderRepository).list();
    }

    @Test
    void getOrder() {

        String givenOrderName = "69";
        Order exProducts = new Order (givenOrderName, new ArrayList<>());


        when(orderRepository.get("69")).thenReturn(exProducts);
        Order result = shopService.getOrder("69");
        assertEquals(result, exProducts);

        verify(orderRepository).get(any());
    }

    @Test
    void addOrder() {
        
        //Given
        String orderID = "69";
        Order actual = new Order();
        Order expected = new Order(orderID,Collections.emptyList());
        
        //When
        when(orderRepository.add(expected)).thenReturn (expected);
        List<String> ids = Collections.emptyList();
        Order result = shopService.addOrder(orderID, ids);
        
        
        //Then
        assertEquals(expected, result);
    }
}
