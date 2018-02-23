package com.magaliani.galoweather.APIs.OpenWeather;

import com.magaliani.galoweather.models.OpenWeather.WeatherInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by magaliani on 22/02/18.
 */

public interface IGaloWeatherApi {

    @GET("/data/2.5/weather")
    Call<WeatherInfo> getWeatherByCity(@Query("q")String city);

}
