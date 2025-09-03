package com.example.Libreria.controller;

import com.example.Libreria.entity.Calificacion;
import com.example.Libreria.service.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {

    @Autowired
    private CalificacionService calificacionService;

    @PostMapping
    public Calificacion calificarLibro(@RequestParam Long libroId, @RequestParam Long usuarioId, @RequestParam int puntuacion) {
        return calificacionService.calificarLibro(libroId, usuarioId, puntuacion);
    }

    @GetMapping("/libro/{libroId}")
    public List<Calificacion> obtenerCalificacionesPorLibro(@PathVariable Long libroId) {
        return calificacionService.obtenerCalificacionesPorLibro(libroId);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Calificacion> obtenerCalificacionesPorUsuario(@PathVariable Long usuarioId) {
        return calificacionService.obtenerCalificacionesPorUsuario(usuarioId);
    }
}