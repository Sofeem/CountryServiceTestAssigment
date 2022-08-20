package com.example.CountryService.ExternalAPIRepo;

import com.example.CountryService.Model.Country;
import com.example.CountryService.Model.CountryInfo;
import org.json.JSONArray;
import org.json.JSONObject;
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
            count.setName(countriesName);
            count.setCountry_code(countryCode);

            countries.add(count);
            //System.out.println("Country: " + country +"," +countryCode);
            //System.out.println(plants.getJSONObject(i).getString("name"));

        }
        return countries;
    }

    @Override
    public CountryInfo fetchCountryInfo(String name) {

         String cCode = getCode(name);
         String cPopulation = getPopulation(name);
         String cCapital = getCapital(name);
         String cFlagFileUrl = getFlagFileUrl(name);

        return new CountryInfo(name,cCode,cCapital,cPopulation,cFlagFileUrl);
    }

    public String getCode(String name){

        String rawJsonCode = getApiResponseBody("https://countriesnow.space/api/v0.1/countries/iso");
        code = getApiCallServiceString(rawJsonCode, name,"Iso2","name");
        return code;
    }


    public String getCapital(String countryName){
        String rawJsonCapital = getApiResponseBody("https://countriesnow.space/api/v0.1/countries/capital");
        capital = getApiCallServiceString(rawJsonCapital,countryName,"capital","name");
        return capital;}

    public String getFlagFileUrl(String countryName){

        String rawJsonImageFile = getApiResponseBody("https://countriesnow.space/api/v0.1/countries/flag/images");
        flagfileurl = getApiCallServiceString(rawJsonImageFile,countryName,"flag","name");
        return flagfileurl;
    }



   public String getPopulation(String countryName){

       ResponseEntity<String> responseEntity =
               restTemplate.getForEntity("https://countriesnow.space/api/v0.1/countries/population", String.class);

       String rawJson = responseEntity.getBody();
       JSONObject result = getApiCallServiceJson(rawJson,countryName,"country");
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

    public String getApiCallServiceString(String body, String name, String accessor, String collector) {

        String r = null;
        JSONObject root = new JSONObject(body);
        JSONArray data = root.getJSONArray("data");

        for (int i = 0; i < data.length(); i++) {
            JSONObject obj = (JSONObject) data.get(i);
            if (obj.get(collector).equals(name)) {
                r = obj.get(accessor).toString();
                break;
            }
        }
        return r;
    }

    public JSONObject getApiCallServiceJson(String body, String name, String collector) {

        JSONObject r = null;
        JSONObject root = new JSONObject(body);
        JSONArray data = root.getJSONArray("data");

        for (int i = 0; i < data.length(); i++) {
            JSONObject obj = (JSONObject) data.get(i);
            if (obj.get(collector).equals(name)) {
            r = (JSONObject) data.get(i);
            break;
             }
        }
        return r;
    }

    public String getApiResponseBody(String uri){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity =
                restTemplate.getForEntity(uri, String.class);
        return responseEntity.getBody();
    }



}
