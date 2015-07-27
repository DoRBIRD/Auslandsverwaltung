package auslandsverwaltung;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by steven on 15.06.15.
 */
@Entity
@Table(name = "student", schema = "", catalog = "Auslandsverwaltung")
public class StudentEntity {
    @Id
    @GeneratedValue
    private int id;
    private int MatrikelNummer;
    private String Vorname;
    private String Nachname;
    private String Email;
    private String Username;
    private String Password;

    /**********************************************************************/

    public int getId() {
        return id;
    }
    public void setId(int id) { this.id = id; }
    public String getVorname() {
        return Vorname;
    }
    public void setVorname(String Vorname) {
        this.Vorname = Vorname;
    }
    public String getNachname() {
        return Nachname;
    }
    public void setNachname(String Nachname) {
        this.Nachname = Nachname;
    }
    public int getMatrikelNummer() {
        return MatrikelNummer;
    }
    public void setMatrikelNummer(double price) {
        this.MatrikelNummer = MatrikelNummer;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }
    public String getUsername() {
        return Username;
    }
    public void getUsername(String Username) {
        this.Username = Username;
    }
    public String getPassword() {
        return Password;
    }
    public void getPassword(String Password) { this.Password = Password; }

}