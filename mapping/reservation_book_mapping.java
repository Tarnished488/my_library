package my_library;

import javax.persistence.*;

@Entity
@Table(name = "reservation_book")
@IdClass(ReservationBookId.class) // 使用联合主键类
public class reservation_book_mapping {

    @Id
    @Column(name = "Rbook_number", nullable = false)
    private int rbookNumber; // 图书编号

    @Id
    @Column(name = "Reservation_time", nullable = false)
    private int reservationTime; // 预约时间（整数形式，例如天数或时间戳）

    @ManyToOne
    @JoinColumn(name = "library_card_id")
    private StudentLibraryCard libraryCard;

    // 默认构造函数（JPA 要求）
    public reservation_book_mapping() {}

    // 参数化构造函数
    public reservation_book_mapping(int rbookNumber, int reservationTime) {
        this.rbookNumber = rbookNumber;
        this.reservationTime = reservationTime;
    }

    // Getter 和 Setter 方法
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

// 联合主键类
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
