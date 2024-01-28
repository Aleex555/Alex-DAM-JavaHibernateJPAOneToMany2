package com.project;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Llibre")
public class Llibre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "llibre_id", unique = true, nullable = false)
    private Long llibreId;

    @Column(name = "nom")
    private String nom;

    @Column(name = "editorial")
    private String editorial;

    @ManyToMany(mappedBy = "libros")
    private Set<Biblioteca> biblioteques;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @ManyToMany(mappedBy = "llibres")
    private Set<Persona> persones;

    public Llibre() {
    }

    public Llibre(String nom, String editorial) {
        this.nom = nom;
        this.editorial = editorial;
    }

    public Long getLlibreId() {
        return llibreId;
    }

    public void setLlibreId(Long llibreId) {
        this.llibreId = llibreId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Set<Biblioteca> getBiblioteques() {
        return biblioteques;
    }

    public void setBiblioteques(Set<Biblioteca> biblioteques) {
        this.biblioteques = biblioteques;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Set<Persona> getPersones() {
        return persones;
    }

    public void setPersones(Set<Persona> persones) {
        this.persones = persones;
    }

    @Override
    public String toString() {
        return llibreId + ": " + editorial + ", " + nom;
    }
}
