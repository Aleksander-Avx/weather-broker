package com.avx.weatherbroker.webclient.dtowebclient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpenWeatherMainDto {

    private Integer temp;  // температура

    private Integer pressure;  // давление

    private Integer humidity;  // влажность

}
