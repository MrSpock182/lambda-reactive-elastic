package io.github.mrspock182.lambda.service;

import io.github.mrspock182.lambda.domain.request.ClientRequest;
import io.github.mrspock182.lambda.domain.response.ClientResponse;
import reactor.core.publisher.Mono;

public interface ClientResponseService {
    Mono<ClientResponse> create(ClientResponse response, ClientRequest request);
}
