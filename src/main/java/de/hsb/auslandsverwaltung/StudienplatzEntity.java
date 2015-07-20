package de.hsb.auslandsverwaltung;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by steven on 15.06.15.
 */
@Entity
@Table(name = "Studienplatz", schema = "", catalog = "Auslandsverwaltung")
public class StudienplatzEntity {
    private int idStudienplatz;
    private Date startDatum;
    private Date endDatum;
    private byte verfuegbarkeit;
    private Integer studentIdStudent;
    private int univeritaetIdUniveritaet;

    @Id
    @Column(name = "idStudienplatz")
    public int getIdStudienplatz() {
        return idStudienplatz;
    }

    public void setIdStudienplatz(int idStudienplatz) {
        this.idStudienplatz = idStudienplatz;
    }

    @Basic
    @Column(name = "StartDatum")
    public Date getStartDatum() {
        return startDatum;
    }

    public void setStartDatum(Date startDatum) {
        this.startDatum = startDatum;
    }

    @Basic
    @Column(name = "EndDatum")
    public Date getEndDatum() {
        return endDatum;
    }

    public void setEndDatum(Date endDatum) {
        this.endDatum = endDatum;
    }

    @Basic
    @Column(name = "Verfuegbarkeit")
    public byte getVerfuegbarkeit() {
        return verfuegbarkeit;
    }

    public void setVerfuegbarkeit(byte verfuegbarkeit) {
        this.verfuegbarkeit = verfuegbarkeit;
    }

    @Basic
    @Column(name = "Student_idStudent")
    public Integer getStudentIdStudent() {
        return studentIdStudent;
    }

    public void setStudentIdStudent(Integer studentIdStudent) {
        this.studentIdStudent = studentIdStudent;
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

        StudienplatzEntity that = (StudienplatzEntity) o;

        if (idStudienplatz != that.idStudienplatz) return false;
        if (univeritaetIdUniveritaet != that.univeritaetIdUniveritaet) return false;
        if (verfuegbarkeit != that.verfuegbarkeit) return false;
        if (endDatum != null ? !endDatum.equals(that.endDatum) : that.endDatum != null) return false;
        if (startDatum != null ? !startDatum.equals(that.startDatum) : that.startDatum != null) return false;
        if (studentIdStudent != null ? !studentIdStudent.equals(that.studentIdStudent) : that.studentIdStudent != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idStudienplatz;
        result = 31 * result + (startDatum != null ? startDatum.hashCode() : 0);
        result = 31 * result + (endDatum != null ? endDatum.hashCode() : 0);
        result = 31 * result + (int) verfuegbarkeit;
        result = 31 * result + (studentIdStudent != null ? studentIdStudent.hashCode() : 0);
        result = 31 * result + univeritaetIdUniveritaet;
        return result;
    }
}