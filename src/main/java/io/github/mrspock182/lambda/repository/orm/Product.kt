package io.github.mrspock182.lambda.repository.orm

class Product(@get:JvmName("getName") val name: String,
              @get:JvmName("getPrice") val price: Double)
