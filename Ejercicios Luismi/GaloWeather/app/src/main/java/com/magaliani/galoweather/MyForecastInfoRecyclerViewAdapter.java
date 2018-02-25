package com.magaliani.galoweather;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.magaliani.galoweather.models.Forecast.WeatherList;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyForecastInfoRecyclerViewAdapter extends RecyclerView.Adapter<MyForecastInfoRecyclerViewAdapter.ViewHolder> {

    Context context;
    private final List<WeatherList> mValues;


    public MyForecastInfoRecyclerViewAdapter(Context context, List<WeatherList> items) {
        this.context = context;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_forecastinfo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.weatherListItem = mValues.get(position);

        holder.textViewTempMaxFor.setText(Math.round(holder.weatherListItem.getMain().getTempMax()) + "");
        holder.textViewTempMinFor.setText(Math.round(holder.weatherListItem.getMain().getTempMin()) + "");
        Picasso
                .with(context)
                .load("http://openweathermap.org/img/w/" + holder.weatherListItem
                .getWeather().get(0).getIcon() + ".png")
                .fit()
                .into(holder.imageViewWeatherFor);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        //public final TextView textViewDia;
        public final TextView textViewTempMaxFor;
        public final TextView textViewTempMinFor;
        public final ImageView imageViewWeatherFor;
        public WeatherList weatherListItem;


        public ViewHolder(View view) {
            super(view);
            mView = view;

            //textViewDia = view.findViewById(R.id.textViewDia);
            textViewTempMaxFor = view.findViewById(R.id.textViewTempMaxFor);
            textViewTempMinFor = view.findViewById(R.id.textViewTempMinFor);
            imageViewWeatherFor = view.findViewById(R.id.imageViewWeatherFor);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewTempMaxFor.getText() + "'";
        }
    }
}
