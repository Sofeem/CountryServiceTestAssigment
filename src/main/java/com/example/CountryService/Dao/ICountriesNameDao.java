package com.example.CountryService.Dao;

import com.example.CountryService.Dto.CountryName;

import java.util.List;

public interface ICountriesNameDao {

    List<CountryName> fetchCountries(String name);

}
