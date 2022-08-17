package com.example.CountryService.Controller;


import com.example.CountryService.Model.Country;
import com.example.CountryService.Service.DataService;
import com.example.CountryService.Service.IJsonParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@CrossOrigin("*")
public class countryServiceController {


    /**
     * Handle the root (/) endpoint and return a startpage
      */
    @Autowired
    public final DataService dataService;
    @Autowired
    public final IJsonParserService jsonParserServe;

    public countryServiceController(DataService dataService, IJsonParserService jsonParserServe) {
        this.dataService = dataService;
        this.jsonParserServe = jsonParserServe;

    }

   // @GetMapping(uri"/countries /{names}")
    //public ResponseEntity<List<Country>> getAllAppointments(){
       // List<Country> countries = countryservice.findAllAppointments();
        //return new ResponseEntity<>(countries, HttpStatus.OK);
    //}
    @GetMapping("/countries")
    public ResponseEntity<?>  fetchetAllcountries(){
        List<Country> countries = dataService.fetchCountries();
        String cCountries = jsonParserServe.fetchCountriesJson(countries);

        return new ResponseEntity<>(cCountries, HttpStatus.OK);
    }

    @GetMapping("/countries/{name}")
   public ResponseEntity<?> fetchCountryByName(@PathVariable("name") String name){
        List<String> countries = dataService.fetchCountriesByName(name);
        String nCountries = jsonParserServe.fetchCountriesByNameJsom(countries);
       return new ResponseEntity<>(nCountries,HttpStatus.OK);
    }

}
