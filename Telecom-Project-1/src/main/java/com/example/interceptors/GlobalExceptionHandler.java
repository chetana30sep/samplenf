package com.example.interceptors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<?> constraintViolationException(ConstraintViolationException ex, WebRequest request) {
    List<String> errors = new ArrayList<>();

    ex.getConstraintViolations().forEach(cv -> errors.add(cv.getMessage()));

    Map<String, List<String>> result = new HashMap<>();
    result.put("errors", errors);

    return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
  }
}
