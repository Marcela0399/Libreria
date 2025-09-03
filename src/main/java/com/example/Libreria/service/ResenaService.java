package com.example.Libreria.service;

import com.example.Libreria.entity.Resena;
import com.example.Libreria.repository.LibroRepository;
import com.example.Libreria.repository.ResenaRepository;
import com.example.Libreria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResenaService {
    private LibroRepository libroRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    private ResenaRepository resenaRepository;

    public ResenaService(LibroRepository libroRepository, ResenaRepository resenaRepository) {
        this.libroRepository = libroRepository;
        this.resenaRepository = resenaRepository;
    }

    public Optional<Resena> getResenas(Long libro_id) {
        return resenaRepository.findByLibroId(libro_id);
    }

    public void saveResena(Long libro_id, Long usuario_id, String text_resena) {
        Resena resena = new Resena(libroRepository.findById(libro_id).get(),
                usuarioRepository.findById(usuario_id).orElseThrow(),
                text_resena);
        resenaRepository.save(resena);
    }

}