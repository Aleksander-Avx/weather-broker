package com.avx.weatherbroker.webclient.webservice;

import com.avx.weatherbroker.webclient.dtowebclient.OpenWeatherDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Slf4j
@Service
public class WeatherClientServiceImpl implements WeatherClientService {
    private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/";
    private static String URL_PARAM = "weather?q={city}&appid={apiKey}&units=metric&lang=pl";
    private static final String API_KEY = "89a2cc998f1d60ceecbba5f3c285a705";


    /**
     * HTTP-клиент, встроенный в SPRING, включает преобразование JSON -> JAVA OBJ
     **/
    private RestTemplate restTemplate = new RestTemplate();

    public OpenWeatherDto getWeatherForCity(String city) {

        log.info("LOGGER: Formation RestTemplate construction");
        log.info("LOGGER: weather-test -> openweather (getWeatherForCity)");

        OpenWeatherDto openWeatherWeatherDto = callGetMethod(URL_PARAM,
                OpenWeatherDto.class,
                city, API_KEY);
        return openWeatherWeatherDto;
    }

    /**
     * Формирование адресной строки и ключа доступа для создания RestTemplate
     */
    private <T> T callGetMethod(String url, Class<T> responseType, Object... objects) {
        return restTemplate.getForObject(WEATHER_URL + url,
                responseType, objects);
    }
}