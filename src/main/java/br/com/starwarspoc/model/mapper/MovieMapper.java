package br.com.starwarspoc.model.mapper;

import br.com.starwarspoc.controller.response.MovieResponse;
import br.com.starwarspoc.model.dto.MovieDTO;
import br.com.starwarspoc.service.MovieService;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class MovieMapper {

    public static MovieResponse of(MovieDTO movieDTO, Map<String, List<String>> mapDtoList){// List<String> actorList, List<String> planetList, List<String> specieList, List<String> starshipList, List<String> vehicleList){
        MovieResponse movieResponse = new MovieResponse();

        movieResponse.setEpisodeId(movieDTO.getEpisodeId());
        movieResponse.setMovieName(movieDTO.getTitle());
        movieResponse.setActorList(mapDtoList.entrySet().stream().filter(x -> x.getKey().equalsIgnoreCase(MovieService.ACTOR)).map(Map.Entry::getValue).flatMap(List::stream).collect(Collectors.toList()));
        movieResponse.setPlanetList(mapDtoList.entrySet().stream().filter(x -> x.getKey().equalsIgnoreCase(MovieService.PLANET)).map(Map.Entry::getValue).flatMap(List::stream).collect(Collectors.toList()));
        movieResponse.setSpecieList(mapDtoList.entrySet().stream().filter(x -> x.getKey().equalsIgnoreCase(MovieService.SPECIE)).map(Map.Entry::getValue).flatMap(List::stream).collect(Collectors.toList()));
        movieResponse.setStarshipList(mapDtoList.entrySet().stream().filter(x -> x.getKey().equalsIgnoreCase(MovieService.STARSHIP)).map(Map.Entry::getValue).flatMap(List::stream).collect(Collectors.toList()));
        movieResponse.setVehicleList(mapDtoList.entrySet().stream().filter(x -> x.getKey().equalsIgnoreCase(MovieService.VEHICLE)).map(Map.Entry::getValue).flatMap(List::stream).collect(Collectors.toList()));

        return movieResponse;
    }

}
