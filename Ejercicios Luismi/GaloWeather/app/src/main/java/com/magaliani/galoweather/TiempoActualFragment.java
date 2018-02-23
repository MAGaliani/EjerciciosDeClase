package com.magaliani.galoweather;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class TiempoActualFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "wind";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private long wind;


    public TiempoActualFragment() {
        // Required empty public constructor
    }
    public static TiempoActualFragment newInstance(String param1, String param2, String param3 ) {
        TiempoActualFragment fragment = new TiempoActualFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tiempo_actual, container, false);

        textCiudad = v.findViewById(R.id.textViewCity);
        textHumedad = v.findViewById(R.id.textViewHumedad);
        textViento = v.findViewById(R.id.TextViewViento);

        return v;
    }




}
