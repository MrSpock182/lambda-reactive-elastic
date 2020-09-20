package io.github.mrspock182.lambda.domain

import java.util.*

data class ErrorResponse(@get:JvmName("date") val date: Date,
                         @get:JvmName("path") val path: String,
                         @get:JvmName("status") val status: Int,
                         @get:JvmName("error") val error: String,
                         @get:JvmName("message") val message: String)