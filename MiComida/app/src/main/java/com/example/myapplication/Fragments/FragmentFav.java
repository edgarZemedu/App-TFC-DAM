package com.example.myapplication.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Adapter.ListaFragmentsAdapter;
import com.example.myapplication.Entidades.Producto;
import com.example.myapplication.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentFav#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentFav extends Fragment {

    RecyclerView rvDescubrir;
    ArrayList<Producto> listaProductosFav;

    public FragmentFav() {
        // Required empty public constructor
    }

    public static FragmentFav newInstance(String param1, String param2) {
        FragmentFav fragment = new FragmentFav();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_fav, container, false);

        listaProductosFav = new ArrayList<>();

        rvDescubrir = (RecyclerView) vista.findViewById(R.id.recyclerFav);
        rvDescubrir.setLayoutManager(new LinearLayoutManager(getContext()));

       for (int i=0; i < ListaFragmentsAdapter.llenarLista().size(); i++){
           if (ListaFragmentsAdapter.llenarLista().get(i).getFavorito()){
               listaProductosFav.add(ListaFragmentsAdapter.llenarLista().get(i));
               //getParentFragmentManager().beginTransaction().detach().attach(FragmentFav.this).commit();
           }
       }

        ListaFragmentsAdapter adapter = new ListaFragmentsAdapter(listaProductosFav);
        rvDescubrir.setAdapter(adapter);

        return vista;
    }
}