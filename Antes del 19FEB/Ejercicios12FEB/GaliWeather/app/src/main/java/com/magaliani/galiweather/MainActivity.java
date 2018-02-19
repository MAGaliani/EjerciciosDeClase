package com.magaliani.galiweather;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;


import com.magaliani.galiweather.model.WeatherInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //TextView temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment weather_fragment = new WeatherInfoFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contenedor,weather_fragment)
                .commit();
    }
}