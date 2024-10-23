package com.actividad_dos.service;

import com.actividad_dos.model.Categoria;
import com.actividad_dos.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public void saveCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }
}