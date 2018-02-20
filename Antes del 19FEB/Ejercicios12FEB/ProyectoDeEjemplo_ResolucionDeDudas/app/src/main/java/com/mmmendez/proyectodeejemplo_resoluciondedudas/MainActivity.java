package com.mmmendez.proyectodeejemplo_resoluciondedudas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.mmmendez.proyectodeejemplo_resoluciondedudas.model.WeatherInfo;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    public MainActivity() throws IOException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



/**TODO PASO 1
 * Conectamos nuestra interfaz IOpenWeatherApi con nuestro generador de servicios y creamos el servicio de dicha interfaz*/
        final IOpenWeatherApi weatherApi = Servicio.createService(IOpenWeatherApi.class);


/**TODO PASO 2
 * Usamos un Call<T> de nuestra clase principal y usamos el método deseado con los parámetros necesarios (si los tiene) */
        Call<WeatherInfo> call = weatherApi.getWeatherByCity("Seville");



/**TODO PASO 3
 * Recibimos el cuerpo de la respuesta con el método onResponse() que toma como parámetros la llamada anterior de call y una
 * respuesta*/
        call.enqueue(new Callback<WeatherInfo>() {
            @Override
            public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response) {
                if(response.isSuccessful()){

                    /*En el objeto weatherInfo guardamos la respuesta del body y la pasamos por el log para
                    * probar que funciona*/
                    WeatherInfo weather = response.body();

                    Log.i("Retrofit OK", weather.toString());

                    Toast.makeText(MainActivity.this, "Tiempo disponible", Toast.LENGTH_SHORT).show();
                }else{

                    Toast.makeText(MainActivity.this, "Error, No tienes acceso a este recurso", Toast.LENGTH_SHORT).show();

                }
            }


            @Override
            public void onFailure(Call<WeatherInfo> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error, algo fue mal con la red ", Toast.LENGTH_SHORT).show();
                Log.d("Error, algo fue mal :(", t.getMessage());
            }
        });
    }



}
