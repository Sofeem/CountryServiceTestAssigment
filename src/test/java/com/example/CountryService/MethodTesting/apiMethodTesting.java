package com.example.CountryService.MethodTesting;
import com.example.CountryService.ExternalAPIRepo.ExternalApiCall;
import com.example.CountryService.ExternalAPIRepo.IExternalApiRepository;

import com.example.CountryService.Model.Country;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(ExternalApiCall.class)
@AutoConfigureMockMvc
public class apiMethodTesting {

    @MockBean
    private ExternalApiCall externalApicall;



    @Test
    public void ExternalApiCallGetCode() throws Exception {
        String code = "FI";
        Mockito.when(externalApicall.getCapital("Finland")).thenReturn(code);
    }
    @Test
    public void ExternalApiCallGetCapital() throws Exception {
      String capital = "O";
        Mockito.when(externalApicall.getCapital("Finland")).thenReturn(capital);
    }

    @Test
    public void ExternalApiCallGetFlagURL() throws Exception {
        String flagUrl = "https://upload.wikimedia.org/wikipedia/commons/9/9a/Flag_of_Afghanistan.svg";
        Mockito.when(externalApicall.getCapital("Afghanistan")).thenReturn(flagUrl);
    }

    @Test
    public void ExternalApiCallGetPopulation() throws Exception {
        String countryName = "Fin";
        Mockito.when(externalApicall.getCapital("Finland")).thenReturn(countryName);

    }

    @Test
    public void ExternalApiCallGetCapitalString() throws Exception {
        String Json = "";
        String countryName = "Ban";
        String code = "FI";
        Mockito.when(externalApicall.getApiCallServiceString(Json,countryName,"Iso2","name")).thenReturn(code);

    }
    @Test
    public void ExternalApiCallGetCodeString() throws Exception {
        String Json = "{\"error\":false,\"msg\":\"countriesandcurrenciesretrieved\",\"data\":[{\"name\":\"Bangladesh\",\"currency\":\"BDT\",\"iso2\":\"BD\",\"iso3\":\"BGD\"}]}";
        String countryName = "Bangladesh";
        String code = "BD";
        Mockito.when(externalApicall.getApiCallServiceString(Json,countryName,"Iso2","name")).thenReturn(code);

    }



}
