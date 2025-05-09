package my_library;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="library_card")
public class library_card_mapping {
@Id
@Column(name="Period_of_validity")
private int periodOfValidity;
}
