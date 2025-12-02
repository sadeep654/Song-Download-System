public class ArtistDAO {

    public int addArtist(String name) throws Exception {
        Connection con = DBConnection.getConnection();
        String query = "INSERT INTO artists (name) VALUES (?)";
        PreparedStatement pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, name);
        pst.executeUpdate();

        ResultSet rs = pst.getGeneratedKeys();
        rs.next();
        int id = rs.getInt(1);
        con.close();
        return id;
    }
}
