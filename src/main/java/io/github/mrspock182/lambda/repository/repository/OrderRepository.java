package io.github.mrspock182.lambda.repository.repository;

import io.github.mrspock182.lambda.exception.InternalServerError;
import io.github.mrspock182.lambda.exception.NotFound;
import io.github.mrspock182.lambda.repository.Database;
import io.github.mrspock182.lambda.repository.orm.Order;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Repository
public class OrderRepository implements Database<Order> {

    private final OrderRepositoryElasticsearch repository;

    public OrderRepository(OrderRepositoryElasticsearch repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Order> save(Order order) {
//        this.repository.save(order)
        return Mono.just(order)
                .doOnError(InternalServerError::new);
    }

    @Override
    public Flux<Order> findAll() {
        return Flux.fromIterable(repository.findAll())
                .doOnError(InternalServerError::new);
    }

    @Override
    public Mono<Order> findById(String id) {
        Optional<Order> order = repository.findById(id);
        if(order.isEmpty()) {
            throw new NotFound("Order don't exists");
        }
        return Mono.just(order.get())
                .doOnError(InternalServerError::new);
    }
}
