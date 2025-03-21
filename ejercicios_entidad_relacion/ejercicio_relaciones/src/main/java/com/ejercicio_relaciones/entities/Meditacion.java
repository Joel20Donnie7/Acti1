package com.ejercicio_relaciones.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Meditacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMeditacion;
    private String nombre;
    private int duracion; // Duración en minutos
    private String descripcion;

    @ManyToMany(mappedBy = "meditaciones", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Rutina> rutinas = new HashSet<>();
}