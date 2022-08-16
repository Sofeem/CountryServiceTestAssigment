package com.example.CountryService.Controller;


import com.example.CountryService.Country;
import com.example.CountryService.Service.countryService;
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
    public final countryService countryservice;

    public countryServiceController(countryService countryservice) {
        this.countryservice = countryservice;
    }

   // @GetMapping(uri"/countries /{names}")
    //public ResponseEntity<List<Country>> getAllAppointments(){
       // List<Country> countries = countryservice.findAllAppointments();
        //return new ResponseEntity<>(countries, HttpStatus.OK);
    //}
    @GetMapping("/countries")
    public ResponseEntity  fetchetAllcountries(){
        //List<Country> countries = countryservice.findAllCountries();
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/coutries/{name}/")
   public ResponseEntity fetchCountryByName(@PathVariable("name") String name){
       return new ResponseEntity(HttpStatus.OK);
    }

}
