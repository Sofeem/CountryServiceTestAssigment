package com.example.CountryService.Controller;


import com.example.CountryService.Model.Country;
import com.example.CountryService.Model.CountryInfo;
import com.example.CountryService.Service.DataService;
import com.example.CountryService.Service.IJsonParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/")
public class countryServiceController {


    /**
     * Handle the root (/) endpoint and return a startpage
      */
    @Autowired
    public final DataService dataService;
    @Autowired
    //public final IJsonParserService jsonParserServe;

    public countryServiceController(DataService dataService) {
        this.dataService = dataService;
        //this.jsonParserServe = jsonParserServe;

    }

   // @GetMapping(uri"/countries /{names}")
    //public ResponseEntity<List<Country>> getAllAppointments(){
       // List<Country> countries = countryservice.findAllAppointments();
        //return new ResponseEntity<>(countries, HttpStatus.OK);
    //}
    @GetMapping("/countries")
    public @ResponseBody  List<Country> fetchetAllcountries(){
        /* String cCountries = jsonParserServe.fetchCountriesJson(countries); */

        return dataService.fetchCountries();
    }

    @GetMapping("/countries/{name}")
   public @ResponseBody CountryInfo fetchCountryByName(@PathVariable("name") String name){
        //String nCountries = jsonParserServe.fetchCountriesByNameJsom(countries);
       return dataService.fetchCountriesByName(name);
    }

}
