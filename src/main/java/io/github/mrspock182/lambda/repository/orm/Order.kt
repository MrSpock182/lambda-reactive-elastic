package io.github.mrspock182.lambda.repository.orm

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType

@Document(indexName = "lambda", type = "order")
class Order(id: String, clientName: String, products: List<Product>, totalPrice: Double) {
    @Id
    @JvmField val id = id
    @JvmField val clientName = clientName
    @Field(type = FieldType.Object)
    @JvmField val products = products
    @JvmField val totalPrice = totalPrice
}