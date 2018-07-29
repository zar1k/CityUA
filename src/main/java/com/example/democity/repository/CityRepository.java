package com.example.democity.repository;

import com.example.democity.dto.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    City findByName(String name);

    List<City> findAllByPopulationBetween(int begin, int end);

    List<City> findCityByNameStartingWith(String name);
}