package com.ejercicio_relaciones.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Progreso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProgreso;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario; // Relación con la entidad Usuario

    @ManyToOne
    @JoinColumn(name = "idPlanAlimentacion")
    private PlanAlimentacion planAlimentacion; // Relación con la entidad PlanAlimentacion

    private double pesoActual;
    private java.util.Date fechaProgreso;
}