package io.github.mrspock182.lambda.service.implementation;

import io.github.mrspock182.lambda.domain.response.ClientResponse;
import io.github.mrspock182.lambda.service.GenerateIdService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class GenerateIdServiceImpl implements GenerateIdService {

    @Override
    public Mono<ClientResponse> generate() {
        return Mono.just(new ClientResponse(UUID.randomUUID().toString(), ""));
    }
}
