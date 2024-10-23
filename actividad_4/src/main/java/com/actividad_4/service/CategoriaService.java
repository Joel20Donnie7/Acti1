package com.actividad_4.service;

import com.actividad_4.model.Categoria;
import com.actividad_4.repository.CategoriaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PersistenceContext
    private EntityManager em;

    public void saveCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }
   //IMPLEMENTACIÓN DE CONSULTAS JPQL EN LOS SERVICIOS

    public List<com.actividad_4.model.Ejercicio> getEjerciciosByCategoriaNombre(String nombreCategoria) {
        TypedQuery<com.actividad_4.model.Ejercicio> query = em.createQuery(
                "SELECT e FROM Ejercicio e WHERE e.categoria.nombre = :nombreCategoria",
                com.actividad_4.model.Ejercicio.class
        );
        query.setParameter("nombreCategoria", nombreCategoria);
        return query.getResultList();
    }

    public List<String> getCategoriasConMasDeUnEjercicio() {
        TypedQuery<String> query = em.createQuery(
                "SELECT c.nombre FROM Categoria c JOIN c.ejercicios e GROUP BY c.nombre HAVING COUNT(e) > 1",
                String.class
        );
        return query.getResultList();
    }



}