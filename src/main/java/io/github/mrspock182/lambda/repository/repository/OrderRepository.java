package io.github.mrspock182.lambda.repository.repository;

import io.github.mrspock182.lambda.exception.InternalServerError;
import io.github.mrspock182.lambda.exception.NotFound;
import io.github.mrspock182.lambda.repository.Database;
import io.github.mrspock182.lambda.repository.orm.Order;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;
import org.springframework.stereotype.Repository;
import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@EnableReactiveElasticsearchRepositories
public class OrderRepository implements Database<Order> {

    private final OrderRepositoryElasticsearch repository;

    public OrderRepository(OrderRepositoryElasticsearch repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Order> save(Order order) {
        return this.repository.save(order)
                .doOnError(ex -> new InternalServerError(ex.getMessage()));
    }

    @Override
    public Flux<Order> findAll() {
        try {
            return repository.findAll()
                    .doOnError(ex -> new InternalServerError(ex.getMessage()));
        } catch (Exception ex) {
            throw new InternalServerError(ex);
        }
    }

    @Override
    public Mono<Order> findById(String id) {
        try {
            return repository.findById(id)
                    .switchIfEmpty(Mono.error(Exceptions.propagate(new NotFound("Don't exists order by " + id))))
                    .doOnError(ex -> new InternalServerError(ex.getMessage()));
        } catch (Exception ex) {
            throw new InternalServerError(ex);
        }
    }
}
