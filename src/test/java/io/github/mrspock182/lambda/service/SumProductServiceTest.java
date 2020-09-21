package io.github.mrspock182.lambda.service;

import io.github.mrspock182.lambda.TestSetup;
import io.github.mrspock182.lambda.repository.orm.Order;
import io.github.mrspock182.lambda.repository.orm.Product;
import io.github.mrspock182.lambda.service.implementation.SumProductServiceImpl;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SumProductServiceTest extends TestSetup {

    @InjectMocks
    private SumProductServiceImpl service;

    @Override
    public void init() {

    }

    private Order getOrder() {
        List<Product> list = new ArrayList<>();
        list.add(new Product("Ticket-A", 11.5));
        list.add(new Product("Ticket-B", 6.3));
        list.add(new Product("Ticket-C", 18));
        return new Order("xpto", "Ronaldo", list, 0);
    }

    @Test
    public void sumTest() {
        Order order = this.service.sum(getOrder());
        assertEquals(35.8, order.getTotalPrice(), 0);
    }

}
