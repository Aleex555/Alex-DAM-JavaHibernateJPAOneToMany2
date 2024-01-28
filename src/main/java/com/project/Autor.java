package com.project;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long autorId;
    private String nom;

    @OneToMany(mappedBy = "autor")
    private Set<Llibre> llibres;

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
    }

    @Override
    public String toString() {
        return "Autor{" +
                "autorId=" + autorId +
                ", nom='" + nom + '\'' +
                ", llibres=" + (llibres != null ? llibres.size() : "0") +
                '}';
    }
}

