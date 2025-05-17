package my_library;

import java.util.Scanner;

public class librarian {
    private int librarianId;
    private String name;
    private Integer damageFine;

    // 正确构造函数
    public librarian(int librarianId, String name, Integer damageFine) {
        this.librarianId = librarianId;
        this.name = name;
        this.damageFine = damageFine;
    }

    // Getter
    public String getName() {
        return name;
    }

    // 管理功能
    public void punishStudent(Student student, int fineAmount) {
        student.setFineAmount(fineAmount);
        student.setBookLimit(0);
        System.out.println("学生 " + student.getName() + " 被罚款 " + fineAmount + " 元，并禁止借书。");
    }

    public void viewStudentReservations(StudentLibraryCard card) {
        System.out.println("\n--- 学生预约信息 ---");
        card.reservation_number();
        card.reservation_left_number();
        card.reservation_left_time();
    }

    public void viewStudentBorrowInfo(StudentLibraryCard card) {
        System.out.println("\n--- 学生借阅信息 ---");
        card.borrow_left_number();
        card.borrow_maximum_number();
        card.borrow_maximum_time();
    }

    // ===== 主程序入口 =====
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        librarianDao librarianDAO = new librarianDao();
        StudentDAO studentDAO = new StudentDAO();

        librarian librarian = null;

        // 登录管理员
        while (librarian == null) {
            System.out.print("请输入您的图书管理员ID登录：");
            String input = scanner.nextLine();

            try {
                int librarianId = Integer.parseInt(input);
                librarian = librarianDAO.findLibrarianById(librarianId);

                if (librarian == null) {
                    System.out.println("❌ 未找到该管理员ID，请重试。");
                } else {
                    System.out.println("✅ 登录成功，欢迎您，" + librarian.getName() + "！");
                }
            } catch (NumberFormatException e) {
                System.out.println("❗ 请输入有效数字 ID。");
            }
        }

        // 进入主界面
        while (true) {
            System.out.println("\n=== 图书管理员系统主界面 ===");
            System.out.println("1. 输入学生ID");
            System.out.println("2. 退出系统");
            System.out.print("请选择操作：");

            String choice = scanner.nextLine();

            if (choice.equals("2")) {
                System.out.println("📚 系统已退出，再会，" + librarian.getName() + "。");
                break;
            }

            try {
                System.out.print("请输入学生ID：");
                int studentId = Integer.parseInt(scanner.nextLine());
                Student student = studentDAO.findStudentById(studentId);

                if (student == null) {
                    System.out.println("未找到该学生。");
                    continue;
                }

                StudentLibraryCard card = student.getLibraryCard();

                while (true) {
                    System.out.println("\n--- 管理学生【" + student.getName() + "】 ---");
                    System.out.println("1. 查看预约信息");
                    System.out.println("2. 查看借阅信息");
                    System.out.println("3. 惩罚该学生");
                    System.out.println("4. 返回上一级");
                    System.out.print("请选择操作：");

                    String subChoice = scanner.nextLine();

                    switch (subChoice) {
                        case "1":
                            librarian.viewStudentReservations(card);
                            break;
                        case "2":
                            librarian.viewStudentBorrowInfo(card);
                            break;
                        case "3":
                            System.out.print("请输入罚款金额：");
                            int fine = Integer.parseInt(scanner.nextLine());
                            librarian.punishStudent(student, fine);
                            break;
                        case "4":
                            System.out.println("返回主菜单...");
                            break;
                        default:
                            System.out.println("无效选项，请重试。");
                    }

                    if (subChoice.equals("4")) break;
                }

            } catch (NumberFormatException e) {
                System.out.println("ID 输入有误，请重新输入数字格式。");
            }
        }

        scanner.close();
    }
}
