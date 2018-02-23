package com.magaliani.galoweather.APIs.GooglePlaces;

import com.magaliani.galoweather.models.GooglePlaces.details.DetailsResult;
import com.magaliani.galoweather.models.GooglePlaces.prediction.PredictionResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by magaliani on 23/02/18.
 */

public interface GooglePlacesApi {

    @GET("maps/api/place/autocomplete/json?type=(cities)&language=es")
    Call<PredictionResult> autoComplete(@Query("input") String text);

    @GET("maps/api/place/details/json")
    Call<DetailsResult> getPlaceDetails(@Query("place_id") String text);

}
