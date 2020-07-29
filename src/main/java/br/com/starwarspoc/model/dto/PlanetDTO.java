package br.com.starwarspoc.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PlanetDTO {

    @JsonAlias(value = "rotation_period")
    private String rotation_period;
    @JsonAlias(value = "orbital_period")
    private String orbital_period;
    @JsonAlias(value = "surface_water")
    private String surfaceWater;

    private String name;
    private String diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private String population;
    private List<String> residents;
    private List<String> films;
    private LocalDateTime created;
    private LocalDateTime edited;
    private String url;

}
