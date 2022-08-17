package com.example.CountryService.ExternalAPIRepo;

import com.example.CountryService.Model.Country;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IExternalApiRepository {

    List <Country> fetchCountriesCode();

    List<String> fetchCountryInfo(String name);


}
