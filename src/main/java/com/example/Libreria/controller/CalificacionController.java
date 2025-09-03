package com.example.Libreria.controller;

import com.example.Libreria.entity.Calificacion;
import com.example.Libreria.entity.Libro;
import com.example.Libreria.entity.Usuario;
import com.example.Libreria.repository.CalificacionRepository;
import com.example.Libreria.repository.LibroRepository;
import com.example.Libreria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {

    @Autowired
    private CalificacionRepository calificacionRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public Calificacion calificarLibro(@RequestParam Long libroId, @RequestParam Long usuarioId, @RequestParam int puntuacion) {
        if (puntuacion < 1 || puntuacion > 5) {
            throw new IllegalArgumentException("La puntuación debe estar entre 1 y 5.");
        }
        Libro libro = libroRepository.findById(libroId).orElseThrow();
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow();
        Calificacion calificacion = new Calificacion(libro, usuario, puntuacion);
        return calificacionRepository.save(calificacion);
}
    @GetMapping("/libro/{libroId}")
    public List<Calificacion> obtenerCalificacionesPorLibro(@PathVariable Long libroId) {
        return calificacionRepository.findByLibroId(libroId);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Calificacion> obtenerCalificacionesPorUsuario(@PathVariable Long usuarioId) {
        return calificacionRepository.findByUsuarioId(usuarioId);
    }
}