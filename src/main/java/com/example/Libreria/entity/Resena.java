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
    @ManyToOne
    @JoinColumn(name="usuario_id", nullable=false)
    private Usuario usuario;
    private String resena;

    public Resena() {}

    public Resena( Libro libro, Usuario usuario, String resena) {
        this.libro = libro;
        this.usuario = usuario;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getResena() {
        return resena;
    }

    public void setResena(String resena) {
        this.resena = resena;
    }
}
