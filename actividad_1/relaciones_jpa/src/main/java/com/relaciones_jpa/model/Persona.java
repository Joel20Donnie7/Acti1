package com.relaciones_jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Getters and setters
    @Setter
    @Getter
    private String nombre;

    @Setter
    @Getter
    @OneToOne
    private Pasaporte pasaporte;

    @Getter
    @Setter
    @OneToMany(mappedBy = "persona")
    private List<Orden> ordenes;

    // Constructor accepting a String for name
    public Persona(String nombre) {
        this.nombre = nombre;
    }

}

