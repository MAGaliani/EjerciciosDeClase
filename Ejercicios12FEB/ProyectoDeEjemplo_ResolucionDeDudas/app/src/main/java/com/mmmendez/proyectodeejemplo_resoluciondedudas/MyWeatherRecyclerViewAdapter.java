package com.mmmendez.proyectodeejemplo_resoluciondedudas;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by marta on 15/02/2018.
 */

public class MyWeatherRecyclerViewAdapter extends RecyclerView.Adapter<MyWeatherRecyclerViewAdapter.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
      /**  public final View mView;
        public final ImageView imageViewPhoto;
        public final TextView textViewName;
        public final TextView textViewAddress;
        public final RatingBar ratingBarRate;

        public Cats mItem;*/

        public ViewHolder(View view) {
            super(view);
           /* mView = view;
            imageViewPhoto = view.findViewById(R.id.imageViewPhoto);
            textViewName = view.findViewById(R.id.textViewName);
            textViewAddress = view.findViewById(R.id.textViewAddress);
            ratingBarRate = view.findViewById(R.id.ratingBarRate);*/
        }
    }
}
