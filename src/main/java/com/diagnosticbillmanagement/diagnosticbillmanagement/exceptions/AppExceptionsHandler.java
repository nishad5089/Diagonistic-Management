package com.diagnosticbillmanagement.diagnosticbillmanagement.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class AppExceptionsHandler {
    public static final String DEFAULT_ERROR_VIEW = "error/error";

    @ExceptionHandler(value = {Exception.class})
    public String handleOtherExceptions(Exception ex, HttpServletRequest req, Model model) {
        model.addAttribute("exception", ex);
        model.addAttribute("url", req.getRequestURL());
        return DEFAULT_ERROR_VIEW;
    }

    @ExceptionHandler(value = {NoHandlerFoundException.class,TypeNotFoundException.class})
    public String handlerException(Model model) {
        return "error/404";
    }
}
