package io.github.mrspock182.lambda.service.implementation;

import io.github.mrspock182.lambda.repository.Database;
import io.github.mrspock182.lambda.repository.orm.Order;
import io.github.mrspock182.lambda.service.OrderFindIdService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class OrderFindIdServiceImpl implements OrderFindIdService {

    private final Database<Order> database;

    public OrderFindIdServiceImpl(Database<Order> database) {
        this.database = database;
    }

    @Override
    public Mono<Order> findId(String id) {
        return database.findById(id);
    }
}
