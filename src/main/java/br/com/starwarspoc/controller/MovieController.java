package br.com.starwarspoc.controller;

import br.com.starwarspoc.controller.response.MovieResponse;
import br.com.starwarspoc.model.enumeration.Episode;
import br.com.starwarspoc.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/starwars")
public class MovieController {

    private final MovieService movieService;

    @GetMapping(value = "/{episodeId}/episode")
    public ResponseEntity<MovieResponse> getMovie(@PathVariable ("episodeId")Integer episode) {
        return ResponseEntity.ok(movieService.test(Episode.getEpisodeByMovieOrder(episode)));
    }

}
