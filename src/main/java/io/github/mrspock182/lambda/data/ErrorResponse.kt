package io.github.mrspock182.lambda.data

import java.util.*

class ErrorResponse(date: Date,
                    path: String,
                    status: Int,
                    error: String,
                    message: String) {
    @JvmField val date = date
    @JvmField val path = path
    @JvmField val status = status
    @JvmField val error = error
    @JvmField val message = message
}