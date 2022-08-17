package com.example.CountryService.Service;

import com.example.CountryService.Model.Country;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JsonParser implements IJsonParserService {

    @Override
    public String fetchCountriesJson(List<Country> elements) {
        JSONArray array = new JSONArray(elements);
                JSONObject jo = new JSONObject();
                jo.put("countries", array);
        return jo.toString();
    }
    @Override
    public String fetchCountriesByNameJsom(List<String> elements) {
        JSONObject ele = new JSONObject();
        List<String> keys = Arrays.asList(new String[]{"country", "country_code", "capital", "population", "flag_file_url"});

        //for (String key:keys) {
           //ele.put( key, elements);
      // }

        for (int i = 0; i < keys.size(); i++) {
            ele.put(keys.get(i),elements.get(i)); }


        return ele.toString();
    }
}
