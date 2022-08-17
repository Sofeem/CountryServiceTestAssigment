package com.example.CountryService.Dao;

import com.example.CountryService.Dto.Country;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import reactor.util.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository("Api")
public class ExternalApiCall implements IExternalApiRepository {

    RestTemplate restTemplate = new RestTemplate();
    @Nullable
    String code;
    String population;
    String capital;
    String flagfileurl;

    @Override
    public List<Country> fetchCountriesCode() {
        List<Country> countries = new ArrayList<>();

        ResponseEntity<String> responseEntity =
                restTemplate.getForEntity("https://countriesnow.space/api/v0.1/countries/iso", String.class);

        String rawJson = responseEntity.getBody();
        JSONObject root = new JSONObject(rawJson);
        JSONArray countryNameCode = root.getJSONArray("data");

        //Country count = new Country();

        for(int i = 0; i < countryNameCode.length(); i++) {
            // the JSON data
            // JSONObject jsonPlant = root.getJSONObject("data");
            String countriesName = countryNameCode.getJSONObject(i).getString("name");
            String countryCode = countryNameCode.getJSONObject(i).getString("Iso2");

            Country count = new Country();
            count.setCountryName(countriesName);
            count.setCountryCode(countryCode);

            countries.add(count);
            //System.out.println("Country: " + country +"," +countryCode);
            //System.out.println(plants.getJSONObject(i).getString("name"));

        }


        return countries;
    }

    @Override
    public List<String> fetchCountryInfo(String name) {

         String cCode = getCode(name);
         String cPopulation = getPopulation(name);
         String cCapital = getCapital(name);
         String cFlagFileUrl = getFlagFileUrl(name);

        //String info =

        return Stream.of(name, cCode, cPopulation, cCapital,cFlagFileUrl)
                .collect(Collectors.toList());
    }



    public String getCode(String name){

            ResponseEntity<String> responseEntity =
                    restTemplate.getForEntity("https://countriesnow.space/api/v0.1/countries/iso", String.class);

            String rawJson = responseEntity.getBody();
            JSONObject root = new JSONObject(rawJson);
            JSONArray countryNameCode = root.getJSONArray("data");
            for (int i = 0; i < countryNameCode.length(); i++) {
                JSONObject obj = (JSONObject) countryNameCode.get(i);
                if (obj.get("name").equals(name)) {
                    //System.out.println(obj);
                    code = obj.get("Iso2").toString();
                    break;
                }
            }

            return code;

    }

   public String getPopulation(String countryName){

       ResponseEntity<String> responseEntity =
               restTemplate.getForEntity("https://countriesnow.space/api/v0.1/countries/population", String.class);

       String rawJson = responseEntity.getBody();
       JSONObject root = new JSONObject(rawJson);
       JSONArray countryNameCode = root.getJSONArray("data");
       JSONObject result = null;
       for (int i = 0; i < countryNameCode.length(); i++) {
           JSONObject obj = (JSONObject) countryNameCode.get(i);
           if (obj.get("country").equals(countryName)) {
               //System.out.println(obj);
               result = obj;
               break;
           }
       }

       JSONArray populationCounts = result.getJSONArray("populationCounts");

       for(int j = 0; j<populationCounts.length();j++ ) {
           JSONObject obj = (JSONObject) populationCounts.get(j);
           //String result1 = obj.getString("year");
           if (obj.get("year").equals(2018)) {

               System.out.println(obj.get("value"));
               population = obj.get("value").toString();
               break;
           }

       }



   return population;
    
    
    }

    public String getCapital(String countryName){
        ResponseEntity<String> responseEntity =
                restTemplate.getForEntity("https://countriesnow.space/api/v0.1/countries/capital", String.class);

        String rawJson = responseEntity.getBody();
        JSONObject root = new JSONObject(rawJson);
        JSONArray countryNameCode = root.getJSONArray("data");
        for (int i = 0; i < countryNameCode.length(); i++) {
            JSONObject obj = (JSONObject) countryNameCode.get(i);
            if (obj.get("name").equals(countryName)) {
                //System.out.println(obj);
                capital = obj.get("capital").toString();
                break;
            }
        }

        return capital;}

    public String getFlagFileUrl(String countryName){

        ResponseEntity<String> responseEntity =
                restTemplate.getForEntity("https://countriesnow.space/api/v0.1/countries/flag/images", String.class);

        String rawJson = responseEntity.getBody();
        JSONObject root = new JSONObject(rawJson);
        JSONArray countryNameCode = root.getJSONArray("data");
        for (int i = 0; i < countryNameCode.length(); i++) {
            JSONObject obj = (JSONObject) countryNameCode.get(i);
            if (obj.get("name").equals(countryName)) {
                //System.out.println(obj);
                flagfileurl = obj.get("flag").toString();
                break;
            }
        }


        return flagfileurl;}


}
