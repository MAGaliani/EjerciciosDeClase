package com.magaliani.galoweather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.magaliani.galoweather.APIs.GooglePlaces.GooglePlacesApi;
import com.magaliani.galoweather.models.GooglePlaces.prediction.Prediction;
import com.magaliani.galoweather.models.GooglePlaces.prediction.PredictionResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by magaliani on 23/02/18.
 */

public class GooglePlacesResultAdapter extends BaseAdapter implements Filterable{
    private Context mContext;
    private List<Prediction> resultList = new ArrayList<Prediction>();

    public GooglePlacesResultAdapter(Context _context){
        this.mContext = _context;
    }

    @Override
    public int getCount() {
        return resultList.size();
    }

    @Override
    public Prediction getItem(int position) {
        return resultList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null){
            LayoutInflater inflater =
                    (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(android.R.layout.simple_dropdown_item_1line, viewGroup, false);

        }

        TextView text = view.findViewById(android.R.id.text1);
        Prediction p = getItem(position);
        text.setText(p.getDescription());

        return view;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = new FilterResults();
                if (charSequence != null){
                    List<Prediction> resultados = findCities(charSequence);
                    if (resultados != null){
                        filterResults.values = resultados;
                        filterResults.values = resultados.size();
                    }
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                if (filterResults != null && filterResults.count > 0) {
                    resultList = (List<Prediction>) filterResults.values;
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }
            }
        };
    }

    private List<Prediction> findCities(CharSequence text) {
        List<Prediction> result = null;

        //Generar el servicio
        GooglePlacesApi api = ServiceGeneratorGooglePlaces.createService(GooglePlacesApi.class);
        //Obtener la petcición
        Call<PredictionResult> call = api.autoComplete(text.toString());

        //call.enqueue();
        try {
            Response<PredictionResult> response = call.execute();

            if (response.isSuccessful()) {
                if ("OK".equalsIgnoreCase(response.body().getStatus()))
                    result = response.body().getPredictions();
            }

            //TODO Manejo de errores

        } catch (IOException e) {
            //TODO Manejo de la excepción
            e.printStackTrace();
        }


        return result;
    }
}
