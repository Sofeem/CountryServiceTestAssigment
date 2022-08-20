package com.example.CountryService.Service;

import com.example.CountryService.Model.Country;
import com.example.CountryService.Model.CountryInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IService {

     List<Country> fetchCountries();
     CountryInfo fetchCountriesByName(String name);



}
