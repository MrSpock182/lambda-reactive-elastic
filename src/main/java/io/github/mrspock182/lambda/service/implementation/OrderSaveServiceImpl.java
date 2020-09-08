package io.github.mrspock182.lambda.service.implementation;

import io.github.mrspock182.lambda.data.OrderRequest;
import io.github.mrspock182.lambda.repository.Database;
import io.github.mrspock182.lambda.repository.orm.Order;
import io.github.mrspock182.lambda.service.OrderSaveService;
import io.github.mrspock182.lambda.service.SumProductService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class OrderSaveServiceImpl implements OrderSaveService {

    private final SumProductService sumProductService;
    private final Database<Order> database;

    public OrderSaveServiceImpl(SumProductService sumProductService, Database<Order> database) {
        this.database = database;
        this.sumProductService = sumProductService;
    }

    @Override
    public Mono<Order> save(OrderRequest order) {
        return database.save(sumProductService.sum(new Order(UUID.randomUUID().toString(),
                order.clientName, order.products, 0)));
    }
}
