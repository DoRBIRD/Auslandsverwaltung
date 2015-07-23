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
@Table(name = "land", schema = "", catalog = "Auslandsverwaltung")
public class LandEntity {
    private String Name;
    @Id
    @GeneratedValue
    public String getName() {return Name;}
    public void setName(String Name) {this.Name = Name;}
}