package com.example.Libreria.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "resenas")
public class Resena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="libro_id", nullable=false)
    private Libro libro;
    private String resena;

    public Resena() {}

    public Resena(Libro libro, String resena) {
        this.libro = libro;
        this.resena = resena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getResena() {
        return resena;
    }

    public void setResena(String resena) {
        this.resena = resena;
    }
}
