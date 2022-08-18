package com.example.CountryService.Service;

import com.example.CountryService.Model.Country;

import java.util.List;

public interface IService {

     List<Country> fetchCountries();
     List<String> fetchCountriesByName(String name);



}
