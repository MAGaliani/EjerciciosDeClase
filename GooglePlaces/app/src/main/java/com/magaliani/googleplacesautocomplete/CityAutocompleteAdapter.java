package com.magaliani.googleplacesautocomplete;

import android.content.Context;
import android.gesture.Prediction;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by magaliani on 20/02/18.
 */

public class CityAutocompleteAdapter extends BaseAdapter implements Filterable {

    private static final int MAX_RESULTS = 10;
    private Context ctx;
    private List<Prediction> resultList = new ArrayList<Prediction>();

    @Override
    public int getCount() {
        return resultList.size();
    }

    @Override
    public Object getItem(int position) {
        return resultList.get(i);
    }

    @Override
    public long getItemId(int position) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (view = null){
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(android.R.layout.simple_dropdown_item_1line, viewGroup, );
        }

        TextView text = convertView.findViewById((android.R.id.text1));
        Prediction p = getItem(i);
        text.setText(p.getDescription());
        return null;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }

    @Override
    public Filter getFilter() {
        return null;
    }
}
