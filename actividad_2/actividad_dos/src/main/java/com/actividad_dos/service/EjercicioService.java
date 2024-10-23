package com.actividad_dos.service;

import com.actividad_dos.model.Ejercicio;
import com.actividad_dos.repository.EjercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EjercicioService {

    @Autowired
    private EjercicioRepository ejercicioRepository;

    public void saveEjercicio(Ejercicio ejercicio) {
        ejercicioRepository.save(ejercicio);
    }
}