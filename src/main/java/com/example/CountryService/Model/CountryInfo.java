package com.example.CountryService.Model;

import lombok.Data;

public @Data class CountryInfo {


    public String name;
    public String country_code;
    public String capital;
    public String population;
    public String flag_img_uri;


    public CountryInfo(String name, String cCode, String cCapital, String cPopulation, String cFlagFileUrl) {
    }
}
