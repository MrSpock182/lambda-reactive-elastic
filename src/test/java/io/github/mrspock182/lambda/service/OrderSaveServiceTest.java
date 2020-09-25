package io.github.mrspock182.lambda.service;

import io.github.mrspock182.lambda.TestSetup;
import io.github.mrspock182.lambda.domain.request.OrderRequest;
import io.github.mrspock182.lambda.repository.Database;
import io.github.mrspock182.lambda.repository.orm.Order;
import io.github.mrspock182.lambda.repository.orm.Product;
import io.github.mrspock182.lambda.service.implementation.OrderSaveServiceImpl;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class OrderSaveServiceTest extends TestSetup {

    @InjectMocks
    private OrderSaveServiceImpl service;

    @Mock
    private Database<Order> database;

    @Mock
    private SumProductService sumProductService;


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
    public void saveTest() {
        OrderRequest request = new OrderRequest("Ronaldo", list());
        when(database.save(any(Order.class))).thenReturn(Mono.just(getOrder()));
        when(sumProductService.sum(any(Order.class))).thenReturn(getOrder());
        service.save(request);
        verify(database).save(any(Order.class));
        verify(sumProductService).sum(any(Order.class));
    }

}
