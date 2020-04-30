package by.servlets.exceptions;

import javax.servlet.ServletException;

public class InitException extends ServletException {
    public InitException(Exception e) {
        super(e);
    }

    public InitException(String message) {
        super(message);
    }
}
