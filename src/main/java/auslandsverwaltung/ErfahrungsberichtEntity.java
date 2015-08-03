package auslandsverwaltung;

import javax.persistence.*;

/**
 * Created by steven on 15.06.15.
 */
@Entity
@Table(name = "erfahrungsbericht", schema = "", catalog = "Auslandsverwaltung")
public class ErfahrungsberichtEntity {
    @Id
    @GeneratedValue
    private int id;
    private String Betreff;
    private String Inhalt;
    private String Link;
    @Column(name="Student_id")
    private int studentId;


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

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="student_id")
    private StudentEntity student;

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }


}