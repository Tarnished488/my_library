package my_library;

import java.sql.*;

public class librarianDao {

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
}

