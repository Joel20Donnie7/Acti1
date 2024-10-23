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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Rutina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRutina;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario; // Relación con la entidad Usuario

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "rutina_ejercicio",
            joinColumns = @JoinColumn(name = "idRutina"),
            inverseJoinColumns = @JoinColumn(name = "idEjercicio")
    )
    private Set<Ejercicio> ejercicios = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "rutina_meditacion",
            joinColumns = @JoinColumn(name = "idRutina"),
            inverseJoinColumns = @JoinColumn(name = "idMeditacion")
    )
    private Set<Meditacion> meditaciones = new HashSet<>();
}