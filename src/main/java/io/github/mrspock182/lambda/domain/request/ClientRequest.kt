package io.github.mrspock182.lambda.domain.request

data class ClientRequest(@get:JvmName("getFirstName") val firstName: String,
                         @get:JvmName("getLastName") val lastName: String)