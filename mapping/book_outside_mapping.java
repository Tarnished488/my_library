package my_library;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="book_outside")
public class book_outside_mapping {
@Id
@Column(name="Title",length = 255)
private String title;
@Column(name="Purchase_day")
@Temporal(TemporalType.DATE)
private Date purchaseDay;

@Column(name = "Price", precision = 10, scale = 2)
private float price;

@Column(name = "Version", length = 255)
private String version;

@Column(name = "Author", length = 255)
private String author;
}
