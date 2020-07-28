package br.com.starwarspoc.model.dto;

import br.com.starwarspoc.model.converter.GenderDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ActorDTO {

    private String name;
    private String height;
    private String mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    @JsonDeserialize(using = GenderDeserializer.class)
    private String gender;
    private String homeworld;
    private List<String> films;
    private List<String> species;
    private List<String> vehicles;
    private List<String> starships;
    private LocalDateTime created;
    private LocalDateTime edited;
    private String url;

}
