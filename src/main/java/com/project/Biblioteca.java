package com.project;

import javax.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Biblioteca")
public class Biblioteca {
    @Id
    @Column(name = "biblio_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long biblioId;
    @Column(name = "nom")
    private String nom;

    @Column(name = "ciutat")
    private String ciutat;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
    @JoinTable(name = "biblioteca_llibre", joinColumns = @JoinColumn(name = "bibliotecaId", referencedColumnName = "biblio_id"), inverseJoinColumns = @JoinColumn(name = "llibreId", referencedColumnName = "llibre_id"))
    private Set<Llibre> libros;

    public Biblioteca() {
    }

    public Biblioteca(String nom, String ciutat) {
        this.nom = nom;
        this.ciutat = ciutat;
    }

    public Long getBiblioId() {
        return biblioId;
    }

    public void setBiblioId(Long biblioId) {
        this.biblioId = biblioId;
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

    public Set<Llibre> getLibros() {
        return libros;
    }

    public void setLibros(Set<Llibre> llibres) {
        this.libros = llibres;
    }

    public List<Object[]> queryLlibres() {
        long id = this.getBiblioId();
        return Manager.queryTable(
                "select distinct l.* from biblioteca_llibre bl join Llibre l on bl.bibliotecaId=l.llibre_id where bl.bibliotecaId="
                        + id
                        + ";");
    }

    @Override
    public String toString() {
        // String str = Manager.tableToString(queryLlibres()).replaceAll("\n", " | ");
        return biblioId + ": " + nom + ", " + ciutat + ", Llibres: " + libros;
    }
}
