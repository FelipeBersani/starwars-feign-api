package br.com.starwarspoc.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class MovieDTO {

    private String title;
    private Integer episode_id;
    private String opening_crawl;
    private String director;
    private String producer;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate release_date;
    private List<String> characters;
    private List<String> planets;
    private List<String> starships;
    private List<String> vehicles;
    private List<String> species;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime created;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime edited;
    private String url;

}
