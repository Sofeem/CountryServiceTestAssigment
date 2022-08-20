package com.example.CountryService.ExternalAPIRepo;

import com.example.CountryService.Model.Country;
import com.example.CountryService.Model.CountryInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IExternalApiRepository {

    List <Country> fetchCountriesCode();

   CountryInfo fetchCountryInfo(String name);


}
