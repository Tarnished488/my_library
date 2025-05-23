package mylibrary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "employee_library_card")
public class employee_library_card_mapping {
    @Id
    @Column(name = "Card_id")
    private int cardId; // Added as a primary key, assuming a unique identifier for the card

    @Column(name = "Borrow_count")
    private int borrowCount;

    @Column(name = "Reservation_count")
    private int reservationCount;

    @Column(name = "Maximum_borrow_number")
    private int maximumBorrowNumber;

    @Column(name = "Maximum_borrow_time")
    private int maximumBorrowTime;

    @Column(name = "Maximum_reservation_time")
    private int maximumReservationTime;

    @Column(name = "Maximum_reservation_number")
    private int maximumReservationNumber;

    @Column(name = "Today_date")
    private LocalDate today;
}
