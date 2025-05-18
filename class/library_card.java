package my_library.Entity;

import java.util.ArrayList;
import java.util.List;

public class LibraryCard {
    private int periodOfValidity;

    private List<BorrowedBook> borrowedBooks;
    private List<ReservationBook> reservationBooks;

    public LibraryCard() {
        this.borrowedBooks = new ArrayList<>();
        this.reservationBooks = new ArrayList<>();
    }

    public LibraryCard(int periodOfValidity) {
        this.periodOfValidity = periodOfValidity;
        this.borrowedBooks = new ArrayList<>();
        this.reservationBooks = new ArrayList<>();
    }

    public int getPeriodOfValidity() {
        return periodOfValidity;
    }

    public void setPeriodOfValidity(int periodOfValidity) {
        this.periodOfValidity = periodOfValidity;
    }

    public List<BorrowedBook> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<BorrowedBook> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public List<ReservationBook> getReservationBooks() {
        return reservationBooks;
    }

    public void setReservationBooks(List<ReservationBook> reservationBooks) {
        this.reservationBooks = reservationBooks;
    }

    @Override
    public String toString() {
        return "LibraryCard{" +
                "periodOfValidity=" + periodOfValidity +
                ", borrowedBooks=" + borrowedBooks +
                ", reservationBooks=" + reservationBooks +
                '}';
    }

    // 可添加类型区分方法
    public String getCardType() {
        return "Generic";
    }

    public boolean canRenew() {
        return false;
    }
}

