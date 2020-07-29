package br.com.starwarspoc.repository;

import br.com.starwarspoc.repository.cache.MovieCache;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieCacheRepository extends CrudRepository<MovieCache, String> {
}
