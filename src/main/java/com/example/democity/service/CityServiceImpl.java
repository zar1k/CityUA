package com.example.democity.service;

import com.example.democity.dto.City;
import com.example.democity.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository repository;

    @Autowired
    public CityServiceImpl(final CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public City save(City city) {
        return this.repository.save(city);
    }

    @Override
    public List<City> saveAll(List<City> cities) {
        return this.repository.saveAll(cities);
    }

    @Override
    public City findByName(String name) {
        return this.repository.findByName(name);
    }

    @Override
    public List<City> findBetweenPopulation(int begin, int end) {
        return this.repository.findAllByPopulationBetween(begin, end);
    }

    @Override
    public List<City> findLikeName(String name) {
        return this.repository.findCityByNameStartingWith(name);
    }

    @Override
    public Page<City> findAllWithPageable(Pageable pageable) {
        return this.repository.findAll(pageable);
    }
}
