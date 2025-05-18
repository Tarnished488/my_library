package my_library;

import java.util.Scanner;

public class Manager {

    private String managerName;

    public Manager(String name) {
        this.managerName = name;
    }

    public void addLibrarian(LibrarianDao dao, Scanner scanner) {
        try {
            System.out.print("请输入新管理员ID：");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("请输入管理员姓名：");
            String name = scanner.nextLine();

            System.out.print("请输入默认罚金（元）：");
            int fine = Integer.parseInt(scanner.nextLine());

            librarian lib = new librarian(id, name, fine);
            boolean success = dao.insertLibrarian(lib);

            if (success) {
                System.out.println("✅ 成功添加管理员：" + name);
            } else {
                System.out.println("❌ 添加失败，ID可能已存在。");
            }
        } catch (Exception e) {
            System.out.println("⚠️ 输入格式有误，请重试。");
        }
    }

    public void deleteLibrarian(LibrarianDao dao, Scanner scanner) {
        try {
            System.out.print("请输入要删除的管理员ID：");
            int id = Integer.parseInt(scanner.nextLine());

            boolean success = dao.deleteLibrarianById(id);
            if (success) {
                System.out.println("✅ 成功删除管理员 ID: " + id);
            } else {
                System.out.println("❌ 删除失败，未找到该管理员。");
            }
        } catch (Exception e) {
            System.out.println("⚠️ 输入格式有误，请重试。");
        }
    }

    public void manage(LibrarianDao dao) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("📚 欢迎进入管理员管理系统");

        while (true) {
            System.out.println("\n=== 管理员操作菜单 ===");
            System.out.println("1. 添加图书管理员");
            System.out.println("2. 删除图书管理员");
            System.out.println("3. 退出管理");
            System.out.print("请选择操作：");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addLibrarian(dao, scanner);
                    break;
                case "2":
                    deleteLibrarian(dao, scanner);
                    break;
                case "3":
                    System.out.println("📘 管理退出。再见，" + managerName + "！");
                    return;
                default:
                    System.out.println("无效选项，请重试。");
            }
        }
    }

    public static void main(String[] args) {
        LibrarianDao dao = new LibrarianDao();
        Manager manager = new Manager("馆长·书魂");
        manager.manage(dao);
    }
}
