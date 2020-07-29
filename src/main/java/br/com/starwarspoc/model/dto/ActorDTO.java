package br.com.starwarspoc.model.dto;

import br.com.starwarspoc.model.converter.GenderDeserializer;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ActorDTO {

    @JsonAlias(value = "hair_color")
    private String hairColor;
    @JsonAlias(value = "skin_color")
    private String skinColor;
    @JsonAlias(value = "eye_color")
    private String eyeColor;
    @JsonAlias(value = "birth_year")
    private String birthYear;

    private String name;
    private String height;
    private String mass;
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
