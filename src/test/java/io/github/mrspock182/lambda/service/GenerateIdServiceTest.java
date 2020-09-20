package io.github.mrspock182.lambda.service;

import io.github.mrspock182.lambda.TestSetup;
import io.github.mrspock182.lambda.domain.ClientResponse;
import io.github.mrspock182.lambda.service.implementation.GenerateIdServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Mono;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class GenerateIdServiceTest extends TestSetup {

    @InjectMocks
    private GenerateIdServiceImpl service;

    @Override
    public void init() {

    }

    @Test
    public void generateTest() {
        Mono<ClientResponse> mono = service.generate();
        assertNotNull(mono.block());
    }

}
