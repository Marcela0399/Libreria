package com.example.Libreria.service;

import com.example.Libreria.entity.Resena;
import com.example.Libreria.repository.LibroRepository;
import com.example.Libreria.repository.ResenaRepository;
import org.springframework.stereotype.Service;

@Service
public class ResenaService {
    private LibroRepository libroRepository;
    private ResenaRepository resenaRepository;

    public ResenaService(LibroRepository libroRepository, ResenaRepository resenaRepository) {
        this.libroRepository = libroRepository;
        this.resenaRepository = resenaRepository;
    }

    public void saveResena(Long libro_id, String text_resena) {
        Resena resena = new Resena(libroRepository.findById(libro_id).get(), text_resena);
        resenaRepository.save(resena);
    }

}