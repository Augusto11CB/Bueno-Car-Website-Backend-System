package com.udacity.pricing;

import com.udacity.pricing.api.PricingController;
import com.udacity.pricing.service.PricingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(PricingController.class)
public class PricingServiceUnitTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PricingService pricingService;

    @Test
    public void getPriceByID() throws Exception {
        Long vehicleId = 1L;
        mockMvc.perform(get("/services/price?vehicleId=" + vehicleId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.vehicleId").value(1))
                .andExpect(jsonPath("$.price").isNumber())
                .andExpect(jsonPath("$.currency").value("USD"));


    }

}
