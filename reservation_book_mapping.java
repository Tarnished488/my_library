package my_library;

import javax.persistence.*;

@Entity
@Table(name = "reservation_book")
@IdClass(ReservationBookId.class) // ʹ������������
public class reservation_book_mapping {

    @Id
    @Column(name = "Rbook_number", nullable = false)
    private int rbookNumber; // ͼ����

    @Id
    @Column(name = "Reservation_time", nullable = false)
    private int reservationTime; // ԤԼʱ�䣨������ʽ������������ʱ�����

    @ManyToOne
    @JoinColumn(name = "library_card_id")
    private StudentLibraryCard libraryCard;

    // Ĭ�Ϲ��캯����JPA Ҫ��
    public reservation_book_mapping() {}

    // ���������캯��
    public reservation_book_mapping(int rbookNumber, int reservationTime) {
        this.rbookNumber = rbookNumber;
        this.reservationTime = reservationTime;
    }

    // Getter �� Setter ����
    public int getRbookNumber() {
        return rbookNumber;
    }

    public void setRbookNumber(int rbookNumber) {
        this.rbookNumber = rbookNumber;
    }

    public int getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(int reservationTime) {
        this.reservationTime = reservationTime;
    }

    public StudentLibraryCard getLibraryCard() {
        return libraryCard;
    }

    public void setLibraryCard(StudentLibraryCard libraryCard) {
        this.libraryCard = libraryCard;
    }

    @Override
    public String toString() {
        return "ReservationBook{" +
               "rbookNumber=" + rbookNumber +
               ", reservationTime=" + reservationTime +
               '}';
    }
}

// ����������
class ReservationBookId implements java.io.Serializable {
    private int rbookNumber;
    private int reservationTime;

    public ReservationBookId() {}

    public ReservationBookId(int rbookNumber, int reservationTime) {
        this.rbookNumber = rbookNumber;
        this.reservationTime = reservationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationBookId that = (ReservationBookId) o;
        return rbookNumber == that.rbookNumber && reservationTime == that.reservationTime;
    }

    @Override
    public int hashCode() {
        return 31 * rbookNumber + reservationTime;
    }
}