package io.github.mrspock182.lambda.domain

data class ClientResponse(@get:JvmName("id") val id: String,
                     @get:JvmName("fullName") val fullName: String)