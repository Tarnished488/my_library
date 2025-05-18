package my_library;

import java.util.Scanner;

public class librarian {
    private int librarianId;
    private String name;
    private Integer damageFine;

    public librarian(int librarianId, String name, Integer damageFine) {
        this.librarianId = librarianId;
        this.name = name;
        this.damageFine = damageFine;
    }

    public String getName() {
        return name;
    }

    public int getLibrarianId() {
        return librarianId;
    }

    public int getDamageFine() {
        return damageFine != null ? damageFine : 0;
    }

    // 学生相关功能
    public void punishStudent(Student student, int fineAmount) {
        student.setDamageFine(fineAmount);
        System.out.println("学生 " + student.getName() + " 被罚款 " + fineAmount + " 元。");
    }

    public void viewStudentInfo(Student student) {
        System.out.println("\n--- 学生信息 ---");
        System.out.println("姓名: " + student.getName());
        System.out.println("性别: " + student.getGender());
        System.out.println("年级: " + student.getGrade());
        System.out.println("借书: " + student.getBooksBorrowing());
        System.out.println("预约: " + student.getBooksReserved());
        System.out.println("是否逾期: " + (student.isOverdue() ? "是" : "否"));
        System.out.println("罚金: " + student.getDamageFine());
    }

    public void addStudent(StudentDAO dao, Scanner scanner) {
        System.out.print("学生ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("姓名: ");
        String name = scanner.nextLine();

        System.out.print("性别: ");
        String gender = scanner.nextLine();

        System.out.print("年级: ");
        String grade = scanner.nextLine();

        Student student = new Student(id, name, gender, grade, "", "", false, 0);
        if (dao.insertStudent(student)) {
            System.out.println("✅ 添加成功！");
        } else {
            System.out.println("❌ 添加失败，ID可能已存在。");
        }
    }

    // 图书相关功能
    public void addBook(BookDAO dao, Scanner scanner) {
        System.out.print("书籍ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("书名: ");
        String title = scanner.nextLine();

        System.out.print("作者: ");
        String author = scanner.nextLine();

        Book book = new Book(id, title, author, true);
        if (dao.addBook(book)) {
            System.out.println("✅ 图书添加成功！");
        } else {
            System.out.println("❌ 添加失败，ID可能已存在。");
        }
    }

    public void viewAllBooks(BookDAO dao) {
        System.out.println("\n--- 图书列表 ---");
        for (Book book : dao.getAllBooks()) {
            System.out.println(book);
        }
    }

    public void deleteBook(BookDAO dao, Scanner scanner) {
        System.out.print("请输入要删除的图书ID：");
        int id = Integer.parseInt(scanner.nextLine());
        if (dao.deleteBook(id)) {
            System.out.println("✅ 删除成功！");
        } else {
            System.out.println("❌ 未找到该图书。");
        }
    }

    // 主方法：运行系统
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        librarianDao libDao = new librarianDao();
        StudentDAO studentDao = new StudentDAO();
        BookDAO bookDao = new BookDAO();
        librarian lib = null;

        while (lib == null) {
            System.out.print("请输入管理员ID登录：");
            try {
                int id = Integer.parseInt(scanner.nextLine());
                lib = libDao.findLibrarianById(id);
                if (lib == null) System.out.println("❌ 未找到该ID。");
                else System.out.println("✅ 欢迎您：" + lib.getName());
            } catch (NumberFormatException e) {
                System.out.println("请输入数字！");
            }
        }

        while (true) {
            System.out.println("\n=== 主菜单 ===");
            System.out.println("1. 查找学生");
            System.out.println("2. 添加学生");
            System.out.println("3. 添加图书");
            System.out.println("4. 查看图书");
            System.out.println("5. 删除图书");
            System.out.println("6. 退出");
            System.out.print("选择操作：");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("输入学生ID：");
                    int studentId = Integer.parseInt(scanner.nextLine());
                    Student student = studentDao.findStudentById(studentId);
                    if (student == null) {
                        System.out.println("❌ 未找到该学生。");
                    } else {
                        lib.viewStudentInfo(student);
                        System.out.print("是否处罚此学生？(y/n)：");
                        if (scanner.nextLine().equalsIgnoreCase("y")) {
                            System.out.print("请输入罚金：");
                            int fine = Integer.parseInt(scanner.nextLine());
                            lib.punishStudent(student, fine);
                            studentDao.updateFine(studentId, fine);
                        }
                    }
                    break;
                case "2":
                    lib.addStudent(studentDao, scanner);
                    break;
                case "3":
                    lib.addBook(bookDao, scanner);
                    break;
                case "4":
                    lib.viewAllBooks(bookDao);
                    break;
                case "5":
                    lib.deleteBook(bookDao, scanner);
                    break;
                case "6":
                    System.out.println("再见！");
                    return;
                default:
                    System.out.println("无效选择。");
            }
        }
    }
}
