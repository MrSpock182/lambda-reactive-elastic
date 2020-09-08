package io.github.mrspock182.lambda.service;

import io.github.mrspock182.lambda.repository.orm.Order;
import reactor.core.publisher.Flux;

public interface OrderFindAllService {
    Flux<Order> findAll();
}
