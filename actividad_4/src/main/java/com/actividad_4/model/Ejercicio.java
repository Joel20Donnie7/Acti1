package com.actividad_4.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ejercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String tipo; // Ejercicio de Casa o Gimnasio

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToMany(mappedBy = "ejercicios")
    private List<Rutina> rutinas = new ArrayList<>();

    // Constructor por defecto
    public Ejercicio() {
    }

    // Constructor con parámetros
    public Ejercicio(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Ejercicio(String nombre, String tipo, Categoria categoria) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Rutina> getRutinas() {
        return rutinas;
    }

    public void setRutinas(List<Rutina> rutinas) {
        this.rutinas = rutinas;
    }

    @Override
    public String toString() {
        return "Ejercicio{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", categoria=" + (categoria != null ? categoria.getNombre() : "null") +
                '}';
    }
}
