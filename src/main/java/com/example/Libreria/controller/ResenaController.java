package com.example.Libreria.controller;

import com.example.Libreria.entity.Resena;
import com.example.Libreria.service.ResenaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resena")
public class ResenaController {
    private ResenaService resenaService;

    public ResenaController(ResenaService resenaService) {
        this.resenaService = resenaService;
    }

    @PostMapping("/save")
    public void addResena(Long libro_id, String resena) {
        this.resenaService.saveResena(libro_id, resena);
    }

}
