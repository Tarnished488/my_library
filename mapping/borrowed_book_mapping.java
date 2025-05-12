package my_library;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "borrowed_book")
public class borrowed_book_mapping {
@Id
@Column(name="Bbook_number")
private int bookNumber;
@Column(name="Borrowed_time")
private int borrowedTime;

}
