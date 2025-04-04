package com.example.api.library.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tblbook")
public class Book {
    @Id
    @Column(length = 5)
    private String idBook;
    @Column(length = 30, nullable = false)
    private String nombre;
    @Column(nullable = false)
    private LocalDate fechacompra;
    //Relacion de Book con prestamo (de uno a muchos)
    @OneToMany(mappedBy = "book")
    @JsonManagedReference // No genera una lista cíclica en prestamos

    private List<Prestamo> prestamos;

    // Contructores
    public Book(){}

    public Book(String idBook, String nombre, LocalDate fechacompra) {
        this.idBook = idBook;
        this.nombre = nombre;
        this.fechacompra = fechacompra;
    }

    public String getIdBook() {
        return idBook;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechacompra() {
        return fechacompra;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechacompra(LocalDate fechacompra) {
        this.fechacompra = fechacompra;
    }


}
