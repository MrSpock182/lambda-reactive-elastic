package io.github.mrspock182.lambda.repository.repository;

import io.github.mrspock182.lambda.exception.InternalServerError;
import io.github.mrspock182.lambda.exception.NotFound;
import io.github.mrspock182.lambda.repository.Database;
import io.github.mrspock182.lambda.repository.orm.Order;
import org.springframework.stereotype.Repository;
import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public class OrderRepository implements Database<Order> {

    private final OrderRepositoryElasticsearch repository;

    public OrderRepository(OrderRepositoryElasticsearch repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Order> save(Order order) {
        return this.repository.save(order)
                .doOnError(InternalServerError::new);
    }

    @Override
    public Flux<Order> findAll() {
        return repository.findAll()
                .doOnError(InternalServerError::new);
    }

    @Override
    public Mono<Order> findById(String id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(Exceptions.propagate(new NotFound("Don't exists order by " + id))))
                .doOnError(InternalServerError::new);
    }
}
