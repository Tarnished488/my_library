package my_library;

import java.sql.*;

public class librarianDao {
    // 替换为你自己的数据库地址、用户名与密码
    private static final String URL = "jdbc:mysql://localhost:3306/my_library";
    private static final String USER = "root";
    private static final String PASSWORD = "Wiey6ikt3#";

    // 根据ID查找管理员
    public librarian findLibrarianById(int librarianId) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM librarian WHERE librarian_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, librarianId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                Integer damageFine = rs.getInt("damage_fine");
                return new librarian(librarianId, name, damageFine);
            }
        } catch (SQLException e) {
            System.out.println("数据库错误（查找管理员）：" + e.getMessage());
        }
        return null;
    }

    // 可选：插入管理员
    public boolean insertLibrarian(librarian librarian) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO librarian (librarian_id, name, damage_fine) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, librarian.getLibrarianId());
            stmt.setString(2, librarian.getName());
            stmt.setInt(3, librarian.getDamageFine());

            int affected = stmt.executeUpdate();
            return affected > 0;
        } catch (SQLException e) {
            System.out.println("插入失败：" + e.getMessage());
            return false;
        }
    }
}
