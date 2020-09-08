package io.github.mrspock182.lambda.api

import io.github.mrspock182.lambda.data.OrderRequest
import io.github.mrspock182.lambda.repository.orm.Order
import io.github.mrspock182.lambda.service.OrderFindAllService
import io.github.mrspock182.lambda.service.OrderFindIdService
import io.github.mrspock182.lambda.service.OrderSaveService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping(value = ["/mrspock182/order"])
class OrderApi(findIdService: OrderFindIdService, saveService: OrderSaveService, findAllService: OrderFindAllService) {
    private val findById: OrderFindIdService = findIdService
    private val save: OrderSaveService = saveService
    private val findAll: OrderFindAllService = findAllService

    @PostMapping(value = ["/save"])
    fun save(@RequestBody request: OrderRequest): Mono<Order> {
        return save.save(request)
    }

    @GetMapping(value = ["/find/{id}"])
    fun findById(@PathVariable id: String): Mono<Order> {
        return findById.findId(id)
    }

    @GetMapping(value = ["/find-all"])
    fun findAll(): Flux<Order> {
        return findAll.findAll()
    }

}