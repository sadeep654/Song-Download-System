/**
 * User - simple placeholder class for potential future expansion.
 */
public class User {
    private int userId;
    private String username;
    // extend with fields like email, passwordHash, role, etc.

    public User() {}

    public User(int userId, String username) {
        this.userId = userId;
        this.username = username;
    }
    // getters/setters
    public int getUserId(){ return userId; }
    public void setUserId(int id){ this.userId = id; }
    public String getUsername(){ return username; }
    public void setUsername(String u){ this.username = u; }
}
