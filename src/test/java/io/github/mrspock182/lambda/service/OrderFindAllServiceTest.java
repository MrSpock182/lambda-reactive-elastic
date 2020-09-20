package io.github.mrspock182.lambda.service;

import io.github.mrspock182.lambda.TestSetup;
import io.github.mrspock182.lambda.repository.Database;
import io.github.mrspock182.lambda.repository.orm.Order;
import io.github.mrspock182.lambda.repository.orm.Product;
import io.github.mrspock182.lambda.service.implementation.OrderFindAllServiceImpl;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderFindAllServiceTest extends TestSetup {

    @InjectMocks
    private OrderFindAllServiceImpl service;

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

    private Stream<Order> getOrder() {
        return Lists.list(new Order("xpto", "Ronaldo", list(), 0)).stream();
    }

    @Test
    public void findAllTest() {
        when(database.findAll()).thenReturn(Flux.fromStream(getOrder()));
        service.findAll();
        verify(database).findAll();
    }

}
