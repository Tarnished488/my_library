package my_library;

import javax.persistence.*;

@Entity
@Table(name = "librarian")
public class librarian_mapping {

    @Id
    @Column(name = "librarian_id", nullable = false)
    private int librarianId; // ͼ�����ԱID����Ϊ����

    @Column(name = "Damage_fine", nullable = true)
    private Integer damageFine; // �𻵷����Ϊ��

    // Ĭ�Ϲ��캯����JPA Ҫ��
    public librarian_mapping() {}

    // ���������캯��
    public librarian_mapping(int librarianId, Integer damageFine) {
        this.librarianId = librarianId;
        this.damageFine = damageFine;
    }

    // Getter �� Setter ����
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