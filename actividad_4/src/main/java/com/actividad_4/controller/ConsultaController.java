package com.actividad_4.controller;

import com.actividad_4.model.Ejercicio;
import com.actividad_4.model.Rutina;
import com.actividad_4.service.CategoriaService;
import com.actividad_4.service.EjercicioService;
import com.actividad_4.service.RutinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsultaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private EjercicioService ejercicioService;

    @Autowired
    private RutinaService rutinaService;

    // Consulta 1: Obtener todos los ejercicios de una categoría específica
    @GetMapping("/ejercicios/por-categoria")
    public List<Ejercicio> getEjerciciosByCategoriaNombre(@RequestParam String nombreCategoria) {
        return categoriaService.getEjerciciosByCategoriaNombre(nombreCategoria);
    }

    // Consulta 2: Obtener todas las rutinas que contienen un ejercicio específico
    @GetMapping("/rutinas/por-ejercicio")
    public List<Rutina> getRutinasByEjercicioNombre(@RequestParam String nombreEjercicio) {
        return rutinaService.getRutinasByEjercicioNombre(nombreEjercicio);
    }

    // Consulta 3: Obtener los nombres de las categorías que tienen más de un ejercicio asociado
    @GetMapping("/categorias/con-multiples-ejercicios")
    public List<String> getCategoriasConMasDeUnEjercicio() {
        return categoriaService.getCategoriasConMasDeUnEjercicio();
    }

    // Consulta 4: Obtener los ejercicios que pertenecen a categorías cuyo nombre empieza con una letra específica
    @GetMapping("/ejercicios/por-categoria-pattern")
    public List<Ejercicio> getEjerciciosByCategoriaNombrePattern(@RequestParam String nombreCategoriaPattern) {
        return ejercicioService.getEjerciciosByCategoriaNombrePattern(nombreCategoriaPattern);
    }

    // Consulta 5: Obtener las rutinas que contienen ejercicios de un tipo específico (Casa o Gimnasio)
    @GetMapping("/rutinas/por-ejercicio-tipo")
    public List<Rutina> getRutinasByEjercicioTipo(@RequestParam String tipoEjercicio) {
        return rutinaService.getRutinasByEjercicioTipo(tipoEjercicio);
    }
}