package de.hsb.auslandsverwaltung;

import javax.persistence.*;

/**
 * Created by steven on 15.06.15.
 */
@Entity
@Table(name = "Student", schema = "", catalog = "Auslandsverwaltung")
public class StudentEntity {
    private int idStudent;
    private String vorname;
    private String nachname;
    private String username;
    private String password;
    private String matrikelNummer;
    private String email;

    @Id
    @Column(name = "idStudent")
    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    @Basic
    @Column(name = "Vorname")
    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    @Basic
    @Column(name = "Nachname")
    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    @Basic
    @Column(name = "Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "Username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "MatrikelNummer")
    public String getMatrikelNummer() {
        return matrikelNummer;
    }

    public void setMatrikelNummer(String matrikelNummer) {
        this.matrikelNummer = matrikelNummer;
    }

    @Basic
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (idStudent != that.idStudent) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (matrikelNummer != null ? !matrikelNummer.equals(that.matrikelNummer) : that.matrikelNummer != null)
            return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (nachname != null ? !nachname.equals(that.nachname) : that.nachname != null) return false;
        if (vorname != null ? !vorname.equals(that.vorname) : that.vorname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idStudent;
        result = 31 * result + (vorname != null ? vorname.hashCode() : 0);
        result = 31 * result + (nachname != null ? nachname.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (matrikelNummer != null ? matrikelNummer.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}