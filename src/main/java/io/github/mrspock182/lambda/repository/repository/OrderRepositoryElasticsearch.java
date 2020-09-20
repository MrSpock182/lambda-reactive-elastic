package io.github.mrspock182.lambda.repository.repository;

import io.github.mrspock182.lambda.repository.orm.Order;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositoryElasticsearch extends ElasticsearchRepository<Order, String> {
}