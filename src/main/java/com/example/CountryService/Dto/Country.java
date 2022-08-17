package com.example.CountryService.Dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public @Data class Country  {

    public String countryName;
    public String countryCode;



}
