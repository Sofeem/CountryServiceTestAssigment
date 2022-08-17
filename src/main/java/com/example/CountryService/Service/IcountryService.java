package com.example.CountryService.Service;

import com.example.CountryService.Dto.Country;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface IcountryService {

    List<Country> fetchCountries();
}
