package com.ejercicio_relaciones.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ConsejoSalud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConsejo;
    private String titulo;
    private String descripcion;
}