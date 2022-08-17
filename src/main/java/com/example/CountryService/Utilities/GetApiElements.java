package com.example.CountryService.Utilities;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import reactor.util.annotation.Nullable;

public class GetApiElements {


    //public GetApiElements{}



    public String getApiCallService(String body, String name, String accessor, String collector) {
        
        String result = null;
        JSONObject root = new JSONObject(body);
        JSONArray data = root.getJSONArray("data");
        
        for (int i = 0; i < data.length(); i++) {
            JSONObject obj = (JSONObject) data.get(i);
            if (obj.get(collector).equals(name)) {
                result = obj.get(accessor).toString();
                break;
            }

        }

        return result;
    }
}
