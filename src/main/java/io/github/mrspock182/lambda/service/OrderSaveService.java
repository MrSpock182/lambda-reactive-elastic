package io.github.mrspock182.lambda.service;

import io.github.mrspock182.lambda.domain.request.OrderRequest;
import io.github.mrspock182.lambda.repository.orm.Order;
import reactor.core.publisher.Mono;

public interface OrderSaveService {
    Mono<Order> save(OrderRequest order);
}
