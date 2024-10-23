package com.ejercicio_relaciones.pruebas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ejercicio_relaciones.entities.Usuario;
import com.ejercicio_relaciones.repositories.UsuarioRepository;

import java.time.LocalDate; // Asegúrate de que este import esté presente

@Component
public class PruebaUsuario implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {
        // Crear un nuevo usuario
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan Pérez");
        usuario.setCorreo("juan.perez@example.com");
        usuario.setFechaRegistro(LocalDate.now());

        // Guardar el usuario
        usuarioRepository.save(usuario);

        // Listar todos los usuarios
        System.out.println("Lista de usuarios:");
        for (Usuario u : usuarioRepository.findAll()) {
            System.out.println("Usuario: " + u.getNombre() + ", Correo: " + u.getCorreo());
        }
    }
}
