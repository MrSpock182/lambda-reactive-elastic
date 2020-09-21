package io.github.mrspock182.lambda.domain

data class ClientRequest(@get:JvmName("getFirstName") val firstName: String,
                         @get:JvmName("getLastName") val lastName: String)