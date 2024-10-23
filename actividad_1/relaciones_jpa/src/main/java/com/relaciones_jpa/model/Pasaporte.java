package com.relaciones_jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Pasaporte {
    @Id
    private String numeroPasaporte;

    // Default constructor (needed by JPA)
    public Pasaporte() {}

    // Constructor accepting a String
    public Pasaporte(String numeroPasaporte) {
        this.numeroPasaporte = numeroPasaporte;
    }

    // Getters and setters
    public String getNumeroPasaporte() {
        return numeroPasaporte;
    }

    public void setNumeroPasaporte(String numeroPasaporte) {
        this.numeroPasaporte = numeroPasaporte;
    }
}