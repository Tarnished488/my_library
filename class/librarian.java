public class Librarian {
    private int librarianId;        // 图书管理员ID
    private String name;            // 图书管理员的名字
    private Integer damageFine;     // 罚款金额，可能为空（有可能为null）

    // 构造器
    public Librarian(int librarianId, String name) {
        this.librarianId = librarianId;
        this.name = name;
        this.damageFine = 0;  // 初始罚款金额为0
    }

    // 获取图书管理员ID
    public int getLibrarianId() {
        return librarianId;
    }

    // 设置图书管理员ID
    public void setLibrarianId(int librarianId) {
        this.librarianId = librarianId;
    }

    // 获取图书管理员名字
    public String getName() {
        return name;
    }

    // 设置图书管理员名字
    public void setName(String name) {
        this.name = name;
    }

    // 获取罚款金额
    public Integer getDamageFine() {
        return damageFine;
    }

    // 设置罚款金额
    public void setDamageFine(Integer damageFine) {
        this.damageFine = damageFine;
    }

    // 计算并为学生设置罚款
    public void setFineForStudent(Student student, int fineAmount) {
        if (student != null) {
            student.setFineAmount(fineAmount);
            System.out.println("学生 " + student.getName() + " 被罚款: " + fineAmount + " 元");
        }
    }

    // 计算并为员工设置罚款
    public void setFineForEmployee(Employee employee, int fineAmount) {
        if (employee != null) {
            employee.setFineAmount(fineAmount);
            System.out.println("员工 " + employee.getName() + " 被罚款: " + fineAmount + " 元");
        }
    }

    // 禁止学生借书
    public void banStudentFromBorrowing(Student student) {
        if (student != null) {
            student.setBookLimit(0);  // 设置借书上限为 0，禁止借书
            System.out.println("学生 " + student.getName() + " 被禁止借书。");
        }
    }

    // 禁止员工借书
    public void banEmployeeFromBorrowing(Employee employee) {
        if (employee != null) {
            employee.setBookLimit(0);  // 设置借书上限为 0，禁止借书
            System.out.println("员工 " + employee.getName() + " 被禁止借书。");
        }
    }

    // 重写toString方法，方便打印Librarian对象
    @Override
    public String toString() {
        return "Librarian{" +
                "librarianId=" + librarianId +
                ", name='" + name + '\'' +
                ", damageFine=" + damageFine +
                '}';
    }
}
