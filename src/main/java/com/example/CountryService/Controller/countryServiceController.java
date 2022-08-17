package com.example.CountryService.Controller;


import com.example.CountryService.model.Country;
import com.example.CountryService.service.DataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class countryServiceController {


    /**
     * Handle the root (/) endpoint and return a startpage
      */
    public final DataService dataService;

    public countryServiceController(DataService dataService) {
        this.dataService = dataService;
    }

   // @GetMapping(uri"/countries /{names}")
    //public ResponseEntity<List<Country>> getAllAppointments(){
       // List<Country> countries = countryservice.findAllAppointments();
        //return new ResponseEntity<>(countries, HttpStatus.OK);
    //}
    @GetMapping("/countries")
    public ResponseEntity<List<Country>>  fetchetAllcountries(){
        List<Country> countries = dataService.fetchCountries();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

  //  @GetMapping("/countries/{name}")
   //public ResponseEntity<?> fetchCountryByName(@PathVariable("name") String name){
       // List<String> countries = dataService.fetchCountriesByName(name);
       //return new ResponseEntity<>(/countries,HttpStatus.OK);
    //}

}
