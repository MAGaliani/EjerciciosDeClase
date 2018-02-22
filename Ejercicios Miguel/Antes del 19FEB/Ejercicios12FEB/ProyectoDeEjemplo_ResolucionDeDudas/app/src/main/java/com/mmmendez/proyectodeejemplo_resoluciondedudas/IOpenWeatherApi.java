package com.mmmendez.proyectodeejemplo_resoluciondedudas;

import com.mmmendez.proyectodeejemplo_resoluciondedudas.model.Weather;
import com.mmmendez.proyectodeejemplo_resoluciondedudas.model.WeatherInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mmmendez on 13/02/2018.
 */

public interface IOpenWeatherApi {

/*TODO Con schema2pojo solo hay que descargar el zip de la clase y donde esten todas, descomprimir y guardar en model*/


//Call de la libreria de retrofit2, para comprobar que funciona ejecutar el postman
    //TODO ***NO se debe pero es para que se entienda(pasar parametos)***
    //@GET("/data/2.5/weather?APPID=4ca07b6f19ce0a920c565f5f14ed7e8d")
    @GET("/data/2.5/weather")
    Call<WeatherInfo> getWeatherByCity(@Query("q") String city);//Con esto cambiamos al main
}
