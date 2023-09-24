package com.postcardable.postcardable.exceptions;

import com.postcardable.postcardable.web.dto.response.ErrorResponseDTO;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.xml.bind.ValidationException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);
    @ExceptionHandler(value = {ConstraintViolationException.class , ValidationException.class})
    protected ResponseEntity<ErrorResponseDTO> handleConflict(ValidationException exception, WebRequest webRequest) {
        LOGGER.error(exception.getMessage());
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(String.valueOf(HttpStatus.BAD_REQUEST.value()), exception.getMessage());

        return new ResponseEntity<>(errorResponseDTO,  HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String message = ex.getAllErrors().get(0).getDefaultMessage();
        LOGGER.error(message);

        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(message, String.valueOf(HttpStatus.BAD_REQUEST.value()));
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_REQUEST);
    }
}
