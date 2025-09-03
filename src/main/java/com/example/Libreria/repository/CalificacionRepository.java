package com.example.Libreria.repository;

import com.example.Libreria.entity.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CalificacionRepository extends JpaRepository<Calificacion, Long> {
    List<Calificacion> findByLibroId(Long libroId);
    List<Calificacion> findByUsuarioId(Long usuarioId);
}