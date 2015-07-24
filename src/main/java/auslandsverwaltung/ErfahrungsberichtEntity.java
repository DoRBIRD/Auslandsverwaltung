package auslandsverwaltung;

import javax.persistence.*;

/**
 * Created by steven on 15.06.15.
 */
@Entity
@Table(name = "erfahrungsbericht", schema = "", catalog = "Auslandsverwaltung")
public class ErfahrungsberichtEntity {
    private int id;
    private String Betreff;
    private String Inhalt;
    private String Link;
    private int Student_id;

    @Id
    @GeneratedValue

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBetreff() {
        return Betreff;
    }

    public void setBetreff(String betreff) {
        Betreff = betreff;
    }

    public String getInhalt() {
        return Inhalt;
    }

    public void setInhalt(String inhalt) {
        Inhalt = inhalt;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public int getStudent_id() {
        return Student_id;
    }

    public void setStudent_id(int student_id) {
        Student_id = student_id;
    }
}