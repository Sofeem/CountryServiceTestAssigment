package com.example.CountryService.Service;

import com.example.CountryService.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class countryService {

    @Autowired
    public countryService(IcountryService icountryService) {
    }



}
