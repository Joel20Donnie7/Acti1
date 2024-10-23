package com.actividad_4.service;

import com.actividad_4.model.Ejercicio;
import com.actividad_4.repository.EjercicioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EjercicioService {

    @Autowired
    private EjercicioRepository ejercicioRepository;

    @PersistenceContext
    private EntityManager em;

    public void saveEjercicio(Ejercicio ejercicio) {
        ejercicioRepository.save(ejercicio);
    }

    public List<Ejercicio> getEjerciciosByCategoriaNombrePattern(String nombreCategoriaPattern) {
        TypedQuery<Ejercicio> query = em.createQuery(
                "SELECT e FROM Ejercicio e WHERE e.categoria.nombre LIKE :nombreCategoria",
                Ejercicio.class
        );
        query.setParameter("nombreCategoria", nombreCategoriaPattern);
        return query.getResultList();
    }
}