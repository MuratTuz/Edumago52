package ch.iw.edumago.service;

import ch.iw.edumago.model.City;

import java.util.List;

public interface ICityService {

    List<City> getAllCities();
    City getCityById(long cityId);
    boolean addCity(City city);
    void updateCity(City city);
    void deleteCity(int cityId);
}