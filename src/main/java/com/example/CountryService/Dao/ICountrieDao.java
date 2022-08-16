package com.example.CountryService.Dao;

import com.example.CountryService.Country;
import com.example.CountryService.CountryName;

import java.util.List;

public interface ICountrieDao {
    List<Country> fetchCountries();
}
