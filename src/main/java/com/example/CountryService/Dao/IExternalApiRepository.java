package com.example.CountryService.Dao;

import com.example.CountryService.Dto.Country;

import java.util.List;
import java.util.HashMap;

public interface IExternalApiRepository {

    List <Country> fetchCountriesCode();
    //HashMasp<String, String> fetchCountryNameinfo();
    List<String> fetchCountryInfo(String name);


}
