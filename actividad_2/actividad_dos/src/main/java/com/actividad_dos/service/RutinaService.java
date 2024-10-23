package com.actividad_dos.service;

import com.actividad_dos.model.Rutina;
import com.actividad_dos.repository.RutinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RutinaService {

    @Autowired
    private RutinaRepository rutinaRepository;

    public void saveRutina(Rutina rutina) {
        rutinaRepository.save(rutina);
    }
}