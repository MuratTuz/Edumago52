package ch.iw.edumago.service;

import java.util.ArrayList;
import java.util.List;

import ch.iw.edumago.model.City;
import ch.iw.edumago.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService implements ICityService {

    @Autowired
    private CityRepository repository;

    @Override
    public City getCityById(long cityId) {
        City obj = repository.findById(cityId).get();
        return obj;
    }
    @Override
    public List<City> getAllCities(){
        List<City> list = new ArrayList<>();
        repository.findAll().forEach(e -> list.add(e));
        return list;
    }
    @Override
    public synchronized boolean addCity(City city){
        repository.save(city);
        return true;
    }

    @Override
    public void updateCity(City city) {
        repository.save(city);
    }
    @Override
    public void deleteCity(int cityId) {
        repository.delete(getCityById(cityId));
    }
}
