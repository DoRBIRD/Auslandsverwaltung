package auslandsverwaltung;

import javax.persistence.*;

/**
 * Created by steven on 15.06.15.
 */
@Entity
@Table(name = "studiengang", schema = "", catalog = "Auslandsverwaltung")
public class StudiengangEntity {
    private int id;
    private String Bezeichnung;
    private Integer Fakultaet;
    private int univeritaetId;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBezeichnung() {
        return Bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        Bezeichnung = bezeichnung;
    }

    public Integer getFakultaet() {
        return Fakultaet;
    }

    public void setFakultaet(Integer fakultaet) {
        Fakultaet = fakultaet;
    }

    public int getUniveritaetId() {
        return univeritaetId;
    }

    public void setUniveritaetId(int univeritaetId) {
        this.univeritaetId = univeritaetId;
    }
}