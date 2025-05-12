package my_library;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

public class student_library_card {
    private int studentMaximumBorrowTime;
    private Integer studentMaximumBorrowNumber;
    private Integer studentMaximumReservationNumber;
    private Integer studentMaximumReservationTime;
    private Integer studentBorrowLeftTime;
    private Integer studentBorrowLeftNumber;
    private Integer studentReservationLeftNumber;
    private Integer studentReservationLeftTime;
    private Integer periodOfValidity;

    public student_library_card() {
    }

@Entity
@Table(name = "student_library_card")
public class StudentLibraryCard {
    @Id
    private int studentMaximumBorrowTime;

    private Integer studentMaximumBorrowNumber;
    private Integer studentMaximumReservationNumber;
    private Integer studentMaximumReservationTime;
    private Integer studentBorrowLeftTime;
    private Integer studentBorrowLeftNumber;
    private Integer studentReservationLeftNumber;
    private Integer studentReservationLeftTime;

    @ManyToOne
    @JoinColumn(name = "Period_of_validity", referencedColumnName = "Period_of_validity")
    private library_card periodOfValidity;

    // Default constructor
    public StudentLibraryCard() {
    }

    // Parameterized constructor
    public StudentLibraryCard(int studentMaximumBorrowTime, Integer studentMaximumBorrowNumber,
                              Integer studentMaximumReservationNumber, Integer studentMaximumReservationTime,
                              Integer studentBorrowLeftTime, Integer studentBorrowLeftNumber,
                              Integer studentReservationLeftNumber, Integer studentReservationLeftTime,
                              library_card periodOfValidity) {
        this.studentMaximumBorrowTime = studentMaximumBorrowTime;
        this.studentMaximumBorrowNumber = studentMaximumBorrowNumber;
        this.studentMaximumReservationNumber = studentMaximumReservationNumber;
        this.studentMaximumReservationTime = studentMaximumReservationTime;
        this.studentBorrowLeftTime = studentBorrowLeftTime;
        this.studentBorrowLeftNumber = studentBorrowLeftNumber;
        this.studentReservationLeftNumber = studentReservationLeftNumber;
        this.studentReservationLeftTime = studentReservationLeftTime;
        this.periodOfValidity = periodOfValidity;
    }

    // Getters and Setters
    public int getStudentMaximumBorrowTime() {
        return studentMaximumBorrowTime;
    }

    public void setStudentMaximumBorrowTime(int studentMaximumBorrowTime) {
        this.studentMaximumBorrowTime = studentMaximumBorrowTime;
    }

    public Integer getStudentMaximumBorrowNumber() {
        return studentMaximumBorrowNumber;
    }

    public void setStudentMaximumBorrowNumber(Integer studentMaximumBorrowNumber) {
        this.studentMaximumBorrowNumber = studentMaximumBorrowNumber;
    }

    public Integer getStudentMaximumReservationNumber() {
        return studentMaximumReservationNumber;
    }

    public void setStudentMaximumReservationNumber(Integer studentMaximumReservationNumber) {
        this.studentMaximumReservationNumber = studentMaximumReservationNumber;
    }

    public Integer getStudentMaximumReservationTime() {
        return studentMaximumReservationTime;
    }

    public void setStudentMaximumReservationTime(Integer studentMaximumReservationTime) {
        this.studentMaximumReservationTime = studentMaximumReservationTime;
    }

    public Integer getStudentBorrowLeftTime() {
        return studentBorrowLeftTime;
    }

    public void setStudentBorrowLeftTime(Integer studentBorrowLeftTime) {
        this.studentBorrowLeftTime = studentBorrowLeftTime;
    }

    public Integer getStudentBorrowLeftNumber() {
        return studentBorrowLeftNumber;
    }

    public void setStudentBorrowLeftNumber(Integer studentBorrowLeftNumber) {
        this.studentBorrowLeftNumber = studentBorrowLeftNumber;
    }

    public Integer getStudentReservationLeftNumber() {
        return studentReservationLeftNumber;
    }

    public void setStudentReservationLeftNumber(Integer studentReservationLeftNumber) {
        this.studentReservationLeftNumber = studentReservationLeftNumber;
    }

    public Integer getStudentReservationLeftTime() {
        return studentReservationLeftTime;
    }

    public void setStudentReservationLeftTime(Integer studentReservationLeftTime) {
        this.studentReservationLeftTime = studentReservationLeftTime;
    }

    public library_card getPeriodOfValidity() {
        return periodOfValidity;
    }

    public void setPeriodOfValidity(library_card periodOfValidity) {
        this.periodOfValidity = periodOfValidity;
    }
}
}
