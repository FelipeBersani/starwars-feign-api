package br.com.starwarspoc.repository;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "PATH", name = "movieFeignClient")
public interface MovieRepository {
}
