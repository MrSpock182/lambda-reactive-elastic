package io.github.mrspock182.lambda.service;

import io.github.mrspock182.lambda.data.ClientRequest;
import io.github.mrspock182.lambda.data.ClientResponse;
import reactor.core.publisher.Mono;

public interface ClientSaveService {
    Mono<ClientResponse> save(ClientRequest request);
}
