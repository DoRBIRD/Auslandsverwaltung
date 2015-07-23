package auslandsverwaltung;

import javax.persistence.*;

/**
 * Created by steven on 15.06.15.
 */
@Entity
@Table(name = "Universitaet", schema = "", catalog = "Auslandsverwaltung")
public class UniversitaetEntity {
    private int idUniversitaet;
    private String name;
    private String standort;


    @Id
    @Column(name = "id")
    public int getIdUniversitaet() {
        return idUniversitaet;
    }

    public void setIdUniversitaet(int idUniversitaet) {
        this.idUniversitaet = idUniversitaet;
    }

    @Basic
    @Column(name = "Name")
    public String getname() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Basic
    @Column(name = "Standort")
    public String getStandort() {
        return standort;
    }

    public void setStandort(String standort) {
        this.standort = standort;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UniversitaetEntity that = (UniversitaetEntity) o;

        if (idUniversitaet != that.idUniversitaet) return false;
        if (name != that.name) return false;
        if (standort != that.standort) return false;


        return true;
    }

    @Override
    public int hashCode() {
        int result = idUniversitaet;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (standort != null ? standort.hashCode() : 0);
        return result;
    }
}