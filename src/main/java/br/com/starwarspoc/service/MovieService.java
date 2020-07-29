package br.com.starwarspoc.service;

import br.com.starwarspoc.controller.response.MovieResponse;
import br.com.starwarspoc.model.dto.ActorDTO;
import br.com.starwarspoc.model.dto.MovieDTO;
import br.com.starwarspoc.model.enumeration.Episode;
import br.com.starwarspoc.model.mapper.MovieMapper;
import br.com.starwarspoc.repository.MovieCacheRepository;
import br.com.starwarspoc.repository.cache.MovieCache;
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
    private final MovieCacheRepository movieCacheRepository;

    public MovieResponse getMovieByEpisodeId(Integer episode) {
        Optional<MovieCache> movieCacheReturned = movieCacheRepository.findById(episode.toString());
        if (movieCacheReturned.isPresent()){
            log.info("Episode "+episode+" found on redis");
            return movieCacheReturned.get().getMovieResponse();
        }

        List<String> actorsList = new ArrayList<>();
        Optional<MovieDTO> movie = movieFeignService.getMovie(Episode.getEpisodeByMovieOrder(episode));
        log.info(movie.get().getTitle()+" found successfully");

        for (String actor : movie.get().getCharacters()) {
            String[] stringSplit = actor.split(SLASH);
            Optional<ActorDTO> actorOpt = movieFeignService.getActor(Integer.valueOf(stringSplit[stringSplit.length-1]));
            log.info("Actor "+actorOpt.get().getName()+" found");
            actorsList.add(actorOpt.get().getName());
        }
        MovieResponse movieResponse = MovieMapper.of(movie.get(), actorsList);

        log.info("Saving episode "+episode+" in redis");
        MovieCache movieCache = MovieCache.buildMovieCache(movieResponse);
        movieCacheRepository.save(movieCache);

        return movieResponse;
    }

}
