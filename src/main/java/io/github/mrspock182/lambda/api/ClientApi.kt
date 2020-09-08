package io.github.mrspock182.lambda.api

import io.github.mrspock182.lambda.data.ClientRequest
import io.github.mrspock182.lambda.data.ClientResponse
import io.github.mrspock182.lambda.service.ClientSaveService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping(value = ["/mrspock182/client"])
class ClientApi(service: ClientSaveService) {
    val s: ClientSaveService = service

    @PostMapping(value = ["/save"])
    fun requestStatusFile(@RequestBody request: ClientRequest): Mono<ClientResponse> {
        return s.save(request)
    }
}