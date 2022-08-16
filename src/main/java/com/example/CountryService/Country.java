package com.example.CountryService;

import java.io.Serializable;


public class Country implements Serializable {

    public String countryName;
    public String countryCode;
    public String countryCapital;

    public Country(String countryName, String countryCode, String countryCapital, String countryPopulation, String countryFlagUrl) {
        this.countryName = countryName;
        this.countryCode = countryCode;
        this.countryCapital = countryCapital;
        this.countryPopulation = countryPopulation;
        this.countryFlagUrl = countryFlagUrl;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCapital() {
        return countryCapital;
    }

    public void setCountryCapital(String countryCapital) {
        this.countryCapital = countryCapital;
    }

    public String getCountryPopulation() {
        return countryPopulation;
    }

    public void setCountryPopulation(String countryPopulation) {
        this.countryPopulation = countryPopulation;
    }

    public String getCountryFlagUrl() {
        return countryFlagUrl;
    }

    public void setCountryFlagUrl(String countryFlagUrl) {
        this.countryFlagUrl = countryFlagUrl;
    }

    public String countryPopulation;
    public String countryFlagUrl;


}
