package com.example.myapplication.Entidades;

import java.io.Serializable;
import java.util.Date;

public class Producto implements Serializable {

    private String nombre,descripcion;
    private Date fechaLimite;
    private double precio;
    private int imagen;

    public Producto(String nombre,String descripcion, double precio, Date fechaLimite,  int imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaLimite = fechaLimite;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }



    public int getImagen() {
        return imagen;
    }

    public void setImagenID(int imagen) {
        this.imagen = imagen;
    }
}
