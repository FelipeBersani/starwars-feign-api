package br.com.starwarspoc.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class MovieDTO {

    @JsonAlias("episode_id")
    private Integer episodeId;
    @JsonAlias("opening_crawl")
    private String openingCrawl;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonAlias("release_date")
    private LocalDate releaseDate;

    private String director;
    private String title;
    private String producer;
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
