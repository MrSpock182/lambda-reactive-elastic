package io.github.mrspock182.lambda.service;

import io.github.mrspock182.lambda.TestSetup;
import io.github.mrspock182.lambda.domain.request.ClientRequest;
import io.github.mrspock182.lambda.domain.response.ClientResponse;
import io.github.mrspock182.lambda.service.implementation.ClientResponseServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ClientResponseServiceTest extends TestSetup {

    @InjectMocks
    private ClientResponseServiceImpl service;

    @Override
    public void init() {

    }

    private ClientResponse getClientResponse() {
        return new ClientResponse(UUID.randomUUID().toString(), "");
    }

    private ClientRequest getClientRequest() {
        return new ClientRequest("Mario", "Mario");
    }

    @Test
    public void createTest() {
        Mono<ClientResponse> response = service.create(getClientResponse(), getClientRequest());
        assertEquals("Mario Mario", Objects.requireNonNull(response.block()).getFullName());
    }

}
