package com.project;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Biblioteca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bibliotecaId;
    private String nom;
    private String ciutat;

    @ManyToMany
    @JoinTable(
        name = "biblioteca_llibre",
        joinColumns = @JoinColumn(name = "bibliotecaId"),
        inverseJoinColumns = @JoinColumn(name = "llibreId")
    )
    private Set<Llibre> llibres;

    public Long getBibliotecaId() {
        return bibliotecaId;
    }

    public void setBibliotecaId(Long bibliotecaId) {
        this.bibliotecaId = bibliotecaId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCiutat() {
        return ciutat;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    public Set<Llibre> getLlibres() {
        return llibres;
    }

    public void setLlibres(Set<Llibre> llibres) {
        this.llibres = llibres;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "bibliotecaId=" + bibliotecaId +
                ", nom='" + nom + '\'' +
                ", ciutat='" + ciutat + '\'' +
                ", llibres=" + (llibres != null ? llibres.size() : "0") +
                '}';
    }
}
