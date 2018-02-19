package com.magaliani.proyetoclase14feb;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;




import java.util.List;

public class MyJugadorRecyclerViewAdapter extends RecyclerView.Adapter<MyJugadorRecyclerViewAdapter.ViewHolder> {

    private Context ctx;
    private final List<Jugador> mValues;

    public MyJugadorRecyclerViewAdapter(Context context, List<Jugador> items) {
        ctx = context;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_jugador, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);


        holder.textViewNombre.setText(holder.mItem.getNombre());
        holder.textViewDorsal.setText(holder.mItem.getDorsal());
        holder.textViewEdad.setText(holder.mItem.getEdad());

        Picasso.with(ctx)
                .load(holder.mItem.getFoto())
                .resize(100, 100)
                .into(holder.imageViewPhoto);


    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView imageViewPhoto;
        public final TextView textViewNombre;
        public final TextView textViewDorsal;
        public final TextView textViewEdad;

        public Jugador mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            imageViewPhoto = view.findViewById(R.id.imageView);
            textViewNombre = view.findViewById(R.id.textViewNombre);
            textViewDorsal = view.findViewById(R.id.textViewDorsal);
            textViewEdad = view.findViewById(R.id.textViewEdad);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewNombre.getText() + "'";
        }
    }
}
