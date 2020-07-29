package br.com.starwarspoc.repository.cache;

import br.com.starwarspoc.controller.response.MovieResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@RedisHash("myMovie")
public class MovieCache extends AbstractCache{

    private MovieResponse movieResponse;

    public MovieCache(String episode, MovieResponse movieResponse) {
        setKey(episode);
        this.movieResponse = movieResponse;
    }

    public static MovieCache buildMovieCache(MovieResponse movieResponse){
        MovieCache movieCache = new MovieCache();
        movieCache.setKey(movieResponse.getEpisodeId().toString());
        movieCache.setMovieResponse(movieResponse);
        return movieCache;
    }
}
