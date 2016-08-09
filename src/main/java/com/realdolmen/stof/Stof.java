package com.realdolmen.stof;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 * Super fancy Stof class.
 */
@Entity
public class Stof {

    @Id
    private Long id;

    @Size(max=50)
    private String naam;

    @Size(max=50)
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
}
