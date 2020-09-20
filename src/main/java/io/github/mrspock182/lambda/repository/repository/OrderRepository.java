package io.github.mrspock182.lambda.repository.repository;

import io.github.mrspock182.lambda.exception.InternalServerError;
import io.github.mrspock182.lambda.exception.NotFound;
import io.github.mrspock182.lambda.repository.Database;
import io.github.mrspock182.lambda.repository.orm.Order;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Repository
@EnableReactiveElasticsearchRepositories
public class OrderRepository implements Database<Order> {

    private final OrderRepositoryElasticsearch repository;

    public OrderRepository(OrderRepositoryElasticsearch repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Order> save(Order order) {
        try {
            return Mono.just(this.repository.save(order));
        } catch (Exception ex) {
            throw new InternalServerError(ex);
        }
    }

    @Override
    public Flux<Order> findAll() {
        try {
            return Flux.fromIterable(repository.findAll());
        } catch (Exception ex) {
            throw new InternalServerError(ex);
        }
    }

    @Override
    public Mono<Order> findById(String id) {
        try {
            Optional<Order> order = repository.findById(id);
            if(order.isEmpty()) {
                throw new NotFound("Order don't exists");
            }
            return Mono.just(order.get());
        } catch (Exception ex) {
            throw new InternalServerError(ex);
        }
    }
}
