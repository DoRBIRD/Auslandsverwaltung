package auslandsverwaltung;

import javax.persistence.*;

/**
 * Created by steven on 15.06.15.
 */
@Entity
@Table(name = "student_has_studiengang", schema = "", catalog = "Auslandsverwaltung")
public class StudentMappingEntity {
    @Id
    private int Student;
    private int Studiengang;


    public int getStudent() {
        return Student;
    }

    public void setStudent(int Student) {
        this.Student = Student;
    }

    public int getStudiengang() {
        return Studiengang;
    }

    public void setStudiengang(int Studiengang) {this.Studiengang = Studiengang; }


    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="student")
    private StudentEntity studi;

    public StudentEntity getStudi() {
        return studi;
    }

    public void setStudi(StudentEntity studi) {
        this.studi = studi;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="studiengang")
    private StudiengangEntity studigang;

    public StudiengangEntity getStudigang() {
        return studigang;
    }

    public void setStudigang(StudiengangEntity studigang) {
        this.studigang = studigang;
    }

}