package com.example.CountryService.controllertesting;


import com.example.CountryService.Controller.countryServiceController;
import com.example.CountryService.Model.Country;
import com.example.CountryService.Model.CountryInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;

import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(countryServiceController.class)
@AutoConfigureMockMvc
public class apiControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private countryServiceController csc;

    @Test
    public void fetchAllCountryCodes() throws Exception {

        Country cCodes = new Country();
        cCodes.setName("Finland");
        cCodes.setCountry_code("FI");


        List<Country> allCCodes = Collections.singletonList(cCodes);

        given(csc.fetchetAllcountries()).willReturn(allCCodes);


        mvc.perform(get( "/countries")
                        .contentType(APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$", hasSize(1)))
                        .andExpect(jsonPath("$[0].name", is(cCodes.getName())));

    }

    @Test
    public void fetchCountryInformation() throws Exception {

        CountryInfo countryInfo = new CountryInfo("Finland","FI","Helsinki","5491817","img");



        given(csc.fetchCountryByName("Finland")).willReturn(countryInfo);


        mvc.perform(get( "/countries/Finland")
                        .contentType(APPLICATION_JSON))
                         .andExpect(status().isOk());

    }

}
