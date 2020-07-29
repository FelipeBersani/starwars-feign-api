package br.com.starwarspoc.controller.response;

import lombok.Data;

import java.util.List;

@Data
public class MovieResponse {

    private Integer episodeId;
    private String movieName;
    private List<String> actorName;

}
