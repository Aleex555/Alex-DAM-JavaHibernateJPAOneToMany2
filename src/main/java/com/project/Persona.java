package com.project;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personaId;
    private String dni;
    private String nom;
    private String telefon;

    @ManyToMany
    @JoinTable(
        name = "persona_llibre",
        joinColumns = @JoinColumn(name = "personaId"),
        inverseJoinColumns = @JoinColumn(name = "llibreId")
    )
    private Set<Llibre> llibres;

    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Set<Llibre> getLlibres() {
        return llibres;
    }

    public void setLlibres(Set<Llibre> llibres) {
        this.llibres = llibres;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "personaId=" + personaId +
                ", dni='" + dni + '\'' +
                ", nom='" + nom + '\'' +
                ", telefon='" + telefon + '\'' +
                ", llibres=" + (llibres != null ? llibres.size() : "0") +
                '}';
    }
}

