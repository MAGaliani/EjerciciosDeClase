package com.magaliani.galiweather;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.magaliani.galiweather.model.WeatherInfo;
import com.magaliani.galiweather2.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherInfoFragment extends Fragment {

    Context context;
    TextView temp;

    private int mColumnCount = 1;
    private WeatherInfo weatherInfo;




    public WeatherInfoFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);


        temp.findViewById(R.id.textViewTemp);

        final IGaliWeather galiWeatherApi = ServiceGenerator.createService(IGaliWeather.class);

        Call<WeatherInfo> call = galiWeatherApi.getWeatherByCity("Manchester");

        call.enqueue(new Callback<WeatherInfo>() {
            @Override
            public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response) {
                if(response.isSuccessful()){

                    WeatherInfo weather = response.body();

                    Log.i("Retrofit OK", weather.toString());

                    String textViewTemp = Double.toString(weather.getMain().getTemp());
                    temp.setText(textViewTemp);

                    Toast.makeText(context, "Tiempo disponible", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "No tienes acceso a este recurso ", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<WeatherInfo> call, Throwable t) {
                Toast.makeText(context, "Error, algo fue mal con la red ", Toast.LENGTH_SHORT).show();
                Log.d("Error, algo fue mal :(", t.getMessage());
            }
        });
        return view;
    }
}
