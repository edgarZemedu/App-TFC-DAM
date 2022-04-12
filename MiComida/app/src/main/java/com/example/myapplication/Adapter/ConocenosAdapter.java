package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.Entidades.ComoFunciona;
import com.example.myapplication.Entidades.Producto;
import com.example.myapplication.R;

import java.util.Date;
import java.util.List;

public class ConocenosAdapter extends PagerAdapter {

    Context c;
    List<ComoFunciona> listaComoFunciona;

    public ConocenosAdapter(List<ComoFunciona> listaComoFunciona) {
        this.listaComoFunciona = listaComoFunciona;
    }

    @Override
    public int getCount() {
        return listaComoFunciona.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = View.inflate(c.getApplicationContext(), R.layout.conocenos,container);
        TextView titulo = view.findViewById(R.id.titulo);
        TextView descripcion = view.findViewById(R.id.descripcion);
        ImageView imagenConocenos = view.findViewById(R.id.imagenConocenos);

        view.setTag(position);
        ((ViewPager)container).addView(view);

        //llenarLista();

        titulo.setText(listaComoFunciona.get(position).getTitulo());
        descripcion.setText(listaComoFunciona.get(position).getDescripcion());
        imagenConocenos.setImageResource(listaComoFunciona.get(position).getImagen());

        return view;
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((View)object);
    }
}
