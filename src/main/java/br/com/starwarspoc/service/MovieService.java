package br.com.starwarspoc.service;

import br.com.starwarspoc.controller.response.MovieResponse;
import br.com.starwarspoc.model.dto.ActorDTO;
import br.com.starwarspoc.model.dto.MovieDTO;
import br.com.starwarspoc.service.feign.MovieFeignService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieService {

    public static final String SLASH = "/";
    private final MovieFeignService movieFeignService;

    public MovieResponse test(Integer episode) {
        MovieResponse movieResponse = new MovieResponse();
        List<String> stringList = new ArrayList<>();
        Optional<MovieDTO> movie = movieFeignService.getMovie(episode);
        movieResponse.setMovieName(movie.get().getTitle());
        for (String actor : movie.get().getCharacters()) {
            String[] stringSplit = actor.split(SLASH);
            Optional<ActorDTO> actorOpt = movieFeignService.getActor(Integer.valueOf(stringSplit[stringSplit.length-1]));
            stringList.add(actorOpt.get().getName());
        }
        movieResponse.setActorName(stringList);
        return movieResponse;
    }

}
