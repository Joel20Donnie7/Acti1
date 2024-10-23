package com.relaciones_jpa.repository;

import com.relaciones_jpa.model.Pasaporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasaporteRepository extends JpaRepository<Pasaporte, Long> {
}
