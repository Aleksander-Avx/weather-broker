package com.avx.weatherbroker.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WeatherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "temperature")
    private int temperature;

    @Column(name = "pressure")
    private int pressure;

    @Column(name = "humidity")
    private int humidity;

    @Column(name = "windSpeed")
    private float windSpeed;

    @Column(name = "country")
    private String county;

    @Column(name = "city")
    private String city;
}
