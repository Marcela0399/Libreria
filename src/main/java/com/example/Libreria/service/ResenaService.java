package com.example.Libreria.service;

import com.example.Libreria.entity.Libro;
import com.example.Libreria.entity.Resena;
import com.example.Libreria.entity.Usuario;
import com.example.Libreria.repository.LibroRepository;
import com.example.Libreria.repository.ResenaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResenaService {
    private LibroRepository libroRepository;
    private UsuarioService usuarioService;
    private ResenaRepository resenaRepository;

    public ResenaService(LibroRepository libroRepository, UsuarioService usuarioService, ResenaRepository resenaRepository) {
        this.libroRepository = libroRepository;
        this.usuarioService = usuarioService;
        this.resenaRepository = resenaRepository;
    }

    public List<Resena> obtenerResenas(Long libro_id) {
        return resenaRepository.findByLibroId(libro_id);
    }

    @Transactional
    public void saveResena(Long libroId, Long usuarioId, String text_resena) {
        Optional<Libro> libro = libroRepository.findById(libroId);
        Optional<Usuario> usuario = usuarioService.getUsuarioById(usuarioId);
        Resena resena = new Resena(libro.get(), usuario.get(), text_resena);
        resenaRepository.save(resena);
    }

}