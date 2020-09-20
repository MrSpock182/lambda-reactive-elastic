package io.github.mrspock182.lambda.repository.orm

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document

@Document(indexName = "lambda", type = "order")
class Order(@Id @get:JvmName("id") val id: String,
            @get:JvmName("clientName") val clientName: String,
            @get:JvmName("products") val products: List<Product>,
            @get:JvmName("totalPrice") val totalPrice: Double)