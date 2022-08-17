package com.example.CountryService.Dao;

import com.example.CountryService.Dto.Country;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class CountriesCodeDAO implements IExternalApiRepository{


    Country country;


    @Override
    public List<Country> fetchCountriesCode() {



        return null;
    }

    @Override
    public List<String> fetchCountryInfo(String name) {
        return null;
    }
}
