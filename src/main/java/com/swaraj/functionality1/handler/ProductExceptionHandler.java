package com.swaraj.functionality1.handler;

import com.swaraj.functionality1.dto.ErrorDto;
import com.swaraj.functionality1.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorDto handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
        return ErrorDto.builder()
                .status("FAIL")
                .message(productNotFoundException.getMessage())
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
    }//

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleProductValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
        Map<String, String> errorMap = new HashMap<>();
        methodArgumentNotValidException
                .getBindingResult()
                .getFieldErrors()
                .forEach(fieldError -> {
                    errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
                });
        return errorMap;
    }
}
