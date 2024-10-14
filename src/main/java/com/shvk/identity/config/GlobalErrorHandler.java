package com.shvk.identity.config;

import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler({
        SignatureException.class
    })
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ProblemDetail handleSignatureExceptionException(Exception exception) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.FORBIDDEN);
        problemDetail.setTitle("Forbidden");
        problemDetail.setDetail(exception.getMessage());
        return problemDetail;
    }

    @ExceptionHandler({
        Exception.class
    })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ProblemDetail handleException(Exception exception) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        problemDetail.setTitle("Internal Server Error");
        problemDetail.setDetail(exception.getMessage());
        return problemDetail;
    }

}
