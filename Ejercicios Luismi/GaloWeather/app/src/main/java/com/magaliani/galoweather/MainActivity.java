package com.magaliani.galoweather;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.magaliani.galoweather.APIs.OpenWeather.IGaloWeatherApi;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager = getSupportFragmentManager();
    private TextView mTextMessage;
    private TextView textCiudad, textHumedad, textViento;
    private ImageView fondoImg;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        IGaloWeatherApi api = ServiceGeneratorWeather.createService(IGaloWeatherApi.class);


        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

       // Fragment f = TiempoActualFragment.newInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor,f).commit();
    }

}
