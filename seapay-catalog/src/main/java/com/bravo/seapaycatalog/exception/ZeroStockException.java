package com.bravo.seapaycatalog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ZeroStockException extends RuntimeException {
    private static final long serialVersionUID = -3916525550413865316L;

    public ZeroStockException() {
        super();
    }

    public ZeroStockException(String message) {
        super(message);
    }

    public ZeroStockException(String message, Throwable cause) {
        super(message, cause);
    }
}
