package com.actividad_4.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rutina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreRutina;

    @ManyToMany
    @JoinTable(
            name = "rutina_ejercicio",
            joinColumns = @JoinColumn(name = "rutina_id"),
            inverseJoinColumns = @JoinColumn(name = "ejercicio_id")
    )
    private List<Ejercicio> ejercicios = new ArrayList<>();

    // Constructor por defecto
    public Rutina() {
    }

    // Constructor con parámetros
    public Rutina(String nombreRutina) {
        this.nombreRutina = nombreRutina;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreRutina() {
        return nombreRutina;
    }

    public void setNombreRutina(String nombreRutina) {
        this.nombreRutina = nombreRutina;
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    @Override
    public String toString() {
        return "Rutina{" +
                "id=" + id +
                ", nombreRutina='" + nombreRutina + '\'' +
                '}';
    }
}
