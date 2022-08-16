package com.example.CountryService.Service;

import com.example.CountryService.Country;
import com.example.CountryService.CountryName;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface IcountryService {

    List<Country> fetchCountries();
}
