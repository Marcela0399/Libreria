package com.example.Libreria.controller;

import com.example.Libreria.entity.Libro;
import com.example.Libreria.service.LibroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libros")
public class LibroController {
    private LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<Libro> getAll() {
        return libroService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Libro> getLibro(@PathVariable Long id) {
        return libroService.getLibroBy(id);
    }

    @PostMapping
    public Libro save(@RequestBody Libro libro) {
        return libroService.save(libro);
    }

    @GetMapping("/buscar/titulo")
    public List<Libro> buscarPorTitulo(@RequestParam String titulo) {
        return libroService.buscarPorTitulo(titulo);
    }

    @GetMapping("/buscar/autor")
    public List<Libro> buscarPorAutor(@RequestParam String autor) {
        return libroService.buscarPorAutor(autor);
    }

    @GetMapping("/buscar/isbn")
    public List<Libro> buscarPorIsbn(@RequestParam String isbn) {
        return libroService.buscarPorIsbn(isbn);
    }

    @GetMapping("/buscar-avanzado")
    public List<Libro> buscarAvanzado(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String autor,
            @RequestParam(required = false) String isbn) {
        return libroService.buscarAvanzado(titulo, autor, isbn);
    }


}
