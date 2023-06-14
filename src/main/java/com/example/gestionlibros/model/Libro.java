package com.example.gestionlibros.model;

public class Libro {
    private int id_libro;
    private String nombre,editorial,categoria;
    private int año;
    private String tipo_libro;

    public Libro(int id_libro, String nombre, String editorial, String categoria, int año, String tipo_libro) {
        this.id_libro = id_libro;
        this.nombre = nombre;
        this.editorial = editorial;
        this.categoria = categoria;
        this.año = año;
        this.tipo_libro = tipo_libro;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getTipo_libro() {
        return tipo_libro;
    }

    public void setTipo_libro(String tipo_libro) {
        this.tipo_libro = tipo_libro;
    }

    @Override
    public String toString() {
        return "Libro: ID= "+this.id_libro+", Nombre= "+this.nombre+", Editorial= "+this.editorial
                +", Categoria(s)= "+this.categoria+", Año= "+this.año+", Tipo= "+this.tipo_libro;
    }
}
