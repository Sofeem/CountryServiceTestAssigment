package com.example.CountryService.Service;


import com.example.CountryService.Country;
import com.example.CountryService.Dao.ICountrieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataService implements IcountryService{
    @Autowired
    ICountrieDao countriesdao;
    //private RestTemplate restTemplate;


    public DataService(){

    }

    @Override
    @Cacheable("fetchCountries")
    public List<Country> fetchCountries() {
        return countriesdao.fetchCountries();
    }
}
