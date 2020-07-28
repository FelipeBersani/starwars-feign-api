package br.com.starwarspoc.model.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum Episode {

    ONE(1, 4),
    TWO(2, 5),
    THREE(3, 6),
    FOUR(4, 1),
    FIVE(5, 2),
    SIX(6, 3);

    private Integer film;
    private Integer episodeId;

    public static Integer getEpisodeByMovieOrder(Integer film){
        return Stream.of(values())
          .filter(value -> value.getEpisodeId().equals(film))
          .map(Episode::getFilm)
          .findFirst().orElseThrow(() -> new RuntimeException());
    }

}
