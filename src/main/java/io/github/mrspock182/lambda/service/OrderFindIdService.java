package io.github.mrspock182.lambda.service;

import io.github.mrspock182.lambda.repository.orm.Order;
import reactor.core.publisher.Mono;

public interface OrderFindIdService {
    Mono<Order> findId(String id);
}
