package my_library;

public class borrowed_book {
    private int bookNumber;
    private int borrowedTime;

    // Default constructor
    public borrowed_book() {
    }

    // Parameterized constructor
    public borrowed_book(int bookNumber, int borrowedTime) {
        this.bookNumber = bookNumber;
        this.borrowedTime = borrowedTime;
    }

    // Getter for bookNumber
    public int getBookNumber() {
        return bookNumber;
    }

    // Setter for bookNumber
    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    // Getter for borrowedTime
    public int getBorrowedTime() {
        return borrowedTime;
    }

    // Setter for borrowedTime
    public void setBorrowedTime(int borrowedTime) {
        this.borrowedTime = borrowedTime;
    }

    // toString method for readable output
    @Override
    public String toString() {
        return "BorrowedBook{" +
                "bookNumber=" + bookNumber +
                ", borrowedTime=" + borrowedTime +
                '}';
    }

    // equals method for comparing objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        borrowed_book that = (borrowed_book) o;
        return bookNumber == that.bookNumber && borrowedTime == that.borrowedTime;
    }

    // hashCode method for consistent hashing
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + bookNumber;
        result = 31 * result + borrowedTime;
        return result;
    }
}
