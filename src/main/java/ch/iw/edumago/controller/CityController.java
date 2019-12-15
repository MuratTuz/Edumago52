package ch.iw.edumago.controller;


import ch.iw.edumago.model.City;
import ch.iw.edumago.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    private ICityService cityService;

    @GetMapping("city/{id}")
    public ResponseEntity<City> getCityById(@PathVariable("id") Integer id) {
        City article = cityService.getCityById(id);
        return new ResponseEntity<City>(article, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<City>> getAllCity() {
        List<City> list = cityService.getAllCities();
        return new ResponseEntity<List<City>>(list, HttpStatus.OK);
    }

    @PostMapping("city")
    public ResponseEntity<Void> addCity(@RequestBody City city, UriComponentsBuilder builder) {
        try{
            boolean flag = cityService.addCity(city);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }catch (Exception ex)
        {
            String a = ex.getMessage();
            return new ResponseEntity<Void>( HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("city")
    public ResponseEntity<City> updateCity(@RequestBody City city) {
        cityService.updateCity(city);
        return new ResponseEntity<City>(city, HttpStatus.OK);
    }

    @DeleteMapping("city/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable("id") Integer id) {
        cityService.deleteCity(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}