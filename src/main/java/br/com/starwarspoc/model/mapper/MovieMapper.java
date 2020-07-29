package br.com.starwarspoc.model.mapper;

import br.com.starwarspoc.controller.response.MovieResponse;
import br.com.starwarspoc.model.dto.MovieDTO;
import lombok.Data;

import java.util.List;

@Data
public class MovieMapper {

    public static MovieResponse of(MovieDTO movieDTO, List<String> actorsList){
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setEpisodeId(movieDTO.getEpisodeId());
        movieResponse.setMovieName(movieDTO.getTitle());
        movieResponse.setActorName(actorsList);
        return movieResponse;
    }

}
