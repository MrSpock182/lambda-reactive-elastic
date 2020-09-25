package io.github.mrspock182.lambda.repository.repository;

import io.github.mrspock182.lambda.repository.orm.Order;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositoryElasticsearch extends ReactiveCrudRepository<Order, String> {
}