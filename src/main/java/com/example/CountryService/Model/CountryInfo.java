package com.example.CountryService.Model;

import lombok.Data;

public @Data class CountryInfo {


    public String name;
    public String country_code;
    public String capital;
    public String population;
    public String flag_img_uri;


    public CountryInfo(String name, String cCode, String cCapital, String cPopulation, String cFlagFileUrl) {
        this.name = name;
        this.country_code = cCode;
        this.capital = cCapital;
        this.population = cPopulation;
        this.flag_img_uri = cFlagFileUrl;
    }
}
