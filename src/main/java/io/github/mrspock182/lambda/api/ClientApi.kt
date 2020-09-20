package io.github.mrspock182.lambda.api

import io.github.mrspock182.lambda.domain.ClientRequest
import io.github.mrspock182.lambda.domain.ClientResponse
import io.github.mrspock182.lambda.service.ClientSaveService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping(value = ["/mrspock182/client"])
class ClientApi(val service: ClientSaveService) {

    @PostMapping(value = ["/save"])
    fun requestStatusFile(@RequestBody request: ClientRequest): Mono<ClientResponse> {
        return service.save(request)
    }
}