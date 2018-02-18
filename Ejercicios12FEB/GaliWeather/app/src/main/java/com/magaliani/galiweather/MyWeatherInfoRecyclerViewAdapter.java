package com.magaliani.galiweather;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.magaliani.galiweather.model.WeatherInfo;

import java.util.List;

public class MyWeatherInfoRecyclerViewAdapter extends RecyclerView.Adapter<MyWeatherInfoRecyclerViewAdapter.ViewHolder> {

    private Context ctx;
    private final List<WeatherInfo> mValues;

    public MyWeatherInfoRecyclerViewAdapter(Context context, List<WeatherInfo> items) {
        ctx = context;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.miItem = mValues.get(position);
        holder.nombreCiudad.setText(holder.miItem.getName());
        holder.temperatura.setText((int) holder.miItem.getMain().getTemp());
        holder.humedad.setText((int) holder.miItem.getMain().getHumidity());
        holder.viento.setText(holder.miItem.getWind().toString());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public TextView nombreCiudad;
        public TextView temperatura;
        public TextView humedad;
        public TextView viento;

        public WeatherInfo miItem;


        public ViewHolder(View view) {
            super(view);
            mView = view;

            nombreCiudad = view.findViewById(R.id.textViewCity);
            viento = view.findViewById(R.id.TextViewViento);
            temperatura = view.findViewById(R.id.textViewTemp);
            humedad = view.findViewById(R.id.textViewHumedad);
        }
    }
}
