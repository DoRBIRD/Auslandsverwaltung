package auslandsverwaltung;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by steven on 15.06.15.
 */
@Entity
@Table(name = "studienplatz", schema = "", catalog = "Auslandsverwaltung")
public class StudienplatzEntity {
    private int id;
    private Date StartDatum;
    private Date EndDatum;
    private byte Verfuegbarkeit;
    private Integer Student_id;
    private int universitaet_id;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDatum() {
        return StartDatum;
    }

    public void setStartDatum(Date startDatum) {
        StartDatum = startDatum;
    }

    public Date getEndDatum() {
        return EndDatum;
    }

    public void setEndDatum(Date endDatum) {
        EndDatum = endDatum;
    }

    public byte getVerfuegbarkeit() {
        return Verfuegbarkeit;
    }

    public void setVerfuegbarkeit(byte verfuegbarkeit) {
        Verfuegbarkeit = verfuegbarkeit;
    }

    public Integer getStudent_id() {
        return Student_id;
    }

    public void setStudent_id(Integer student_id) {
        Student_id = student_id;
    }

    public int getUniversitaet_id() {
        return universitaet_id;
    }

    public void setUniversitaet_id(int universitaet_id) {
        this.universitaet_id = universitaet_id;
    }
}