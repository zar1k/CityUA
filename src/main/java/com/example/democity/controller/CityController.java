package com.example.democity.controller;

import com.example.democity.dto.City;
import com.example.democity.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class CityController {
    private final CityService service;

    @Autowired
    public CityController(final CityService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public City create(@RequestBody City city) {
        return this.service.save(city);
    }

    @GetMapping("/city/{name}")
    public City findByName(@PathVariable String name) {
        return this.service.findByName(name);
    }

    @GetMapping(value = "/city/population", params = {"begin", "end"})
    public List<City> findBetweenPopulation(@RequestParam("begin") int begin, @RequestParam("end") int end) {
        return this.service.findBetweenPopulation(begin, end);
    }

    @GetMapping(value = "/cities")
    public Page<City> findWithPageable(@PageableDefault(size = 10, sort = "name", direction = Sort.Direction.DESC) Pageable pageable) {
        return this.service.findAllWithPageable(pageable);
    }

    @GetMapping("city/find/{name}")
    public List<City> findLikeName(@PathVariable String name) {
        return this.service.findLikeName(name);
    }
}
