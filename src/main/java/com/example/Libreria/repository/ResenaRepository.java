package com.example.Libreria.repository;

import com.example.Libreria.entity.Resena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResenaRepository extends JpaRepository<Resena, Long> {
    Optional<Resena> findByLibroId(Long libro_id);
}
