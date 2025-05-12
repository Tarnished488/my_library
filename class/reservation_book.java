package library.model;

/**
 * ReservationBook —— 被预约的书本，时间的信使。
 */
public class ReservationBook {

    private int rbookNumber;        // 书本编号，是唯一的凭据
    private int reservationTime;    // 预约时间，记录一段期待

    // 构造方法
    public ReservationBook(int rbookNumber, int reservationTime) {
        this.rbookNumber = rbookNumber;
        this.reservationTime = reservationTime;
    }

    // 无参构造
    public ReservationBook() {
    }

    // Getter 和 Setter
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

    // 诗意的文字描述
    @Override
    public String toString() {
        return "ReservationBook {" +
               "rbookNumber = " + rbookNumber +
               ", reservationTime = " + reservationTime +
               " }";
    }
}
