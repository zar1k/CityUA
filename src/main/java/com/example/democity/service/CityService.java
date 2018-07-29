package com.example.democity.service;

import com.example.democity.dto.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CityService {

    City save(City city);

    List<City> saveAll(List<City> cities);

    City findByName(String name);

    List<City> findBetweenPopulation(int begin, int end);

    List<City> findLikeName(String name);

    Page<City> findAllWithPageable(Pageable pageable);

}
