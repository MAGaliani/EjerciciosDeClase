package com.magaliani.galoweather;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

import com.magaliani.galoweather.APIs.GooglePlaces.GooglePlacesApi;
import com.magaliani.galoweather.APIs.OpenWeather.IGaloWeatherApi;
import com.magaliani.galoweather.models.GooglePlaces.details.DetailsResult;
import com.magaliani.galoweather.models.GooglePlaces.prediction.Prediction;
import com.magaliani.galoweather.models.OpenWeather.Weather;
import com.magaliani.galoweather.models.OpenWeather.WeatherInfo;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TiempoActualFragment extends Fragment {

    private static final String ARG_CIUDAD = "ciudad";
    private static final String ARG_TEMPERATURA = "temperatura";
    private static final String ARG_HUMEDAD = "humedad";
    private static final String ARG_VIENTO = "viento";

    private String mCiudad;
    private String mTemperatura;
    private String mHumedad;
    private String mViento;
    private String descriptionTime;

    // TODO: Rename and change types of parameters

    AutoCompleteTextView autoCompleteTextView;
    ImageView imageFond, imageViewWeather;

    GooglePlacesApi googlePlacesApi;
    Prediction pred;

    private WeatherInfo pojoWeatherInfo, oiyo;
    private Weather pojoWeather;
    private TextView textCiudad, textHumedad, textViento, textTemperatura;

    private IGaloWeatherApi mListenerWeather;

    public TiempoActualFragment() {
        // Required empty public constructor
    }

    public static TiempoActualFragment newInstance() {
        TiempoActualFragment fragment = new TiempoActualFragment();
        /*Bundle args = new Bundle();
        args.putString(ARG_CIUDAD, ciudad);
        args.putString(ARG_TEMPERATURA, temperatura);
        args.putString(ARG_VIENTO, viento);
        fragment.setArguments(args);*/
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* if (getArguments() != null) {
            ciudad = getArguments().getString(ARG_CIUDAD);
            temperatura = getArguments().getString(ARG_TEMPERATURA);
            viento = getArguments().getString(ARG_VIENTO);
        }*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup contendor,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tiempo_actual, contendor, false);


        autoCompleteTextView = view.findViewById(R.id.autoCompleteTextView);
        autoCompleteTextView.setAdapter(new GooglePlacesResultAdapter(getContext()));

        textCiudad = view.findViewById(R.id.textViewCity);
        textTemperatura = view.findViewById(R.id.textViewTemp);
        textHumedad = view.findViewById(R.id.textViewHumedad);
        textViento = view.findViewById(R.id.TextViewViento);
        imageFond = view.findViewById(R.id.ImageViewfondo);
        imageViewWeather = view.findViewById(R.id.imageViewWeather);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GooglePlacesApi googlePlacesApi = ServiceGeneratorGooglePlaces.createService(GooglePlacesApi.class);
                Prediction p = (Prediction) autoCompleteTextView.getAdapter().getItem(position);
                final Call<DetailsResult> callGoogle =  googlePlacesApi.getPlaceDetails(p.getPlace_id());
                getFragmentManager().beginTransaction().detach(TiempoActualFragment.this).attach(TiempoActualFragment.this).commit();

                callGoogle.enqueue(new Callback<DetailsResult>() {
                    @Override
                    public void onResponse(Call<DetailsResult> call, Response<DetailsResult> response) {
                        if (response.isSuccessful()){
                            DetailsResult result = response.body();

                            if (result.getResult().getPhotos() != null) {
                                if (!result.getResult().getPhotos().isEmpty()) {
                                    String photo_url = String.format("https://maps.googleapis.com/maps/api/place/photo?maxwidth=1000&key=AIzaSyD_FMG1EnTUm3Ja7bSnlCV2VINLFq7rLMw&photoreference=%s", result.getResult().getPhotos().get(0).getPhoto_reference());
                                    Picasso
                                            .with(getContext())
                                            .load(photo_url)
                                            .fit()
                                            .centerCrop()
                                            .into(imageFond);
                                }
                            }
                            else{
                                imageFond.setImageResource(R.drawable.background_degree);
                            }

                            IGaloWeatherApi iGaloWeatherApi = ServiceGeneratorWeather.createService(IGaloWeatherApi.class);

                            Call<WeatherInfo> weatherInfoCall = iGaloWeatherApi.getWeatherInfoByCoords(
                                    result.getResult().getGeometry().getLocation().getLat(),
                                    result.getResult().getGeometry().getLocation().getLng()
                            );

                            weatherInfoCall.enqueue(new Callback<WeatherInfo>() {
                                @Override
                                public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response) {
                                    if (response.isSuccessful()){
                                        pojoWeatherInfo = response.body();

                                        descriptionTime = pojoWeatherInfo.getWeather().get(0).getDescription().toString();

                                        Log.d("El valor es:", descriptionTime);

                                        if (descriptionTime.equalsIgnoreCase("clear sky")){
                                            imageViewWeather.setImageResource(R.drawable.ic_clear_sky);
                                        }
                                        else if (descriptionTime.equalsIgnoreCase("mist")){
                                            imageViewWeather.setImageResource(R.drawable.ic_mist);
                                        }
                                        else if (descriptionTime.equalsIgnoreCase("few clouds")){
                                            imageViewWeather.setImageResource(R.drawable.ic_few_clouds);
                                        }
                                        else if (descriptionTime.equalsIgnoreCase("scattered clouds")){
                                            imageViewWeather.setImageResource(R.drawable.ic_scattered_clouds);
                                        }
                                        else if (descriptionTime.equalsIgnoreCase("broken clouds") || descriptionTime.contains("overcast")){
                                            imageViewWeather.setImageResource(R.drawable.ic_broken_clouds);
                                        }
                                        else if (descriptionTime.equalsIgnoreCase("shower rain") || descriptionTime.contains("drizzle")){
                                            imageViewWeather.setImageResource(R.drawable.ic_shower_rain);
                                        }
                                        else if (descriptionTime.equalsIgnoreCase("rain")){
                                            imageViewWeather.setImageResource(R.drawable.ic_rain);
                                        }
                                        else if (descriptionTime.equalsIgnoreCase("thunderstorm") || descriptionTime.contains("thunder")){
                                            imageViewWeather.setImageResource(R.drawable.ic_thunderstorm);
                                        }
                                        else if (descriptionTime.equalsIgnoreCase("snow") || descriptionTime.contains("snow")){
                                            imageViewWeather.setImageResource(R.drawable.ic_snow);
                                        }

                                        else{
                                            Picasso.with(getContext()).load("http://openweathermap.org/img/w/" + pojoWeatherInfo.getWeather().get(0).getIcon() + ".png").into(imageViewWeather);

                                        }

                                        Log.d("El valor es", descriptionTime);


                                        textCiudad.setText(pojoWeatherInfo.getName());
                                        textTemperatura.setText(Math.round(pojoWeatherInfo.getMain().getTemp()) + "");
                                        textHumedad.setText(Math.round(pojoWeatherInfo.getMain().getHumidity()) + "");
                                        textViento.setText(Math.round(pojoWeatherInfo.getWind().getSpeed()) + "");
                                        Log.i("RetrOK", pojoWeatherInfo.toString());
                                    }
                                }

                                @Override
                                public void onFailure(Call<WeatherInfo> call, Throwable t) {
                                    Log.e("RetrOFF", t.getMessage());
                                }
                            });
                        }

                    }

                    @Override
                    public void onFailure(Call<DetailsResult> call, Throwable t) {

                    }
                });
            }
        });

        return view;
    }
}
