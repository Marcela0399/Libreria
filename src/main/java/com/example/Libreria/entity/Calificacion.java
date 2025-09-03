package com.example.Libreria.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "calificaciones")
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "libro_id")
    private Libro libro;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private int puntuacion; // Puntuación del 1 al 5

    public Calificacion() {}

    public Calificacion(Libro libro, Usuario usuario, int puntuacion) {
        this.libro = libro;
        this.usuario = usuario;
        this.puntuacion = puntuacion;
    }

    public Long getId() { return id; }
    public Libro getLibro() { return libro; }
    public void setLibro(Libro libro) { this.libro = libro; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public int getPuntuacion() { return puntuacion; }
    public void setPuntuacion(int puntuacion) { this.puntuacion = puntuacion; }
}