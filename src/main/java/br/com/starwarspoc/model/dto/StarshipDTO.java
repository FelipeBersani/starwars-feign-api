package br.com.starwarspoc.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class StarshipDTO {

    @JsonAlias(value = "cost_in_credits")
    private String costInCredits;
    @JsonAlias(value = "max_atmosphering_speed")
    private String maxAtmospheringSpeed;
    @JsonAlias(value = "cargo_capacity")
    private String cargoCapacity;
    @JsonAlias(value = "hyperdrive_rating")
    private String hyperdriveRating;
    @JsonAlias(value = "starship_class")
    private String starshipClass;

    private String name;
    private String model;
    private String manufacturer;
    private String length;
    private String crew;
    private String passengers;
    private String consumables;
    private String MGLT;
    private List<String> pilots;
    private List<String> films;
    private LocalDateTime created;
    private LocalDateTime edited;
    private String url;

}
