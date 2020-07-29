package br.com.starwarspoc.controller;

import br.com.starwarspoc.controller.request.MovieRequest;
import br.com.starwarspoc.controller.response.MovieResponse;
import br.com.starwarspoc.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/starwars")
public class MovieController {

    private final MovieService movieService;

    @GetMapping(value = "/{episode}/episode")
    public ResponseEntity<MovieResponse> getMovie(@Valid MovieRequest episode) {
        return ResponseEntity.ok(movieService.getMovieByEpisodeId(episode.getEpisode()));
    }

}
