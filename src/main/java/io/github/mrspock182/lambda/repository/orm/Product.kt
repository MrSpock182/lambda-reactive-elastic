package io.github.mrspock182.lambda.repository.orm

class Product(name: String, price: Double) {
    @JvmField val name = name
    @JvmField val price = price
}
