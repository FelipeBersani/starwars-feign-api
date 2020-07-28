package br.com.starwarspoc.controller.response;

import lombok.Data;

import java.util.List;

@Data
public class MovieResponse {

    private String movieName;
    private List<String> actorName;

}
