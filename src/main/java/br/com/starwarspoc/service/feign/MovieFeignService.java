package br.com.starwarspoc.service.feign;

import br.com.starwarspoc.model.dto.ActorDTO;
import br.com.starwarspoc.model.dto.MovieDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

import static br.com.starwarspoc.utils.PathUtils.BASE_URL;
import static br.com.starwarspoc.utils.PathUtils.GET_ACTORS;
import static br.com.starwarspoc.utils.PathUtils.GET_MOVIE;

@Service
@FeignClient(url = BASE_URL, value = "starwarsClient")
public interface MovieFeignService {

    @GetMapping(value = GET_MOVIE)
    Optional<MovieDTO> getMovie(@PathVariable("episodeId") Integer episode);

    @GetMapping(value = GET_ACTORS)
    Optional<ActorDTO> getActor(@PathVariable("peopleId") Integer actorId);

}
