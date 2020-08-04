package br.com.starwarspoc.service;

import br.com.starwarspoc.controller.response.MovieResponse;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieService {

    public static final String SLASH = "/";
    public static final String ACTOR = "actor";
    public static final String MOVIE = "movie";
    public static final String PLANET = "planet";
    public static final String SPECIE = "specie";
    public static final String STARSHIP = "starship";
    public static final String VEHICLE = "vehicle";

    private final MovieFeignService movieFeignService;
    private final MovieCacheRepository movieCacheRepository;

    public MovieResponse getMovieByEpisodeId(Integer episode) {
        Optional<MovieCache> movieCacheReturned = movieCacheRepository.findById(episode.toString());
        if (movieCacheReturned.isPresent()){
            log.info("Episode "+episode+" found on redis");
            return movieCacheReturned.get().getMovieResponse();
        }

        Map<String, List<String>> mapDtoList = new HashMap<>();
        Optional<MovieDTO> movie = movieFeignService.getMovie(Episode.getEpisodeByMovieOrder(episode));
        log.info(movie.get().getTitle()+" found successfully");

        get(movie.get().getCharacters(), mapDtoList, ACTOR);
        get(movie.get().getPlanets(), mapDtoList, PLANET);
        get(movie.get().getSpecies(), mapDtoList, SPECIE);
        get(movie.get().getStarships(), mapDtoList, STARSHIP);
        get(movie.get().getVehicles(), mapDtoList, VEHICLE);

        MovieResponse movieResponse = MovieMapper.of(movie.get(), mapDtoList);

        log.info("Saving episode "+episode+" in redis");
        MovieCache movieCache = MovieCache.buildMovieCache(movieResponse);
        movieCacheRepository.save(movieCache);
        log.info("Saved on redis successfully");
        return movieResponse;
    }

    private void get(List<String> propertyList, Map<String, List<String>> movieMap, String typeDto){
        List<String> genericList = new ArrayList<>();
        propertyList.forEach(url -> {
            String[] id = getId(url);

            switch (typeDto) {
                case ACTOR:
                    movieFeignService.getActor(Integer.valueOf(id[id.length - 1]))
                      .ifPresent(data -> addToList(genericList, data.getName(), ACTOR));
                    break;
                case MOVIE:
                    movieFeignService.getMovie(Integer.valueOf(id[id.length - 1]))
                      .ifPresent(data -> addToList(genericList, data.getTitle(), MOVIE));
                    break;
                case PLANET:
                    movieFeignService.getPlanet(Integer.valueOf(id[id.length - 1]))
                      .ifPresent(data -> addToList(genericList, data.getName(), PLANET));
                    break;
                case SPECIE:
                    movieFeignService.getSpecie(Integer.valueOf(id[id.length - 1]))
                      .ifPresent(data -> addToList(genericList, data.getName(), SPECIE));
                    break;
                case STARSHIP:
                    movieFeignService.getStarship(Integer.valueOf(id[id.length - 1]))
                      .ifPresent(data -> addToList(genericList, data.getName(), STARSHIP));
                    break;
                case VEHICLE:
                    movieFeignService.getVehicle(Integer.valueOf(id[id.length - 1]))
                      .ifPresent(data -> addToList(genericList, data.getName(), VEHICLE));
                    break;
                default:
                    log.error(typeDto + " type dont exist");
                    break;
            }
        });
        movieMap.put(typeDto, genericList);
    }

    private String[] getId(String url){
        return url.split(SLASH);
    }

    private void addToList(List<String> dataList, String data, String dto){
        dataList.add(data);
        log.info(dto+" "+data+" found");
    }

}
