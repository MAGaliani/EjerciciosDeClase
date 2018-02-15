package com.magaliani.ejercicio15feb;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class MyvueloRecyclerViewAdapter extends RecyclerView.Adapter<MyvueloRecyclerViewAdapter.ViewHolder> {

    private Context ctx;
    private final List<Vuelo> mValues;
    private IOnVueloInteractionListener mListener;


    public MyvueloRecyclerViewAdapter(Context context,
                                      List<Vuelo> items,
                                      IOnVueloInteractionListener listener) {
        ctx = context;
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_vuelo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);


        holder.textViewCompany.setText(holder.mItem.get);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView imageViewCompany;
        public final ImageView imageViewSalida;
        public final ImageView imageViewLlegada;
        public final TextView textViewCompany;
        public final TextView textViewSalida;
        public final TextView textViewLlegada;
        public final TextView textViewPrecio;

        public final TextView mIdView;
        public final TextView mContentView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            imageViewCompany = view.findViewById(R.id.imageViewCompany);
            imageViewSalida = view.findViewById(R.id.imageViewSalida);
            imageViewLlegada = view.findViewById(R.id.imageViewLlegada);
            textViewCompany = view.findViewById(R.id.textViewCompany);
            textViewSalida = view.findViewById(R.id.textViewSalida);
            textViewLlegada = view.findViewById(R.id.textViewLlegada);
            textViewPrecio = view.findViewById(R.id.textViewPrecio);

            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
