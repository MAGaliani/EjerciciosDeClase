package com.magaliani.galoweather;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.magaliani.galoweather.APIs.GooglePlaces.GooglePlacesApi;
import com.magaliani.galoweather.APIs.OpenWeather.IGaloWeatherApi;
import com.magaliani.galoweather.models.GooglePlaces.details.DetailsResult;
import com.magaliani.galoweather.models.GooglePlaces.prediction.Prediction;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{

    FragmentManager manager = getSupportFragmentManager();
    private BottomNavigationView mbottomNavigationView;
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    manager.beginTransaction()
                            .replace(R.id.frame_layout, new TiempoActualFragment())
                            .commit();
                    return true;
                case R.id.navigation_forecast:
                   /* manager.beginTransaction()
                            .replace(R.id.)
                    mTextMessage.setText(R.string.title_notifications);*/
                    return true;
            }
            return false;
        }
    };

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IGaloWeatherApi api = ServiceGeneratorWeather.createService(IGaloWeatherApi.class);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Fragment f = new TiempoActualFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame_layout,f)
                .commit();
    }

}
