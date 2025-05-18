package my_library;

import java.sql.*;

public class LibrarianDao {

    public librarian findLibrarianById(int id) {
        String sql = "SELECT * FROM librarian WHERE librarian_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new librarian(
                    rs.getInt("librarian_id"),
                    rs.getString("name"),
                    rs.getInt("damage_fine")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insertLibrarian(librarian lib) {
        String sql = "INSERT INTO librarian (librarian_id, name, damage_fine) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, lib.getLibrarianId());
            stmt.setString(2, lib.getName());
            stmt.setInt(3, lib.getDamageFine());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("添加管理员失败：" + e.getMessage());
            return false;
        }
    }

    public boolean deleteLibrarianById(int id) {
        String sql = "DELETE FROM librarian WHERE librarian_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("删除管理员失败：" + e.getMessage());
            return false;
        }
    }
}
