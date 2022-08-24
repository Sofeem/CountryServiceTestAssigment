package com.example.CountryService.Service;


import com.example.CountryService.ExternalAPIRepo.IExternalApiRepository;
import com.example.CountryService.Model.Country;
import com.example.CountryService.Model.CountryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.example.CountryService.exception.CountryNotFoundExecption;

import java.util.List;

/**
 * Service class to handle request for controller
 * <p>this class provides interaction between the controller request and the external api data extraction
 * </p>
 */

@Service
public class DataService implements IService {

    private final IExternalApiRepository iexternalApiRepository;
    //private RestTemplate restTemplate;
    @Autowired
    public DataService(@Qualifier("Api") IExternalApiRepository iexternalApiRepository){

        this.iexternalApiRepository = iexternalApiRepository;
    }

    @Cacheable("fetchCountries")
    public List<Country> fetchCountries() {
        return iexternalApiRepository.fetchCountriesCode();
    }

    @Cacheable("fetchCountryInfo")
    public CountryInfo fetchCountriesByName(String name){


    return iexternalApiRepository.fetchCountryInfo(name);
    }


}
