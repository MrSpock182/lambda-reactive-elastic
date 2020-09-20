package io.github.mrspock182.lambda.domain

data class ClientRequest(@get:JvmName("firstName") val firstName: String,
                         @get:JvmName("lastName") val lastName: String)