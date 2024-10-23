package com.ejercicio_relaciones.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ejercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEjercicio;
    private String nombre;
    private String tipo; // Casa, Gimnasio
    private String dificultad; // Bajo, Medio, Alto
    private String descripcion;

    @ManyToMany(mappedBy = "ejercicios", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Rutina> rutinas = new HashSet<>();
}