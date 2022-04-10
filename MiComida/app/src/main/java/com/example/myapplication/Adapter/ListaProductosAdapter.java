package com.example.myapplication.Adapter;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Entidades.Empresa;
import com.example.myapplication.Entidades.Producto;
import com.example.myapplication.Interfaz.InterfazFragments;
import com.example.myapplication.R;

import java.util.ArrayList;

public class ListaProductosAdapter extends RecyclerView.Adapter<ListaProductosAdapter.MyViewHolder>  {

    ArrayList<Producto> listaProductos;
    Dialog miDialogo;
    Button botonFavoritos;

    public ListaProductosAdapter(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
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

            Toast.makeText(parent.getContext(), "Has pulsado " + listaProductos.get(miViewHolder.getAdapterPosition()).getNombre(), Toast.LENGTH_SHORT).show();
            miDialogo.show();

//                botonFavoritos = v.findViewById(R.id.buttonFavoritos);
//
//                botonFavoritos.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        enviarProducto(listaProductos.get(miViewHolder.getAdapterPosition()));
//                    }
//                });
            }
        });

        return miViewHolder;
    }

   /* @Override
    public void enviarProducto(Producto producto) {

        Bundle bundle = new Bundle();
        bundle.putSerializable("productoFav",producto);

        getParentFragmentManager().setFragmentResult("key",bundle);
    }*/

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
