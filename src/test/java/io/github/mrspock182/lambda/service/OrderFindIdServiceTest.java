package io.github.mrspock182.lambda.service;

import io.github.mrspock182.lambda.TestSetup;
import io.github.mrspock182.lambda.repository.Database;
import io.github.mrspock182.lambda.repository.orm.Order;
import io.github.mrspock182.lambda.repository.orm.Product;
import io.github.mrspock182.lambda.service.implementation.OrderFindIdServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderFindIdServiceTest extends TestSetup {

    @InjectMocks
    private OrderFindIdServiceImpl service;

    @Mock
    private Database<Order> database;

    @Override
    public void init() {

    }

    private List<Product> list() {
        List<Product> list = new ArrayList<>();
        list.add(new Product("Ticket-A", 11.5));
        list.add(new Product("Ticket-B", 6.3));
        list.add(new Product("Ticket-C", 18));
        return list;
    }

    private Order getOrder() {
        return new Order("xpto", "Ronaldo", list(), 0);
    }

    @Test
    public void findIdTest() {
        when(database.findById(anyString())).thenReturn(Mono.just(getOrder()));
        service.findId("xpto");
        verify(database).findById(anyString());
    }

}
