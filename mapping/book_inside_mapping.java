package my_library;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books_inside")
public class book_inside_mapping extends book_inside {

    @Id
    @Column(name = "Location")
    private int location;

    @Column(name = "Category")
    private String category;

    // 外键：指向 validity_periods 表（你可换为真实目标表）
    @ManyToOne
    @JoinColumn(name = "Period_of_validity", referencedColumnName = "Period_of_validity") // 假设主键名是 id
    private library_card validityPeriod;

    // 外键：指向 book_outside(Title)
    @ManyToOne
    @JoinColumn(name = "Title", referencedColumnName = "Title")
    private book_outside_mapping bookOutside;
}
