package io.github.mrspock182.lambda.domain.response

data class ClientResponse(@get:JvmName("getId") val id: String,
                     @get:JvmName("getFullName") val fullName: String)