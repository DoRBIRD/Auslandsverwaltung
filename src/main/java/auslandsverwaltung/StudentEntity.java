package auslandsverwaltung;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    private int Matrikelnummer;
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
    public int getMatrikelnummer() {
        return Matrikelnummer;
    }
    public void setMatrikelnummer(double price) {
        this.Matrikelnummer = Matrikelnummer;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }
    public String Username() {
        return Username;
    }
    public void Username(String Username) {
        this.Username = Username;
    }
    public String Password() {
        return Password;
    }
    public void Password(String Password) { this.Password = Password; }

}