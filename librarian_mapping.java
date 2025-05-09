package my_library;

import javax.persistence.*;

@Entity
@Table(name = "librarian")
public class librarian_mapping {

    @Id
    @Column(name = "librarian_id", nullable = false)
    private int librarianId; // 图书管理员ID，作为主键

    @Column(name = "Damage_fine", nullable = true)
    private Integer damageFine; // 损坏罚款，可为空

    // 默认构造函数（JPA 要求）
    public librarian_mapping() {}

    // 参数化构造函数
    public librarian_mapping(int librarianId, Integer damageFine) {
        this.librarianId = librarianId;
        this.damageFine = damageFine;
    }

    // Getter 和 Setter 方法
    public int getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(int librarianId) {
        this.librarianId = librarianId;
    }

    public Integer getDamageFine() {
        return damageFine;
    }

    public void setDamageFine(Integer damageFine) {
        this.damageFine = damageFine;
    }

    @Override
    public String toString() {
        return "Librarian{" +
               "librarianId=" + librarianId +
               ", damageFine=" + damageFine +
               '}';
    }
}