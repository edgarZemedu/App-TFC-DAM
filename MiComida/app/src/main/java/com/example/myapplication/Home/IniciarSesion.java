package com.example.myapplication.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class IniciarSesion extends AppCompatActivity {

    ChipGroup chipG;
    RelativeLayout relativeL;
    CheckBox checkBox;
    Button registrarme, iniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciarsesion);

        chipG = findViewById(R.id.chipGroup);
        relativeL = findViewById(R.id.relativeLayout);
        registrarme = findViewById(R.id.registrarme);
        checkBox = findViewById(R.id.checkBox);
        iniciar = findViewById(R.id.iniciar);

        chipG.setOnCheckedChangeListener((group, checkedId) -> {
            Chip c1 = findViewById(R.id.chipSi);
            Chip c2 = findViewById(R.id.chipNo);

            if(c1.isChecked()){
                relativeL.setVisibility(View.VISIBLE);
                iniciar.setVisibility(View.GONE);

                EditText name = findViewById(R.id.editTextTextPersonName);
                EditText phone = findViewById(R.id.editTextPhone);
                EditText email = findViewById(R.id.editTextTextEmailAddress);
                EditText ciudad = findViewById(R.id.editTextTextPersonName2);


                registrarme.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            boolean campos = false;

                            if (!name.getText().toString().matches("") && !phone.getText().toString().matches("")
                                && !email.getText().toString().matches("") && !ciudad.getText().toString().matches("")) {

                                checkBox.setOnClickListener(view1 -> {
                                    });

                                if(checkBox.isChecked()){
                                    campos = true;/*
                                    Empresa e = new Empresa();
                                    e.setNombre(name);
                                    e.setTelefeno(phone);
                                    e.setCorreo(email);
                                    e.setUbicacion(ciudad);
                                    //prueba de que guarda bien
                                    Toast.makeText(getApplicationContext(), e.getNombre(), Toast.LENGTH_SHORT).show();*/

                                }

                            } else {
                                Toast.makeText(getApplicationContext(), "Complete los campos que estan vacios", Toast.LENGTH_SHORT).show();
                            }

                            if (campos) {
                                startActivity(new Intent(getApplicationContext(), AccionesFragments.class));
                            }
                        }
                    });

            }else{
                relativeL.setVisibility(View.GONE);
                iniciar.setVisibility(View.VISIBLE);
                if (c2.isChecked()) {
                    iniciar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(getApplicationContext(), AccionesFragments.class));
                        }
                    });
                }
            }
        });

    }

}