package com.ejercicio_relaciones.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PlanAlimentacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlanAlimentacion;
    private String nombre;
    private String descripcion;
    private String objetivo; // Pérdida de peso, Ganancia músculo

    @OneToMany(mappedBy = "planAlimentacion", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Progreso> progresos = new HashSet<>();
}
