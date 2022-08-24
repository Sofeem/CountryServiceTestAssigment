package com.example.CountryService.Controller;


import com.example.CountryService.Model.Country;
import com.example.CountryService.Model.CountryInfo;
import com.example.CountryService.Service.DataService;
import com.example.CountryService.Service.IJsonParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/")
public class countryServiceController {

    /**
     * The controller for COUNTRY SERVICES ENDPOINTS AND WEBUI
     * <p>this class handles the api endpoints operations for the country service applications, via rest controllers
     * </p>
     * <p>this class also serves HTML based web application, for UI interactions with country services</p>
     */
    @Autowired
    public final DataService dataService;



    @Autowired
    public countryServiceController(DataService dataService) {
        this.dataService = dataService;
    }

    /**
     *Get an instance of list of countries codes object,
     *
     * Return one of the following code:
     * 200: Status Ok
     * 404: Not found
     * @return the response from the dataservice
     */
    @GetMapping("/countries")
    public @ResponseBody  List<Country> fetchetAllCountries(){
        return dataService.fetchCountries();
    }

    /**
     *Get an instance of country information object,
     *
     * Return one of the following code:
     * 200: Status Ok
     * 404: Not found
     * @return the response from the dataservice
     */

    @GetMapping("/countries/{name}")
   public @ResponseBody CountryInfo fetchCountryByName(@PathVariable("name") String name){
        //String nCountries = jsonParserServe.fetchCountriesByNameJsom(countries);
       return dataService.fetchCountriesByName(name);
    }

}
