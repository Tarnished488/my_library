package my_library;

import java.util.Scanner;

public class Librarian {
    private int librarianId;
    private String name;
    private Integer damageFine;

    public Librarian(int librarianId, String name, Integer damageFine) {
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

    public void punishStudent(Student student, int fineAmount) {
        if (student.getLibraryCard() != null) {
            student.getLibraryCard().setFineAmount(fineAmount);
            System.out.println("学生 " + student.getName() + " 被罚款 " + fineAmount + " 元。");
        } else {
            System.out.println("该学生没有绑定借书卡，无法处罚。");
        }
    }

    public void viewStudentInfo(Student student) {
        System.out.println("\n--- 学生信息 ---");
        System.out.println("姓名: " + student.getName());
        System.out.println("学生ID: " + student.getStudentId());
        System.out.println("借书卡有效期: " + student.getLibraryCardValidityPeriod());

        if (student.getLibraryCard() != null) {
            System.out.println("当前罚金: " + student.getLibraryCard().getFineAmount());
        } else {
            System.out.println("未绑定借书卡。");
        }
    }

    public void addStudent(StudentDAO dao, Scanner scanner) {
        System.out.print("学生姓名: ");
        String name = scanner.nextLine();

        Student student = new Student();
        student.setName(name);
        student.setLibraryCardValidityPeriod(java.time.LocalDateTime.now().plusYears(1));

        StudentLibraryCard card = new StudentLibraryCard();
        card.setFineAmount(0);
        student.setLibraryCard(card);

        if (dao.insertStudent(student)) {
            System.out.println("✅ 学生添加成功！");
        } else {
            System.out.println("❌ 添加失败。");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibrarianDao libDao = new LibrarianDao();
        StudentDAO studentDao = new StudentDAO();
        Librarian lib = null;

        while (lib == null) {
            System.out.print("请输入管理员ID登录：");
            try {
                int id = Integer.parseInt(scanner.nextLine());
                lib = libDao.findLibrarianById(id);
                if (lib == null) System.out.println("❌ 未找到该ID。");
                else System.out.println("✅ 欢迎您：" + lib.getName());
            } catch (NumberFormatException e) {
                System.out.println("请输入有效数字！");
            }
        }

        while (true) {
            System.out.println("\n=== 主菜单 ===");
            System.out.println("1. 查找学生");
            System.out.println("2. 添加学生");
            System.out.println("3. 退出");
            System.out.print("选择操作：");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("输入学生ID：");
                    Long studentId = Long.parseLong(scanner.nextLine());
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
                    System.out.println("再见！");
                    return;
                default:
                    System.out.println("无效选择。");
            }
        }
    }
}
