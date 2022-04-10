package com.example.myapplication.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myapplication.Adapter.ListaProductosAdapter;
import com.example.myapplication.Entidades.Producto;
import com.example.myapplication.Interfaz.InterfazFragments;
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

    public void llenarLista(){

        Date d = new Date("12/03/2022");
        listaProductos.add(new Producto("Patatas ","Patatas fritas al horno,una alternativa saludable.",5.25, d, R.drawable.patatas));
        listaProductos.add(new Producto("Bizcocho ","Bizcocho de yogur y nata. Hecho con ingredientes caseros.",20, d,R.drawable.bizcocho));
        listaProductos.add(new Producto("Gazpacho ","Gazpacho andalúz, sopa valiente con varios ingredientes con vinagrer.",50, d,R.drawable.gazpacho));
        listaProductos.add(new Producto("Gazpacho ","Gazpacho andalúz, sopa valiente con varios ingredientes con vinagrer. ",50, d, com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_light));
        listaProductos.add(new Producto("Gazpacho ","Gazpacho andalúz, sopa valiente con varios ingredientes con vinagrer.",50, d, com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_light));
        listaProductos.add(new Producto("Gazpacho ","Gazpacho andalúz, sopa valiente con varios ingredientes con vinagrer.",50, d, com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_light));
        listaProductos.add(new Producto("Gazpacho ","Gazpacho andalúz, sopa valiente con varios ingredientes con vinagrer.",50, d, com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_light));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_descubrir, container, false);
        listaProductos = new ArrayList<>();
        rvDescubrir = (RecyclerView) vista.findViewById(R.id.recyclerDescubrir);
        rvDescubrir.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarLista();

        ListaProductosAdapter adapter = new ListaProductosAdapter(listaProductos);
        rvDescubrir.setAdapter(adapter);


        /********************************/
//        botonFavoritos = vista.findViewById(R.id.buttonFavoritos);
//
//        botonFavoritos.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("productoFav",listaProductos.get(rvDescubrir.getChildAdapterPosition(vista)));
//                getParentFragmentManager().setFragmentResult("key",bundle);
//            }
//        });

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