package br.com.starwarspoc.service.feign;

import br.com.starwarspoc.model.dto.ActorDTO;
import br.com.starwarspoc.model.dto.MovieDTO;
import br.com.starwarspoc.model.dto.PlanetDTO;
import br.com.starwarspoc.model.dto.SpecieDTO;
import br.com.starwarspoc.model.dto.StarshipDTO;
import br.com.starwarspoc.model.dto.VehicleDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

import static br.com.starwarspoc.utils.PathUtils.BASE_URL;
import static br.com.starwarspoc.utils.PathUtils.GET_ACTORS;
import static br.com.starwarspoc.utils.PathUtils.GET_MOVIE;
import static br.com.starwarspoc.utils.PathUtils.GET_PLANETS;
import static br.com.starwarspoc.utils.PathUtils.GET_SPECIES;
import static br.com.starwarspoc.utils.PathUtils.GET_STARSHIPS;
import static br.com.starwarspoc.utils.PathUtils.GET_VEHICLES;

@Service
@FeignClient(url = BASE_URL, value = "starwarsClient")
public interface MovieFeignService {

    @GetMapping(value = GET_MOVIE)
    Optional<MovieDTO> getMovie(@PathVariable("episodeId") Integer episode);

    @GetMapping(value = GET_ACTORS)
    Optional<ActorDTO> getActor(@PathVariable("peopleId") Integer actorId);

    @GetMapping(value = GET_PLANETS)
    Optional<PlanetDTO> getPlanet(@PathVariable("planetId") Integer planetId);

    @GetMapping(value = GET_STARSHIPS)
    Optional<StarshipDTO> getStarship(@PathVariable("starshipId") Integer starshipId);

    @GetMapping(value = GET_VEHICLES)
    Optional<VehicleDTO> getVehicle(@PathVariable("vehicleId") Integer vehicleId);

    @GetMapping(value = GET_SPECIES)
    Optional<SpecieDTO> getSpecie(@PathVariable("specieId") Integer specieId);

}
