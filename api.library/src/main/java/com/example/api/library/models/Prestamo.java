package com.example.api.library.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaprestamo;
    private LocalDate fechadevolucion;
    // Relacion con libros de Muchos a Uno
    @ManyToOne
    @JsonBackReference // no se genera inf ciclica
    @JoinColumn(referencedColumnName = "idbook")
    private Book book;

    public Prestamo(Long id, LocalDate fechaprestamo, LocalDate fechadevolucion) {
        this.id = id;
        this.fechaprestamo = fechaprestamo;
        this.fechadevolucion = fechadevolucion;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getFechaprestamo() {
        return fechaprestamo;
    }

    public LocalDate getFechadevolucion() {
        return fechadevolucion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFechaprestamo(LocalDate fechaprestamo) {
        this.fechaprestamo = fechaprestamo;
    }

    public void setFechadevolucion(LocalDate fechadevolucion) {
        this.fechadevolucion = fechadevolucion;
    }

    public Prestamo(){


    }
}
