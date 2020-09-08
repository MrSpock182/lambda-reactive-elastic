package io.github.mrspock182.lambda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFound extends RuntimeException {
    public NotFound() {
        super();
    }

    public NotFound(final String message) {
        super(message);
    }

    public NotFound(final String message, final Throwable cause) {
        super(message, cause);
    }

    public NotFound(final Throwable cause) {
        super(cause);
    }
}
