package com.example.CountryService.Dao;

import com.example.CountryService.Country;
import com.example.CountryService.CountryName;

import java.util.List;

public interface ICountriesNameDao {

    List<CountryName> fetchCountries(String name);

}
