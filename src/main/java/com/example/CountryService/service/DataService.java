package com.example.CountryService.service;


import com.example.CountryService.Repoexternalapi.IExternalApiRepository;
import com.example.CountryService.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    private final IExternalApiRepository iexternalApiRepository;
    //private RestTemplate restTemplate;
    @Autowired
    public DataService(@Qualifier("Api") IExternalApiRepository iexternalApiRepository){

        this.iexternalApiRepository = iexternalApiRepository;
    }

    @Cacheable("fetchCountries")
    public List<Country> fetchCountries() {
        return iexternalApiRepository.fetchCountriesCode();
    }

   // public List<String> fetchCountriesByName(String name){


   // return iexternalApiRepository.fetchCountryInfo(name);
   // }
}
