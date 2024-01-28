package com.project;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Llibre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long llibreId;
    private String nom;
    private String editorial;
    private Long idAutor;

    @ManyToMany(mappedBy = "llibres")
    private Set<Biblioteca> biblioteques;

    @ManyToOne
    @JoinColumn(name = "autorId")
    private Autor autor;

    @ManyToMany(mappedBy = "llibres")
    private Set<Persona> persones;

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

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
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
        return "Llibre{" +
                "llibreId=" + llibreId +
                ", nom='" + nom + '\'' +
                ", editorial='" + editorial + '\'' +
                ", idAutor=" + idAutor +
                ", autor=" + (autor != null ? autor.getNom() : "No Autor") +
                '}';
    }
}
