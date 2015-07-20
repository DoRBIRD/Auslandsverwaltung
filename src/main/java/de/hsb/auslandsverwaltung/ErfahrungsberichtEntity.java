package de.hsb.auslandsverwaltung;

import javax.persistence.*;

/**
 * Created by steven on 15.06.15.
 */
@Entity
@Table(name = "Erfahrungsbericht", schema = "", catalog = "Auslandsverwaltung")
public class ErfahrungsberichtEntity {
    private int idErfahrungsbericht;
    private String betreff;
    private String inhalt;
    private String link;
    private int studentIdStudent;

    @Id
    @Column(name = "idErfahrungsbericht")
    public int getIdErfahrungsbericht() {
        return idErfahrungsbericht;
    }

    public void setIdErfahrungsbericht(int idErfahrungsbericht) {
        this.idErfahrungsbericht = idErfahrungsbericht;
    }

    @Basic
    @Column(name = "Betreff")
    public String getBetreff() {
        return betreff;
    }

    public void setBetreff(String betreff) {
        this.betreff = betreff;
    }

    @Basic
    @Column(name = "Inhalt")
    public String getInhalt() {
        return inhalt;
    }

    public void setInhalt(String inhalt) {
        this.inhalt = inhalt;
    }

    @Basic
    @Column(name = "Link")
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Basic
    @Column(name = "Student_idStudent")
    public int getStudentIdStudent() {
        return studentIdStudent;
    }

    public void setStudentIdStudent(int studentIdStudent) {
        this.studentIdStudent = studentIdStudent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ErfahrungsberichtEntity that = (ErfahrungsberichtEntity) o;

        if (idErfahrungsbericht != that.idErfahrungsbericht) return false;
        if (studentIdStudent != that.studentIdStudent) return false;
        if (betreff != null ? !betreff.equals(that.betreff) : that.betreff != null) return false;
        if (inhalt != null ? !inhalt.equals(that.inhalt) : that.inhalt != null) return false;
        if (link != null ? !link.equals(that.link) : that.link != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idErfahrungsbericht;
        result = 31 * result + (betreff != null ? betreff.hashCode() : 0);
        result = 31 * result + (inhalt != null ? inhalt.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + studentIdStudent;
        return result;
    }
}