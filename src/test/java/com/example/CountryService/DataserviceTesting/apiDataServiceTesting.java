package com.example.CountryService.DataserviceTesting;
import com.example.CountryService.Controller.countryServiceController;
import com.example.CountryService.Model.Country;
import com.example.CountryService.Model.CountryInfo;
import com.example.CountryService.Service.DataService;
import com.example.CountryService.Service.IService;
import org.junit.Assert;
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
@WebMvcTest(DataService.class)
@AutoConfigureMockMvc

public class apiDataServiceTesting {


    @MockBean
    private IService dataService;

    @Test
    public void DataServiceFetchAllCountriesCodes() throws Exception {

        Country cCodes = new Country();
        cCodes.setName("Finland");
        cCodes.setCountry_code("FI");
        List<Country> allCCodes = Collections.singletonList(cCodes);

        Mockito.when(dataService.fetchCountries()).thenReturn(allCCodes);

    }
    @Test
    public void DataServiceFetchCountryInformation() throws Exception {

        CountryInfo countryInfo = new CountryInfo("Finland","FI","Helsinki","5491817","img");
        Mockito.when(dataService.fetchCountriesByName("Sweden")).thenReturn(countryInfo);

       }

}
