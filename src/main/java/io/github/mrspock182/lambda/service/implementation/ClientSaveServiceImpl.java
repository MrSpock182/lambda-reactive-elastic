package io.github.mrspock182.lambda.service.implementation;

import io.github.mrspock182.lambda.domain.request.ClientRequest;
import io.github.mrspock182.lambda.domain.response.ClientResponse;
import io.github.mrspock182.lambda.exception.BadRequest;
import io.github.mrspock182.lambda.service.ClientSaveService;
import io.github.mrspock182.lambda.service.ClientResponseService;
import io.github.mrspock182.lambda.service.GenerateIdService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ClientSaveServiceImpl implements ClientSaveService {

    private final GenerateIdService generateIdService;
    private final ClientResponseService clientResponseService;

    public ClientSaveServiceImpl(GenerateIdService generateIdService, ClientResponseService clientResponseService) {
        this.generateIdService = generateIdService;
        this.clientResponseService = clientResponseService;
    }

    @Override
    public Mono<ClientResponse> save(ClientRequest request) {
        if("Kleber".equalsIgnoreCase(request.getFirstName())) {
            throw new BadRequest("This name don't work");
        }

        return generateIdService.generate()
                .flatMap(base -> clientResponseService.create(base, request));
    }
}
