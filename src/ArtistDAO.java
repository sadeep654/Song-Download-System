import java.sql.*;

/**
 * ArtistDAO - add artists and list artists.
 */
public class ArtistDAO {

    /**
     * Adds an artist and returns the generated artist_id.
     */
    public int addArtist(String name) throws Exception {
        String sql = "INSERT INTO artists (name) VALUES (?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, name);
            pst.executeUpdate();
            try (ResultSet keys = pst.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getInt(1);
                }
            }
        }
        return -1;
    }

    public void listArtists() throws Exception {
        String sql = "SELECT artist_id, name FROM artists ORDER BY artist_id";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("artist_id") + " | " + rs.getString("name"));
            }
        }
    }
}
