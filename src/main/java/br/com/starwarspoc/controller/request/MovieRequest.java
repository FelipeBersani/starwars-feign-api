package br.com.starwarspoc.controller.request;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class MovieRequest {

    @Min(1)
    @Max(6)
    @NotNull
    private Integer episode;

}
