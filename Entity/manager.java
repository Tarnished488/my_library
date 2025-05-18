import java.sql.*;

public class Manager {
    private int managerId;       // 管理员ID
    private String name;         // 管理员姓名
    private LibrarianDAO librarianDAO;  // 管理员与LibrarianDAO的关联

    // 构造方法
    public Manager(int managerId, String name, Connection connection) {
        this.managerId = managerId;
        this.name = name;
        this.librarianDAO = new LibrarianDAO(connection);
    }

    // 获取管理员ID
    public int getManagerId() {
        return managerId;
    }

    // 设置管理员ID
    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    // 获取管理员姓名
    public String getName() {
        return name;
    }

    // 设置管理员姓名
    public void setName(String name) {
        this.name = name;
    }

    // 添加一个图书管理员
    public void addLibrarian(Librarian librarian) throws SQLException {
        librarianDAO.addLibrarian(librarian);
        System.out.println("librarian " + librarian.getName() + " has been added");
    }

    // 删除一个图书管理员
    public void removeLibrarian(int librarianId) throws SQLException {
        librarianDAO.deleteLibrarian(librarianId);
        System.out.println("librarian" + librarianId + " has been deleted");
    }
}
