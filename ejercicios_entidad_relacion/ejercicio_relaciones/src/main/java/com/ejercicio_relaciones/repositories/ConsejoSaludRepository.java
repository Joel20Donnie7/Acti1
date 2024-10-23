package com.ejercicio_relaciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ejercicio_relaciones.entities.ConsejoSalud;

@Repository
public interface ConsejoSaludRepository extends JpaRepository<ConsejoSalud, Long> {
}