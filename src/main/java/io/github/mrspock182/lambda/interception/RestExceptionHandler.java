package io.github.mrspock182.lambda.interception;

import io.github.mrspock182.lambda.domain.ErrorResponse;
import io.github.mrspock182.lambda.exception.BadRequest;
import io.github.mrspock182.lambda.exception.InternalServerError;
import io.github.mrspock182.lambda.exception.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFound(final NotFound notFound,
                                        final ServerHttpRequest serverHttpRequest) {
        return new ErrorResponse(new Date(),
                serverHttpRequest.getURI().getPath(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                notFound.getMessage());
    }

    @ExceptionHandler(BadRequest.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBadRequest(final BadRequest badRequest,
                                        final ServerHttpRequest serverHttpRequest) {
        return new ErrorResponse(new Date(),
                serverHttpRequest.getURI().getPath(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                badRequest.getMessage());
    }

    @ExceptionHandler(InternalServerError.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleInternalServerError(final InternalServerError internalServerError,
                                          final ServerHttpRequest serverHttpRequest) {
        return new ErrorResponse(new Date(),
                serverHttpRequest.getURI().getPath(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                internalServerError.getMessage());
    }

}
