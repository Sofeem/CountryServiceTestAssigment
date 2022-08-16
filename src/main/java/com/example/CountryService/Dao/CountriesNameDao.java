package com.example.CountryService.Dao;

import com.example.CountryService.CountryName;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class CountriesNameDao implements ICountriesNameDao {


    @Override
    public List<CountryName> fetchCountries(String name) {
     return null;
    }
}
