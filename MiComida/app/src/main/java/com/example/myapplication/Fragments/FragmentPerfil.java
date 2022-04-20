package com.example.myapplication.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.myapplication.Adapter.ListaFragmentsAdapter;
import com.example.myapplication.Home.Inicio;
import com.example.myapplication.Home.IniciarSesion;
import com.example.myapplication.Home.MainActivity;
import com.example.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentPerfil#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentPerfil extends Fragment {

    LinearLayout cuentaL,conocenosL,ayudaL,terminosL,unirmeL;
    Dialog miDialogo;
    Context c;ViewPager2 pager;

    public FragmentPerfil() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_perfil, container, false);

        cuentaL = vista.findViewById(R.id.cuentaL);
        conocenosL = vista.findViewById(R.id.conocenosL);
        ayudaL = vista.findViewById(R.id.ayudaL);
        terminosL = vista.findViewById(R.id.terminosL);
        unirmeL = vista.findViewById(R.id.unirmeL);

        cuentaL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.app.AlertDialog.Builder alertaCuenta = new AlertDialog.Builder(getContext());
                alertaCuenta.setMessage("No existe ninguna cuenta")
                            .setCancelable(true);
                AlertDialog color = alertaCuenta.create();
                color.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialogInterface) {
                        color.getWindow().setBackgroundDrawableResource(R.color.colorFondo);
                    }
                });
                color.show();
            }
        });

        conocenosL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ad = new AlertDialog.Builder(getContext());
                ad.setView(inflater.inflate(R.layout.dialog_conocenos,null));
                ad.show();
            }
        });
        ayudaL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CharSequence[] listaAyuda = {"Como funciona?", "Quiero unirme","Más sobre TooGooToGo", "No has encontrado lo que buscabas"};
                AlertDialog.Builder alertaCuenta = new AlertDialog.Builder(getContext(),AlertDialog.THEME_DEVICE_DEFAULT_DARK);
                alertaCuenta.setTitle("CON QUE TE AYUDAMOS?")
                        .setIcon(R.drawable.help_24)
                        .setSingleChoiceItems(listaAyuda,-1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                switch (i){
                                    case 0:
                                        startActivity(new Intent(getContext(), Inicio.class));
                                        break;
                                    case 1:
                                        startActivity(new Intent(getContext(), IniciarSesion.class));
                                        break;
                                    case 2:
                                        AlertDialog.Builder alertd = new AlertDialog.Builder(getContext());
                                        alertd.setView(inflater.inflate(R.layout.dialog_conocenos,null));
                                        alertd.show();
                                        break;
                                    case 3:
                                        startActivity(new Intent(getContext(), ListaFragmentsAdapter.class));
                                        Toast.makeText(getContext(),"Dale a refrescar",Toast.LENGTH_LONG).show();
                                        break;
                                    default:
                                        dialogInterface.cancel();
                                        break;
                                }
                            }
                        });
                AlertDialog color = alertaCuenta.create();
                color.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialogInterface) {
                        color.getWindow().setBackgroundDrawableResource(R.color.colorFondo);
                        color.getButton(AlertDialog.BUTTON_NEUTRAL).setTextColor(getResources().getColor(R.color.grey));
                    }
                });
                color.show();
            }
        });
        terminosL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertaCuenta = new AlertDialog.Builder(getContext(),AlertDialog.THEME_DEVICE_DEFAULT_DARK);
                alertaCuenta.setMessage(R.string.terminosCondiciones)
                        .setCancelable(false)
                        .setPositiveButton("Acepto",(dialogInterface, i) -> {
                                dialogInterface.cancel();
                            });
                        alertaCuenta.setNegativeButton("No acepto", (dialogInterface, i) -> {
                            startActivity(new Intent(getContext(), MainActivity.class));
                            Toast.makeText(getContext(),"SINO ESTAS DE ACUERDO CON NUESTROS TÉRMINOS YCONDICIONES, NO ERES BIEN VENIDO AQUÍ",Toast.LENGTH_LONG).show();
                        });

                AlertDialog color = alertaCuenta.create();
                color.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialogInterface) {
                        color.getWindow().setBackgroundDrawableResource(R.color.colorFondo);
                        color.getWindow().setGravity(Gravity.CENTER);
                    }
                });
                color.show();
                Toast.makeText(getContext(),"Términos ",Toast.LENGTH_SHORT).show();
            }
        });
        unirmeL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), IniciarSesion.class));
            }
        });

        return vista;
    }
}