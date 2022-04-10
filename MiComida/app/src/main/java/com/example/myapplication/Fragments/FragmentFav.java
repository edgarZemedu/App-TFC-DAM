package com.example.myapplication.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Adapter.ListaProductosAdapter;
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
    ArrayList<Producto> listaProductos;

    public FragmentFav() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentFav.
     */

    // TODO: Rename and change types and number of parameters
    public static FragmentFav newInstance(String param1, String param2) {
        FragmentFav fragment = new FragmentFav();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getParentFragmentManager().setFragmentResultListener("key", this, new FragmentResultListener() {
//            @Override
//            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
//                listaProductos.add(result.getParcelable("productoFav"));
//            }
//        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_fav, container, false);
        listaProductos = new ArrayList<>();
        rvDescubrir = (RecyclerView) vista.findViewById(R.id.recyclerFav);
        rvDescubrir.setLayoutManager(new LinearLayoutManager(getContext()));

       // llenarLista();

        ListaProductosAdapter adapter = new ListaProductosAdapter(listaProductos);
        rvDescubrir.setAdapter(adapter);

        return vista;
    }
}