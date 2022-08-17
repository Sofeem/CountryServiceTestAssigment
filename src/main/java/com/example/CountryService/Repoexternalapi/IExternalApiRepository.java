package com.example.CountryService.Repoexternalapi;

import com.example.CountryService.model.Country;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IExternalApiRepository {

    List <Country> fetchCountriesCode();

    //List<Country> fetchCountryInfo(String name);


}
