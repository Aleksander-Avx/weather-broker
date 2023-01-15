package com.avx.weatherbroker;

import com.avx.weatherbroker.entity.WeatherEntity;
import com.avx.weatherbroker.service.WeatherService;
import com.avx.weatherbroker.webclient.dtowebclient.OpenWeatherDto;
import com.avx.weatherbroker.webclient.webservice.WeatherClientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class WeatherModulTest {

    @Autowired
    private WeatherClientService weatherClientService;
    @MockBean
    private WeatherService weatherService;

    private String city = "Penza";

    @Test
    public void getInfoTest() {

        /**
         * Возвращаем прогноз города когда у weatherService вызываем метод getInfo с городом
         */
        Mockito.doReturn(new WeatherEntity()).when(weatherService).getInfo(city);

        String insert = String.valueOf(weatherService.getInfo(city));

        Assertions.assertFalse(insert.isEmpty());
    }

    /**
     * Проверка метода getWeatherForCity, на получение города
     */
    @Test
    public void getWeatherForCityTest() {

        OpenWeatherDto weatherForCity = weatherClientService.getWeatherForCity(city);

        Assertions.assertEquals(weatherForCity.getName(), city);

    }
}