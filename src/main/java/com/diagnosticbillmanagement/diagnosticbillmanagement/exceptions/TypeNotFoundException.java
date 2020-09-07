package com.diagnosticbillmanagement.diagnosticbillmanagement.exceptions;

//@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such Type")
public class TypeNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1348771109171435607L;

    public TypeNotFoundException(String message) {
        super(message);
    }
}
