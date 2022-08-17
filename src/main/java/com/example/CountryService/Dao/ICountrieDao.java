package com.example.CountryService.Dao;

import com.example.CountryService.Dto.Country;

import java.util.List;

public interface ICountrieDao {
    List<Country> fetchCountries();
}
