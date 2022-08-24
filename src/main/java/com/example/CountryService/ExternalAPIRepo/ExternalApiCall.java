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

/**
 * The service act as repository for other service to provide the data.
 * <p>this class handles the external api request operations for accessing the country information, via api
 * </p>
 */

@Repository("Api")
public class ExternalApiCall implements IExternalApiRepository {

    RestTemplate restTemplate = new RestTemplate();
    @Nullable
    String code;
    String population;
    String capital;
    String flagfileurl;


    /**
     * Get a list of country codes object  from external api call
     *
     * @return String response (list of Objects: country codes)
     */


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
    /**
     * Get a country Information object provided the country name for external api call
     *
     * @params (country name)
     * @return String response (Object country Information)
     */

    @Override
    public CountryInfo fetchCountryInfo(String name) {

         String cCode = getCode(name);
         String cPopulation = getPopulation(name);
         String cCapital = getCapital(name);
         String cFlagFileUrl = getFlagFileUrl(name);

        return new CountryInfo(name,cCode,cCapital,cPopulation,cFlagFileUrl);
    }



    /**
     * Get a country code provided the country name for external api call
     *
     * @params (country name)
     * @return String response (Iso2 code)
     */

    public String getCode(String name){

        String rawJsonCode = getApiResponseBody("https://countriesnow.space/api/v0.1/countries/iso");
        code = getApiCallServiceString(rawJsonCode, name,"Iso2","name");
        return code;
    }


    /**
     * Get a country capital provided the country name for external api call
     *
     * @params (country name)
     * @return String response (capital)
     */


    public String getCapital(String countryName){
        String rawJsonCapital = getApiResponseBody("https://countriesnow.space/api/v0.1/countries/capital");
        capital = getApiCallServiceString(rawJsonCapital,countryName,"capital","name");
        return capital;}

    public String getFlagFileUrl(String countryName){

        String rawJsonImageFile = getApiResponseBody("https://countriesnow.space/api/v0.1/countries/flag/images");
        flagfileurl = getApiCallServiceString(rawJsonImageFile,countryName,"flag","name");
        return flagfileurl;
    }

    /**
     * Get a population provided the country name for external api call
     *
     * @params (country name)
     * @return String response (population)
     */

   public String getPopulation(String countryName){

       ResponseEntity<String> responseEntity =
               restTemplate.getForEntity("https://countriesnow.space/api/v0.1/countries/population", String.class);

       String rawJson = responseEntity.getBody();
       JSONObject result = getApiCallServiceJson(rawJson,countryName,"country");

       JSONArray populationCounts;
       populationCounts = result.getJSONArray("populationCounts");

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

    /**
     * Get an json object response for external api call
     *
     * @params (body, name. collector)
     * @return String response (capital, code, flag url)
     */

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

    /**
     * Get an json object response for external api call
     *
     * @params (body, name. collector)
     * @return String response (capital, code, flag url)
     */

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

    /**
     * Get an response for external api call
     *
     * @param uri
     * @return String response (capital, code, flag url)
     */

    public String getApiResponseBody(String uri){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity =
                restTemplate.getForEntity(uri, String.class);
        return responseEntity.getBody();
    }



}
