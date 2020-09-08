package io.github.mrspock182.lambda.service.implementation;

import io.github.mrspock182.lambda.repository.Database;
import io.github.mrspock182.lambda.repository.orm.Order;
import io.github.mrspock182.lambda.service.OrderFindAllService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class OrderFindAllServiceImpl implements OrderFindAllService {

    private final Database<Order> database;

    public OrderFindAllServiceImpl(Database<Order> database) {
        this.database = database;
    }

    @Override
    public Flux<Order> findAll() {
        return database.findAll();
    }
}
