package com.magaliani.restartingretrofit;

import com.magaliani.restartingretrofit.model.WeatherInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by magaliani on 13/02/18.
 */

public interface OpenWeatherApi {

    //@GET("/data/2.5/weather?q=München,DE&appid=49a384a32e901a09cb9bbec19ee13499")
    @GET("/data/2.5/weather")
    Call<WeatherInfo> getWeatherInfoByCity(@Query("q") String city);
}
