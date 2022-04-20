package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.myapplication.Entidades.InstruccionesInicio;
import com.example.myapplication.R;

import java.util.List;

public class InicioAdapter extends PagerAdapter {

    Context c;
    public List<InstruccionesInicio> listaComoFunciona;

    public InicioAdapter(List<InstruccionesInicio> listaComoFunciona, Context c) {
        this.listaComoFunciona = listaComoFunciona;
        this.c = c;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater lf = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = lf.inflate(R.layout.dialog_viewpager_items,container,false);

        TextView titulo = view.findViewById(R.id.titulo);
        TextView descripcion = view.findViewById(R.id.descripcionDialog);
        ImageView imagenConocenos = view.findViewById(R.id.imagenDialog);

        titulo.setText(listaComoFunciona.get(position).getTitulo());
        descripcion.setText(listaComoFunciona.get(position).getDescripcion());
        imagenConocenos.setImageResource(listaComoFunciona.get(position).getImagen());

        container.addView(view);

        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout)object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }

    @Override
    public int getCount() {
        return listaComoFunciona.size();
    }

}
