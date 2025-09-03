package com.example.Libreria.controller;

import com.example.Libreria.entity.Resena;
import com.example.Libreria.service.ResenaService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/resena")
public class ResenaController {
    private ResenaService resenaService;

    public ResenaController(ResenaService resenaService) {
        this.resenaService = resenaService;
    }

    @GetMapping("/{libro_id}")
    public Optional<Resena> buscarResena(@PathVariable Long libro_id) {
        return resenaService.getResenas(libro_id);
    }

    @PostMapping("/save")
    public void addResena(Long libro_id, Long usuario_id, String resena) {
        this.resenaService.saveResena(libro_id, usuario_id, resena);
    }

}