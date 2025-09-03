package com.example.Libreria.controller;

import com.example.Libreria.entity.Resena;
import com.example.Libreria.service.ResenaService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/resena")
public class ResenaController {
    private ResenaService resenaService;

    public ResenaController(ResenaService resenaService) {
        this.resenaService = resenaService;
    }

    @GetMapping("/{libro_id}")
    public List<Resena> getResenas(@PathVariable Long libro_id) {
        return resenaService.obtenerResenas(libro_id);
    }

    @PostMapping("/save")
    public void addResena(@RequestParam Long libroId, @RequestParam Long usuarioId, @RequestParam String resena) {
        resenaService.saveResena(libroId, usuarioId, resena);
    }

}