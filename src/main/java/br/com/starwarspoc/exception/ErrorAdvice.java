package br.com.starwarspoc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ErrorAdvice {

    public static final String BAD_REQUEST_MESSAGE = "O episódio buscado não existe na api!";

    @ExceptionHandler(Exception.class)
    public ErrorMessage badrequest(Exception ex){
        return ErrorMessage.builder()
          .errorMessage(BAD_REQUEST_MESSAGE)
          .httpError(HttpStatus.BAD_REQUEST.getReasonPhrase())
          .httpStatus(HttpStatus.BAD_REQUEST.value())
          .timestamp(LocalDateTime.now())
          .build();
    }


}
