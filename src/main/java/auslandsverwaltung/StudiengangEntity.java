package auslandsverwaltung;

import javax.persistence.*;

/**
 * Created by steven on 15.06.15.
 */
@Entity
@Table(name = "studiengang", schema = "", catalog = "Auslandsverwaltung")
public class StudiengangEntity {
    @Id
    @GeneratedValue
    private int id;
    private String Bezeichnung;
    private Integer Fakultaet;
    private int universitaet_id;


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

    public int getUniversitaet_id() {
        return universitaet_id;
    }

    public void setUniversitaet_id(int universitaet_id) {
        this.universitaet_id = universitaet_id;
    }


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="universitaet_id", insertable = false, updatable = false)
    private UniversitaetEntity universitaet;

    public UniversitaetEntity getUniversitaet() {
        return universitaet;
    }

    public void setUniversitaet(UniversitaetEntity universitaet) {
        this.universitaet = universitaet;
    }

}