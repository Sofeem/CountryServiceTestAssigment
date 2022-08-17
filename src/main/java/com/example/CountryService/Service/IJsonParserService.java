package com.example.CountryService.Service;

import com.example.CountryService.Model.Country;

import java.util.List;

public interface IJsonParserService {
    String fetchCountriesJson(List<Country> elements);
    String fetchCountriesByNameJsom(List<String> elements);
}
