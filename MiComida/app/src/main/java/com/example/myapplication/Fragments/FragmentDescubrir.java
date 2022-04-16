package com.example.myapplication.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
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
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentDescubrir#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentDescubrir extends Fragment {

    RecyclerView rvDescubrir;
    ArrayList<Producto> listaProductos;
    //Button botonFavoritos;

    public FragmentDescubrir() {
    }

    // TODO: Rename and change types and number of parameters
    public static FragmentDescubrir newInstance(String param1, String param2) {
        FragmentDescubrir fragment = new FragmentDescubrir();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_descubrir, container, false);
        listaProductos = new ArrayList<>();
        rvDescubrir = (RecyclerView) vista.findViewById(R.id.recyclerDescubrir);
        rvDescubrir.setLayoutManager(new LinearLayoutManager(getContext()));

        listaProductos.addAll(ListaFragmentsAdapter.llenarLista());

        ListaFragmentsAdapter adapter = new ListaFragmentsAdapter(listaProductos);
        rvDescubrir.setAdapter(adapter);
        return vista;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
//        if (context instanceof Activity){
//            activ = (Activity) context;
//            interfaz = (InterfazFragments) activ;
//        }

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }
}