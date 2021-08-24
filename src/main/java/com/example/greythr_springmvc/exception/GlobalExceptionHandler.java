package com.example.greythr_springmvc.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    String t = "timestamp";
    String m = "message";
    @ExceptionHandler(value = DataManipulationFailedException.class)
    public ResponseEntity<Object> handleDetailsNotFoundException(
            DataManipulationFailedException ex,WebRequest request
    ){
        log.error(ex.getMessage());
        Map<String,Object> body = new LinkedHashMap<>();
        body.put(t,LocalDateTime.now());
        body.put(m,ex.getMessage());
        return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error(ex.getMessage());
        Map<String,Object> body = new LinkedHashMap<>();
        body.put(t, LocalDateTime.now());
        body.put("status",status.value());
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        body.put("errors",errors);
        log.error("error found"+body);
        return new ResponseEntity<>(body,HttpStatus.BAD_REQUEST);
    }
}
