package io.github.mrspock182.lambda.repository.orm

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document

@Document(indexName = "lambda", type = "order")
class Order(@Id @get:JvmName("getId") val id: String,
            @get:JvmName("getClientName") val clientName: String,
            @get:JvmName("getProducts") val products: List<Product>,
            @get:JvmName("getTotalPrice") val totalPrice: Double)