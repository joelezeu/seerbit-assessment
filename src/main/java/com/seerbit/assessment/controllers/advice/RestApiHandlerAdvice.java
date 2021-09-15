package com.seerbit.assessment.controllers.advice;

import com.seerbit.assessment.exception.TransactionTimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
public class RestApiHandlerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler({
            TransactionTimeException.class,
    })
    public ResponseEntity<?> restApiHandler(final TransactionTimeException ex) {
        log.error("API Exception handled {}", ex);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
