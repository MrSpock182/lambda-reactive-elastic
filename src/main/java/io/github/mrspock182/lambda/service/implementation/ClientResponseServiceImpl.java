package io.github.mrspock182.lambda.service.implementation;

import io.github.mrspock182.lambda.domain.ClientRequest;
import io.github.mrspock182.lambda.domain.ClientResponse;
import io.github.mrspock182.lambda.service.ClientResponseService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ClientResponseServiceImpl implements ClientResponseService {
    @Override
    public Mono<ClientResponse> create(ClientResponse response, ClientRequest request) {
        return Mono.just(new ClientResponse(response.getId(), createFullName(request)));
    }

    private String createFullName(ClientRequest request) {
        return request.getFirstName() + " " + request.getLastName();
    }

}
