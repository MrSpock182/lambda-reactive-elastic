package io.github.mrspock182.lambda.service;

import io.github.mrspock182.lambda.TestSetup;
import io.github.mrspock182.lambda.domain.ClientRequest;
import io.github.mrspock182.lambda.domain.ClientResponse;
import io.github.mrspock182.lambda.exception.BadRequest;
import io.github.mrspock182.lambda.service.implementation.ClientSaveServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClientSaveServiceTest extends TestSetup {

    @InjectMocks
    private ClientSaveServiceImpl service;

    @Mock
    private GenerateIdService generateIdService;

    @Mock
    private ClientResponseService clientResponseService;

    @Override
    public void init() {

    }

    private ClientResponse getClientResponse() {
        return new ClientResponse(UUID.randomUUID().toString(), "Mario Mario");
    }

    private ClientRequest getClientRequest() {
        return new ClientRequest("Mario", "Mario");
    }

    @Test
    public void saveTest() {
        when(generateIdService.generate()).thenReturn(Mono.just(getClientResponse()));
        when(clientResponseService.create(any(ClientResponse.class), any(ClientRequest.class)))
                .thenReturn(Mono.just(getClientResponse()));

        Mono<ClientResponse> response = service.save(getClientRequest());
        assertEquals(getClientResponse().getFullName(), Objects.requireNonNull(response.block()).getFullName());

        verify(generateIdService).generate();
        verify(clientResponseService).create(any(ClientResponse.class), any(ClientRequest.class));
    }

    @Test(expected = BadRequest.class)
    public void saveTestValidationName() {
        service.save(new ClientRequest("Kleber", "Nunes"));
    }

}
