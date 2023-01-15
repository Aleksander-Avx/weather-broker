package com.avx.weatherbroker;

import com.avx.weatherbroker.controller.WeatherController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WeatherIntegrationTest {

    @Autowired
    private WeatherController weatherController;
    @Autowired
    private MockMvc mockMvc;

    /**
     * Наличие contextLoads на месте
     */
    @Test
    public void contextLoads() {
        assertThat(weatherController).isNotNull();
    }

    /**
     * Cценарий хорошего запроса
     */
    @Test
    public void goodRequestTest() throws Exception {
        this.mockMvc.perform(get("/weather").param("city", "Penza"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}