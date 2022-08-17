package com.example.CountryService.Repoexternalapi;

import com.example.CountryService.model.Country;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.context.properties.ConfigurationProperties;
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


    @Nullable
    String code;
    String population;
    String capital;
    String flagfileurl;

    @Override
    public List<Country> fetchCountriesCode() {

        List<Country> countries = new ArrayList<>();
        String rawJson = getApiResponseBody("https://countriesnow.space/api/v0.1/countries/iso");
        JSONObject root = new JSONObject(rawJson);
        JSONArray countryNameCode = root.getJSONArray("data");

        for(int i = 0; i < countryNameCode.length(); i++) {

            String countriesName = countryNameCode.getJSONObject(i).getString("name");
            countries.add((Country) fetchCountryInfo(countriesName));
        }
        return countries;
    }


    public List<String> fetchCountryInfo(String name) {

         String cCode = getCode(name);
         //String cPopulation = getPopulation(name);
         String cCapital = getCapital(name);
         String cFlagFileUrl = getFlagFileUrl(name);

        //String info =

        return Stream.of(name, cCode, cCode, cCapital,cFlagFileUrl)
                .collect(Collectors.toList());
    }


    public String getCode(String name){
        String rawJsonCode = getApiResponseBody("https://countriesnow.space/api/v0.1/countries/iso");
        code = getApiCallServiceString(rawJsonCode, name,"Iso2","name");
        return code;
    }
    public String getCapital(String countryName){
        String rawJsonCapital = getApiResponseBody("https://countriesnow.space/api/v0.1/countries/capital");
        capital = getApiCallServiceString(rawJsonCapital,countryName,"captial","name");
        return capital;
    }
    public String getFlagFileUrl(String countryName){
        String rawJsonImageFile = getApiResponseBody("https://countriesnow.space/api/v0.1/countries/flag/images");
        flagfileurl = getApiCallServiceString(rawJsonImageFile,countryName,"flag","name");
        return flagfileurl;
    }
    public String getPopulation(String countryName){
        String rawJsonPopulation = getApiResponseBody("https://countriesnow.space/api/v0.1/countries/flag/images");

        //Second Level Extract of JsonArray
        JSONObject populationCounts = getApiCallServiceJson(rawJsonPopulation,countryName,"country");
        JSONArray aPopulationCounts = populationCounts.getJSONArray("populationCounts");
        for(int j = 0; j<aPopulationCounts.length();j++ ) {
            JSONObject obj = (JSONObject) aPopulationCounts.get(j);
            //String result1 = obj.getString("year");
            if (obj.get("year").equals(2018)) {
                System.out.println(obj.get("value"));
                population = obj.get("value").toString();
                break;
            }
        }
        return population;
    }

    //////Service

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
            //if (obj.get("code").equals()) {
                r = (JSONObject) data.get(i);
                //break;
           // }
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
