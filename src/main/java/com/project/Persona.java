package com.project;

import javax.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "persona_id", unique = true, nullable = false)
    private Long personaId;
    private String dni;
    private String nom;
    private String telefon;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "persona_llibre", joinColumns = @JoinColumn(name = "personaId", referencedColumnName = "persona_id"), inverseJoinColumns = @JoinColumn(name = "llibreId", referencedColumnName = "llibre_id"))
    private Set<Llibre> llibres;

    public Persona() {
    }

    public Persona(String dni, String nom, String telefon) {
        this.nom = nom;
        this.dni = dni;
        this.telefon = telefon;
    }

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

    public List<Object[]> queryLlibres() {
        long id = this.getPersonaId();
        return Manager.queryTable(
                "select distinct l.* from persona_llibre pl join Llibre l on pl.personaId=l.llibre_id where pl.personaId="
                        + id
                        + ";");
    }

    @Override
    public String toString() {
        // String str = Manager.tableToString(queryLlibres()).replaceAll("\n", " | ");
        return personaId + ": " + nom + ", " + telefon + ", Llibres: " + llibres;
    }
}
