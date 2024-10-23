package com.actividad_4.service;

import com.actividad_4.model.Rutina;
import com.actividad_4.repository.RutinaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutinaService {

    @Autowired
    private RutinaRepository rutinaRepository;

    @PersistenceContext
    private EntityManager em;

    public void saveRutina(Rutina rutina) {
        rutinaRepository.save(rutina);
    }

    public List<Rutina> getRutinasByEjercicioNombre(String nombreEjercicio) {
        TypedQuery<Rutina> query = em.createQuery(
                "SELECT r FROM Rutina r JOIN r.ejercicios e WHERE e.nombre = :nombreEjercicio",
                Rutina.class
        );
        query.setParameter("nombreEjercicio", nombreEjercicio);
        return query.getResultList();
    }

    public List<Rutina> getRutinasByEjercicioTipo(String tipoEjercicio) {
        TypedQuery<Rutina> query = em.createQuery(
                "SELECT DISTINCT r FROM Rutina r JOIN r.ejercicios e WHERE e.tipo = :tipoEjercicio",
                Rutina.class
        );
        query.setParameter("tipoEjercicio", tipoEjercicio);
        return query.getResultList();
    }
}