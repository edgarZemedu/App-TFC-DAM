package com.example.myapplication.Entidades;

public class Empresa {
    private String nombre;
    private String telefeno;
    private String correo;
    private String ubicacion;


    public Empresa(String nombre, String telefeno, String correo, String ubicacion) {
        this.nombre = nombre;
        this.telefeno = telefeno;
        this.correo = correo;
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefeno() {
        return telefeno;
    }

    public void setTelefeno(String telefeno) {
        this.telefeno = telefeno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
