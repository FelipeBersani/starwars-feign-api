package br.com.starwarspoc.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorMessage{

    private Integer httpStatus;
    private String httpError;
    private String errorMessage;
    private LocalDateTime timestamp;

}
