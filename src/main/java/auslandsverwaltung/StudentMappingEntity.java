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


}