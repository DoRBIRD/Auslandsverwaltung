package auslandsverwaltung;

import javax.persistence.*;

/**
 * Created by steven on 15.06.15.
 */
@Entity
@Table(name = "universitaet", schema = "", catalog = "Auslandsverwaltung")
public class UniversitaetEntity {
    @Id
    @GeneratedValue
    private int id;
    private String Name;
    private String Standort;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getStandort() {
        return Standort;
    }

    public void setStandort(String Standort) {
        this.Standort = Standort;
    }
}

