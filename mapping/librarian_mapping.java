import java.sql.*;

public class LibrarianMapping {
    
    // 将 ResultSet 映射为 Librarian 对象
    public static Librarian mapResultSetToLibrarian(ResultSet rs) throws SQLException {
        int librarianId = rs.getInt("librarian_id");
        String name = rs.getString("name");
        int damageFine = rs.getInt("damage_fine");
        return new Librarian(librarianId, name);
    }
    
    // 插入 Librarian 对象到数据库
    public static void insertLibrarian(Connection conn, Librarian librarian) throws SQLException {
        String sql = "INSERT INTO librarian (name, damage_fine) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, librarian.getName());
            stmt.setInt(2, librarian.getDamageFine());
            stmt.executeUpdate();
        }
    }

    // 更新数据库中的 Librarian 对象
    public static void updateLibrarian(Connection conn, Librarian librarian) throws SQLException {
        String sql = "UPDATE librarian SET name = ?, damage_fine = ? WHERE librarian_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, librarian.getName());
            stmt.setInt(2, librarian.getDamageFine());
            stmt.setInt(3, librarian.getLibrarianId());
            stmt.executeUpdate();
        }
    }

    // 通过 librarian_id 从数据库中查询 Librarian
    public static Librarian getLibrarianById(Connection conn, int librarianId) throws SQLException {
        String sql = "SELECT * FROM librarian WHERE librarian_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, librarianId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToLibrarian(rs);
                }
            }
        }
        return null;  // 如果没有找到对应的 librarian
    }

    // 删除 Librarian 对象
    public static void deleteLibrarian(Connection conn, int librarianId) throws SQLException {
        String sql = "DELETE FROM librarian WHERE librarian_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, librarianId);
            stmt.executeUpdate();
        }
    }
}
