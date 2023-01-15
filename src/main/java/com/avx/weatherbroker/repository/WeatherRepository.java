package com.avx.weatherbroker.repository;

import com.avx.weatherbroker.entity.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherEntity, Long> {

    WeatherEntity getWeatherEntitiesByCity(String city);

}
