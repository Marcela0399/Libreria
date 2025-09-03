package com.example.Libreria.repository;

import com.example.Libreria.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByTituloContainingIgnoreCase(String titulo);
    List<Libro> findByAutorContainingIgnoreCase(String autor);
    List<Libro> findByIsbnContainingIgnoreCase(String isbn);
    List<Libro> findByTituloContainingIgnoreCaseAndAutorContainingIgnoreCase(String titulo, String autor);
    List<Libro> findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCaseOrIsbnContainingIgnoreCase(String titulo, String autor, String isbn);


}