package com.example.myapplication.Adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Entidades.Producto;
import com.example.myapplication.Fragments.FragmentDescubrir;
import com.example.myapplication.Fragments.FragmentFav;
import com.example.myapplication.Fragments.FragmentPerfil;
import com.example.myapplication.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListaFragmentsAdapter extends RecyclerView.Adapter<ListaFragmentsAdapter.MyViewHolder>  {

    Context c;
    ArrayList<Producto> listaProductos;
    Dialog miDialogo;
    Button botonFavoritos;

    public ListaFragmentsAdapter(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public static ArrayList<Producto> llenarLista(){

        ArrayList<Producto> listaProductos = new ArrayList<>();
        Date d = new Date("12/03/2022");
        listaProductos.add(new Producto("Patatas ","Patatas fritas al horno,una alternativa saludable.",5.25, d, R.drawable.patatas,false));
        listaProductos.add(new Producto("Bizcocho ","Bizcocho de yogur y nata. Hecho con ingredientes caseros.",20, d,R.drawable.bizcocho,false));
        listaProductos.add(new Producto("Gazpacho ","Gazpacho andalúz, sopa valiente con varios ingredientes con vinagrer.",50, d,R.drawable.gazpacho,false));
        listaProductos.add(new Producto("Gazpacho ","Gazpacho andalúz, sopa valiente con varios ingredientes con vinagrer. ",50, d, com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_light,true));
        listaProductos.add(new Producto("Gazpacho ","Gazpacho andalúz, sopa valiente con varios ingredientes con vinagrer.",50, d, com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_light,false));
        listaProductos.add(new Producto("Gazpacho ","Gazpacho andalúz, sopa valiente con varios ingredientes con vinagrer.",50, d, com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_light,false));
        listaProductos.add(new Producto("Gazpacho ","Gazpacho andalúz, sopa valiente con varios ingredientes con vinagrer.",50, d, com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_light,false));

        return listaProductos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        listaProductos.addAll(llenarLista());
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_productos,null,false);

        MyViewHolder miViewHolder = new MyViewHolder(v);

        miDialogo = new Dialog(parent.getContext());
        miDialogo.setContentView(R.layout.dialog_producto);


        miViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //TextView nombreEmpresa = miDialogo.findViewById(R.id.nombreEmpresa);
            //TextView fechaLimite = miDialogo.findViewById(R.id.fechaLimite);
            ImageView imagenProducto = miDialogo.findViewById(R.id.imagenProducto);

            //nombreEmpresa.setText(listaEmpresas.get(miViewHolder.getAdapterPosition()).getNombre());
            //fechaLimite.setText(listaEmpresas.get(miViewHolder.getAdapterPosition()).getFechaLimite());
            imagenProducto.setImageResource(listaProductos.get(miViewHolder.getAdapterPosition()).getImagen());

            botonFavoritos = miDialogo.findViewById(R.id.buttonFavoritos);
            botonFavoritos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!listaProductos.get(miViewHolder.getAdapterPosition()).getFavorito()){
                        listaProductos.get(miViewHolder.getAdapterPosition()).setFavorito(true);

                        listaProductos.addAll(llenarLista());

                        Toast.makeText(parent.getContext(),""+listaProductos.get(miViewHolder.getAdapterPosition()).getFavorito(),Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(parent.getContext(),"ya está añadido a favoritos",Toast.LENGTH_SHORT).show();
                    }
                }
            });
            miDialogo.show();

            }
        });

        return miViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nombre.setText(listaProductos.get(position).getNombre());
        holder.descripcion.setText(listaProductos.get(position).getDescripcion());
        holder.precio.setText(String.valueOf(listaProductos.get(position).getPrecio()));
        holder.imagen.setImageResource(listaProductos.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre,descripcion,precio;
        private ImageView imagen;
        private LinearLayout lista_productos;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.tvNombre);
            descripcion = itemView.findViewById(R.id.descripcion);
            precio = itemView.findViewById(R.id.precio);
            imagen = itemView.findViewById(R.id.imagenView);
            lista_productos = itemView.findViewById(R.id.lista_productos_id);
        }
    }

}