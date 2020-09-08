package io.github.mrspock182.lambda.service.implementation;

import io.github.mrspock182.lambda.data.ClientRequest;
import io.github.mrspock182.lambda.data.ClientResponse;
import io.github.mrspock182.lambda.exception.BadRequest;
import io.github.mrspock182.lambda.service.ClientSaveService;
import io.github.mrspock182.lambda.service.ClientResponseService;
import io.github.mrspock182.lambda.service.GenerateIdService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ClientSaveServiceImpl implements ClientSaveService {

    private final GenerateIdService generateIdService;
    private final ClientResponseService createFullNameService;

    public ClientSaveServiceImpl(GenerateIdService generateIdService, ClientResponseService createFullNameService) {
        this.generateIdService = generateIdService;
        this.createFullNameService = createFullNameService;
    }

    @Override
    public Mono<ClientResponse> save(ClientRequest request) {
        if("Kleber".equalsIgnoreCase(request.firstName)) {
            throw new BadRequest("This name don't work");
        }

        return generateIdService.generate()
                .flatMap(base -> createFullNameService.create(base, request));
    }
}
