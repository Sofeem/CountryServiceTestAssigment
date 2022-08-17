package com.example.CountryService.Dao;

import com.example.CountryService.Dto.CountryName;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class CountriesNameDao implements ICountriesNameDao {


    @Override
    public List<CountryName> fetchCountries(String name) {
        RestTemplate restTemplate = new RestTemplate();
        //RestTemplate restTemplate;
        ResponseEntity<String> responseEntity =
                restTemplate.getForEntity("https://countriesnow.space/api/v0.1/countries/iso", String.class);
        String rawJson = responseEntity.getBody();
     return null;
    }
}
