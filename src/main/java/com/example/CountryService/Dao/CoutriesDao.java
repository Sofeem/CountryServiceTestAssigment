package com.example.CountryService.Dao;

import com.example.CountryService.Dto.Country;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class CoutriesDao implements ICountrieDao {
    @Override
    public List<Country> fetchCountries() {
        List<Country> Country = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        //RestTemplate restTemplate;
        //ResponseEntity<String> responseEntity1 =
                //restTemplate.getForEntity("https://countriesnow.space/api/v0.1/countries/iso", String.class);
       // String rawJson = responseEntity1.getBody();

        ResponseEntity<String> responseEntity2 =
                restTemplate.getForEntity("https://countriesnow.space/api/v0.1/countries/capital", String.class);
        String rawJson2 = responseEntity2.getBody();

        ResponseEntity<String> responseEntity3 =
                restTemplate.getForEntity("https://countriesnow.space/api/v0.1/countries/population", String.class);
        String rawJson = responseEntity3.getBody();



        JSONObject root = new JSONObject(rawJson);
        JSONArray countries = root.getJSONArray("data");

        for(int i = 0; i < countries.length(); i++) {
            // the JSON data
            // JSONObject jsonPlant = root.getJSONObject("data");
            String country = countries.getJSONObject(i).getString("name");
            String countryCode = countries.getJSONObject(i).getString("Iso2");

            Country count = new Country();
            count.setCountryName(countries.getJSONObject(i).getString("name"));
            count.setCountryCode(countries.getJSONObject(i).getString("Iso2"));

            Country.add(count);
            //System.out.println("Country: " + country +"," +countryCode);
            //System.out.println(plants.getJSONObject(i).getString("name"));

        }



        return Country;

    }
}
