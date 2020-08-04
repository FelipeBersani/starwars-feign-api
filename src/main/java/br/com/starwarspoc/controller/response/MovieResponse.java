package br.com.starwarspoc.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class MovieResponse {

    @JsonProperty("Episódio")
    private Integer episodeId;
    @JsonProperty("Filme")
    private String movieName;
    @JsonProperty("Personagens")
    private List<String> actorList;
    @JsonProperty("Planetas")
    private List<String> planetList;
    @JsonProperty("Espécies")
    private List<String> specieList;
    @JsonProperty("Naves")
    private List<String> starshipList;
    @JsonProperty("Veículos")
    private List<String> vehicleList;

}
