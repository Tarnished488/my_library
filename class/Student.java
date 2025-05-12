package my_library;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Student_id") // 映射到数据库中的 Student_id 列
    private Long studentId;

    @Column(name = "LC_Period_of_validity")
    private LocalDateTime libraryCardValidityPeriod;

    private String name;

    @OneToOne
    @JoinColumn(name = "library_card_id") // 外键列，关联 StudentLibraryCard
    private StudentLibraryCard libraryCard;

    // Getters and setters
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public LocalDateTime getLibraryCardValidityPeriod() {
        return libraryCardValidityPeriod;
    }

    public void setLibraryCardValidityPeriod(LocalDateTime libraryCardValidityPeriod) {
        this.libraryCardValidityPeriod = libraryCardValidityPeriod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentLibraryCard getLibraryCard() {
        return libraryCard;
    }

    public void setLibraryCard(StudentLibraryCard libraryCard) {
        this.libraryCard = libraryCard;
    }
}
