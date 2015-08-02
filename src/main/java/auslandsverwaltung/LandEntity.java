package auslandsverwaltung;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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