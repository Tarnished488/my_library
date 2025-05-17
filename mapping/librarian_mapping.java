public Librarian findLibrarianById(int librarianId) {
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
        String sql = "SELECT * FROM librarian WHERE librarian_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, librarianId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            // === Mapping 开始 ===
            int id = rs.getInt("librarian_id");
            String name = rs.getString("name");
            int fine = rs.getInt("damage_fine");

            // 映射到 Java 对象
            return new Librarian(id, name, fine);
        }
    } catch (SQLException e) {
        System.out.println("查询失败：" + e.getMessage());
    }
    return null;
}
