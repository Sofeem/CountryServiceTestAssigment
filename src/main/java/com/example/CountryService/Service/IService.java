package com.example.CountryService.Service;

import com.example.CountryService.Model.Country;
import com.example.CountryService.Model.CountryInfo;

import java.util.List;

public interface IService {

     List<Country> fetchCountries();
     CountryInfo fetchCountriesByName(String name);



}
