package com.example.CountryService;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

public @Data class Country  {

    public String countryName;
    public String countryCode;
    public String countryCapital;
    public String countryPopulation;
    public String countryFlagUrl;

}
