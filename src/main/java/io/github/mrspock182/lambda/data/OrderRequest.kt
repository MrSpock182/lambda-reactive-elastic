package io.github.mrspock182.lambda.data

import io.github.mrspock182.lambda.repository.orm.Product

class OrderRequest(clientName: String, products: List<Product>) {
    @JvmField val clientName = clientName
    @JvmField val products = products
}