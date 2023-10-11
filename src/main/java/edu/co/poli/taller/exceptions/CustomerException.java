package edu.co.poli.taller.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class CustomerException extends RuntimeException {
    private String message;
    private HttpStatus httpStatus;

    public CustomerException(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
