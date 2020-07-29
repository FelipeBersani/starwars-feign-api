package br.com.starwarspoc.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class SpecieDTO {

    @JsonAlias(value = "averageHeight")
    private String average_height;
    @JsonAlias(value = "skinColors")
    private String skin_colors;
    @JsonAlias(value = "hairColors")
    private String hair_colors;
    @JsonAlias(value = "eyeColors")
    private String eye_colors;
    @JsonAlias(value = "averageLifespan")
    private String average_lifespan;

    private String name;
    private String classification;
    private String designation;
    private String homeworld;
    private String language;
    private List<String> people;
    private List<String> films;
    private LocalDateTime created;
    private LocalDateTime edited;
    private String url;

}
