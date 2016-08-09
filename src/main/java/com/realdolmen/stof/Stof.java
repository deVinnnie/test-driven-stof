package com.realdolmen.stof;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Super fancy Stof class.
 */
@Entity
public class Stof {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max=50)
    @NotNull
    @Column
    private String naam;

    @Size(max=50)
    @Column
    @NotNull
    private String nummer;

    //<editor-fold desc="Getters and Setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }

    //</editor-fold>

    public boolean isValid() {
        StofNummerValidator nummerValidator = new StofNummerValidator();
        return nummerValidator.validateStofNummer(this.getNummer());
    }
}
