package library.model;

/**
 * 图书管理员，守护知识的灯塔。
 */
public class Librarian {

    private int librarianId;      // 图书管理员的编号，唯一识别
    private Integer damageFine;   // 因书籍损坏产生的罚款，或有或无

    // 构造方法
    public Librarian(int librarianId, Integer damageFine) {
        this.librarianId = librarianId;
        this.damageFine = damageFine;
    }

    // 无参构造
    public Librarian() {
    }

    // Getter 和 Setter
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

    // 美丽的文字表示
    @Override
    public String toString() {
        return "Librarian {" +
               "librarianId = " + librarianId +
               ", damageFine = " + (damageFine != null ? damageFine : "无罚款") +
               " }";
    }
}
