package com.magaliani.keepgaliani;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.magaliani.keepgaliani.model.Nota;

import org.w3c.dom.Text;

import java.util.List;


public class MyNotaRecyclerViewAdapter extends RecyclerView.Adapter<MyNotaRecyclerViewAdapter.ViewHolder> {

    private Context ctx;
    private final List<Nota> mValues;
    private final INotasInteractionListener mListener;

    public MyNotaRecyclerViewAdapter(Context context, List<Nota> items, INotasInteractionListener listener) {
        ctx = context;
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_nota, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.textViewIdNota.setText(String.valueOf(holder.mItem.getId()));
        holder.textViewTitulo.setText(holder.mItem.getTitulo());
        holder.textViewDescripcion.setText(holder.mItem.getDescripcion());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onNotaClick(holder.mItem);
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

        public final TextView textViewIdNota;
        public final TextView textViewTitulo;
        public final TextView textViewDescripcion;

        public Nota mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;

            textViewIdNota = view.findViewById(R.id.textViewIdNota);
            textViewTitulo = view.findViewById(R.id.textViewTitulo);
            textViewDescripcion = view.findViewById(R.id.textViewDescripcion);

        }

       // @Override
        /*public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }*/
    }
}
