package com.example.CountryService.Service;

import com.example.CountryService.Country;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface IcountryService {


    List<Country> getCountries();

    //ListfindCountriesbyname


}
