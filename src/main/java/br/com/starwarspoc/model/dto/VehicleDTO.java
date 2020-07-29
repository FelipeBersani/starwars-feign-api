package br.com.starwarspoc.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class VehicleDTO {

    @JsonAlias(value = "cost_in_credits")
    private String costInCredits;
    @JsonAlias(value = "max_atmosphering_speed")
    private String maxAtmospheringSpeed;
    @JsonAlias(value = "cargo_capacity")
    private String cargoCapacity;
    @JsonAlias(value = "vehicle_class")
    private String vehicleClass;

    private String name;
    private String model;
    private String manufacturer;
    private String length;
    private String crew;
    private String passengers;
    private String consumables;
    private List<String> pilots;
    private List<String> films;
    private LocalDateTime created;
    private LocalDateTime edited;
    private String url;

}
