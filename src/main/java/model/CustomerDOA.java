package model;
import java.sql.*;
import java.util.*;


public class CustomerDOA {
    public Customer loginUser(String email, String password){
        try (Connection con = ConPool.getConnection()) {
            Customer c = new Customer();
            PreparedStatement ps = con.prepareStatement("SELECT id, name, last_name, email, password from customer  where email = ? AND password = ?");
            ps.setString(1, email);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setLastName(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setPassword(rs.getString(5));
                return c;
            }else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean CreateAccount(Customer c){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("INSERT INTO customer(name, last_name, email, password) VALUES(?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, c.getName());
            ps.setString(2, c.getLastName());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getPassword());
            if(ps.executeUpdate() != 1){
                return false;
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean AddToCart(int gameID, int userID){
        try (Connection con = ConPool.getConnection()) {
            CallableStatement cs = con.prepareCall("{call add_to_cart(?, ?, ?)}");
            cs.setInt(1, gameID);
            cs.setInt(2, userID);
            cs.setInt(3, 1); // Assuming quantity is hardcoded as 1 for now

            // Execute the stored procedure
            boolean hasResultSet = cs.execute();

            // Check if there are any result sets returned by the stored procedure
            if (!hasResultSet) {
                // No result set, means the procedure completed successfully
                return true;
            } else {
                // If there's a result set, you might need to handle it
                // For example, if you expect a result set containing generated keys
                ResultSet rs = cs.getResultSet();
                // Process the result set if needed
                return true; // Assuming success for now
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error adding item to cart: " + e.getMessage(), e);
        }
    }
}
