package auslandsverwaltung;
import org.hibernate.annotations.Source;

import java.util.List;
import java.util.Set;
import javax.persistence.*;

/**
 * Created by steven on 15.06.15.
 */
@Entity
@Table(name = "land", schema = "", catalog = "Auslandsverwaltung")
public class LandEntity {
    @Id
    @GeneratedValue
    private String Name;
    public String getName() {return Name;}
    public void setName(String Name) {this.Name = Name;}


}