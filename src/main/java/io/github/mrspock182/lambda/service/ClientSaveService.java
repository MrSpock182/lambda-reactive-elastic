package io.github.mrspock182.lambda.service;

import io.github.mrspock182.lambda.domain.request.ClientRequest;
import io.github.mrspock182.lambda.domain.response.ClientResponse;
import reactor.core.publisher.Mono;

public interface ClientSaveService {
    Mono<ClientResponse> save(ClientRequest request);
}
