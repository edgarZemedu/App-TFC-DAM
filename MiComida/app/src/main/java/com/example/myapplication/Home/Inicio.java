package com.example.myapplication.Home;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.Adapter.InicioAdapter;
import com.example.myapplication.Entidades.InstruccionesInicio;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Inicio extends AppCompatActivity {

    ViewPager vp;
    LinearLayout lyIndicador;
    Button bSaltar;
    TextView[] listaIdicadores;
    InicioAdapter iAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_instrucciones);

        bSaltar = findViewById(R.id.botonSaltarDialog);

        bSaltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });

        vp = (ViewPager) findViewById(R.id.vpagerIntroduccion);
        lyIndicador = (LinearLayout) findViewById(R.id.lyIndicador);

        List<InstruccionesInicio> listaComoFuncionas = new ArrayList<>();
        listaComoFuncionas.add(new InstruccionesInicio("Paso 1 ", "Publicas tu excedente de comida diario en la aplicación bajo coste en vez de tirar.", R.drawable.contruccion01));
        listaComoFuncionas.add(new InstruccionesInicio("Paso 2 ", "Nuevos clientes descubren tu tienda y compran tu excedente a través de la app.", R.drawable.clientes));
        listaComoFuncionas.add(new InstruccionesInicio("Paso 3 ", "Los clientes recogen los productos en tu local a la hora que tú prefieras.", R.drawable.localizar));
        listaComoFuncionas.add(new InstruccionesInicio("Paso 4 ", "Rentabilizas tu excedente, vendes más productos y consigues clientes recurrentes.", R.drawable.rentabilizas));

        iAdapter = new InicioAdapter(listaComoFuncionas, this);

        vp.setAdapter(iAdapter);

        añadirIndicador(0);
        vp.addOnPageChangeListener(viewListener);

    }

    public void añadirIndicador(int posicion){
        listaIdicadores = new TextView[4];
        lyIndicador.removeAllViews();

        for (int i=0; i < listaIdicadores.length; i++){
            listaIdicadores[i] = new TextView(this);
            listaIdicadores[i].setText(Html.fromHtml("&#8226;"));
            listaIdicadores[i].setTextSize(35);
            listaIdicadores[i].setTextColor(getResources().getColor(R.color.inactivo,getApplicationContext().getTheme()));

            lyIndicador.addView(listaIdicadores[i]);
        }
        listaIdicadores[posicion].setTextColor(getResources().getColor(R.color.activo,getApplicationContext().getTheme()));

    }

    private int tenerListaIdicador(int i){
        return vp.getCurrentItem() + 1;
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }
        @Override
        public void onPageSelected(int position) {

            añadirIndicador(position);
        }
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
