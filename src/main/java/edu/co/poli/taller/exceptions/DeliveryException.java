package edu.co.poli.taller.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class DeliveryException extends RuntimeException {
    private String message;
    private HttpStatus httpStatus;

    public DeliveryException(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
