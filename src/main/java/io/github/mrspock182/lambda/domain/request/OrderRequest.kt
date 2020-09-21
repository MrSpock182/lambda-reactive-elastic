package io.github.mrspock182.lambda.domain.request

import io.github.mrspock182.lambda.repository.orm.Product

data class OrderRequest(@get:JvmName("getClientName") val clientName: String,
                   @get:JvmName("getProducts") val products: List<Product>)