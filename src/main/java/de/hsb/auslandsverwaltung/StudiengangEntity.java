package de.hsb.auslandsverwaltung;

import javax.persistence.*;

/**
 * Created by steven on 15.06.15.
 */
@Entity
@Table(name = "Studiengang", schema = "", catalog = "Auslandsverwaltung")
public class StudiengangEntity {
    private int idStudiengang;
    private String bezeichnung;
    private Integer fakultaet;
    private int univeritaetIdUniveritaet;

    @Id
    @Column(name = "idStudiengang")
    public int getIdStudiengang() {
        return idStudiengang;
    }

    public void setIdStudiengang(int idStudiengang) {
        this.idStudiengang = idStudiengang;
    }

    @Basic
    @Column(name = "Bezeichnung")
    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    @Basic
    @Column(name = "Fakultaet")
    public Integer getFakultaet() {
        return fakultaet;
    }

    public void setFakultaet(Integer fakultaet) {
        this.fakultaet = fakultaet;
    }

    @Basic
    @Column(name = "Univeritaet_idUniveritaet")
    public int getUniveritaetIdUniveritaet() {
        return univeritaetIdUniveritaet;
    }

    public void setUniveritaetIdUniveritaet(int univeritaetIdUniveritaet) {
        this.univeritaetIdUniveritaet = univeritaetIdUniveritaet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudiengangEntity that = (StudiengangEntity) o;

        if (idStudiengang != that.idStudiengang) return false;
        if (univeritaetIdUniveritaet != that.univeritaetIdUniveritaet) return false;
        if (bezeichnung != null ? !bezeichnung.equals(that.bezeichnung) : that.bezeichnung != null) return false;
        if (fakultaet != null ? !fakultaet.equals(that.fakultaet) : that.fakultaet != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idStudiengang;
        result = 31 * result + (bezeichnung != null ? bezeichnung.hashCode() : 0);
        result = 31 * result + (fakultaet != null ? fakultaet.hashCode() : 0);
        result = 31 * result + univeritaetIdUniveritaet;
        return result;
    }
}