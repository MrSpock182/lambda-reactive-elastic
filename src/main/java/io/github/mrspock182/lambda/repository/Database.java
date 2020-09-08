package io.github.mrspock182.lambda.repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface Database<T> {
    Mono<T> save(T t);

    Flux<T> findAll();

    Mono<T> findById(String id);
}
