package com.example.ulabsrg.prototype.domain.exception;

/**
 * Created by ulabsrg on 08/07/2015.
 */
public class TemplateNotFoundException extends Exception {

    public TemplateNotFoundException() {
        super();
    }

    public TemplateNotFoundException(final String message) {
        super(message);
    }

    public TemplateNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public TemplateNotFoundException(final Throwable cause) {
        super(cause);
    }
}
