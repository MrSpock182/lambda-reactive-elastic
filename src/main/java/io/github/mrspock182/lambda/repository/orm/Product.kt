package io.github.mrspock182.lambda.repository.orm

class Product(@get:JvmName("name") val name: String,
              @get:JvmName("price") val price: Double)
