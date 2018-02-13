package com.magaliani.restartingretrofit;

import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by magaliani on 13/02/18.
 */

public interface OpenWeatherApi {

    @GET("/weather?q=München,DE&appid=49a384a32e901a09cb9bbec19ee13499")
    Call<WeatherInfo> getWeatherInfoByCity(@Query("q") String city);
}
