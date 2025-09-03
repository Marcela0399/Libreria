package com.example.Libreria.service;

import com.example.Libreria.entity.Calificacion;
import com.example.Libreria.entity.Libro;
import com.example.Libreria.entity.Usuario;
import com.example.Libreria.repository.CalificacionRepository;
import com.example.Libreria.repository.LibroRepository;
import com.example.Libreria.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalificacionService {

    private final CalificacionRepository calificacionRepository;
    private final LibroRepository libroRepository;
    private final UsuarioRepository usuarioRepository;

    public CalificacionService(CalificacionRepository calificacionRepository, LibroRepository libroRepository, UsuarioRepository usuarioRepository) {
        this.calificacionRepository = calificacionRepository;
        this.libroRepository = libroRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Calificacion calificarLibro(Long libroId, Long usuarioId, int puntuacion) {
        if (puntuacion < 1 || puntuacion > 5) {
            throw new IllegalArgumentException("La puntuación debe estar entre 1 y 5.");
        }
        Libro libro = libroRepository.findById(libroId).orElseThrow();
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow();
        Calificacion calificacion = new Calificacion(libro, usuario, puntuacion);
        return calificacionRepository.save(calificacion);
    }

    public List<Calificacion> obtenerCalificacionesPorLibro(Long libroId) {
        return calificacionRepository.findByLibroId(libroId);
    }

    public List<Calificacion> obtenerCalificacionesPorUsuario(Long usuarioId) {
        return calificacionRepository.findByUsuarioId(usuarioId);
    }
}