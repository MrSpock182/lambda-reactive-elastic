package io.github.mrspock182.lambda.service;

import io.github.mrspock182.lambda.domain.ClientRequest;
import io.github.mrspock182.lambda.domain.ClientResponse;
import reactor.core.publisher.Mono;

public interface ClientResponseService {
    Mono<ClientResponse> create(ClientResponse response, ClientRequest request);
}
