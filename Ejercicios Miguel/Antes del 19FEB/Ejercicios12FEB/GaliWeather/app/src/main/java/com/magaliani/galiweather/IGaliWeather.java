package com.magaliani.galiweather;

import com.magaliani.galiweather.model.WeatherInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by GaloMcTunki on 18/02/2018.
 */

public interface IGaliWeather {


    @GET("/data/2.5/weather")
    Call<WeatherInfo> getWeatherByCity(@Query("q") String city);

   /* @GET("/data/2.5/forecast/")
    Call<ForecastInfo> getWeatherWithFiveDays(@Query("q")String city);*/
}
