package com.magaliani.proyetoclase14feb;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class JugadorFragment extends Fragment {

    private int mColumnCount = 1;
    List<Jugador> jugadorList;
    MyJugadorRecyclerViewAdapter adapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public JugadorFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jugador_list, container, false);

        jugadorList = new ArrayList<>();
        jugadorList.add(new Jugador("Jesús Navas","16", "32", "http://files.laliga.es/jugadores/201708/250x250_09155703navas.jpg"));
        jugadorList.add(new Jugador("Luis Muriel","22", "26", "http://files.laliga.es/jugadores/201708/250x250_09155727muriel.jpg"));
        jugadorList.add(new Jugador("Éver Banega","10", "29", "http://files.laliga.es/jugadores/201708/250x250_09155002banega.jpg"));



        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            adapter = new MyJugadorRecyclerViewAdapter(getActivity(), jugadorList);
            recyclerView.setAdapter(adapter);
        }
        return view;
    }


}
