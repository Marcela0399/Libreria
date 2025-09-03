package com.example.Libreria.service;

import com.example.Libreria.entity.Libro;
import com.example.Libreria.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    private LibroRepository libroRepository;

    public LibroService (LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> getAll(){
        return libroRepository.findAll();
    }

    public Optional <Libro> getLibroBy(Long id){
        return libroRepository.findById(id);
    }
    public Libro save(Libro libro){
        return libroRepository.save(libro);
    }

    public List<Libro> buscarPorTitulo(String titulo) {
        return libroRepository.findByTituloContainingIgnoreCase(titulo);
    }

    public List<Libro> buscarPorAutor(String autor) {
        return libroRepository.findByAutorContainingIgnoreCase(autor);
    }

    public List<Libro> buscarPorIsbn(String isbn) {
        return libroRepository.findByIsbnContainingIgnoreCase(isbn);
    }

    public List<Libro> buscarAvanzado(String titulo, String autor, String isbn) {
        if (titulo != null && autor != null && isbn != null) {
            return libroRepository.findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCaseOrIsbnContainingIgnoreCase(titulo, autor, isbn);
        } else if (titulo != null && autor != null) {
            return libroRepository.findByTituloContainingIgnoreCaseAndAutorContainingIgnoreCase(titulo, autor);
        } else if (titulo != null) {
            return libroRepository.findByTituloContainingIgnoreCase(titulo);
        } else if (autor != null) {
            return libroRepository.findByAutorContainingIgnoreCase(autor);
        } else if (isbn != null) {
            return libroRepository.findByIsbnContainingIgnoreCase(isbn);
        } else {
            return libroRepository.findAll();
        }
    }




}
