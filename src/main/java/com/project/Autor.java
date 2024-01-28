package com.project;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Autor")
public class Autor {
    @Id
    @Column(name = "autor_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long autorId;

    @Column(name = "nom")
    private String nom;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Llibre> llibres;

    public Autor() {
    }

    public Autor(String nom) {
        this.nom = nom;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Llibre> getLlibres() {
        return llibres;
    }

    public void setLlibres(Set<Llibre> llibres) {
        this.llibres = llibres;
        for (Llibre llibre : llibres) {
            llibre.setAutor(this);
        }
    }

    @Override
    public String toString() {
        return autorId + ": " + nom + ", " + llibres;
    }
}
