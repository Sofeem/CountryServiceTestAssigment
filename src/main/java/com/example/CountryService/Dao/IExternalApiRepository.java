package com.example.CountryService.Dao;

import com.example.CountryService.Dto.Country;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.HashMap;

@Service
public interface IExternalApiRepository {

    List <Country> fetchCountriesCode();

    List<String> fetchCountryInfo(String name);


}
