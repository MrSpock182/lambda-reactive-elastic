package io.github.mrspock182.lambda.domain

import io.github.mrspock182.lambda.repository.orm.Product

data class OrderRequest(@get:JvmName("clientName") val clientName: String,
                   @get:JvmName("products") val products: List<Product>)