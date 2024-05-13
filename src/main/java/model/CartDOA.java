package model;
import java.sql.*;
import java.util.*;

public class CartDOA {
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

    public List<Game> getCart(int customer_id){
        try (Connection con = ConPool.getConnection()) {


            List<Game> gameRes = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement("SELECT game_id,quantity from shopping_cart where customer_id = ?");
            ps.setInt(1, customer_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Game p = new Game();
                GameDOA getGame = new GameDOA();
                int id = rs.getInt(1);
                int quantity = rs.getInt(2);
                p = getGame.getByID(id);
                p.setQuantity(quantity);
                gameRes.add(p);
            }
            return gameRes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean RemoveFromCart(int userID, int gameID, List<Game> cart){
        try (Connection con = ConPool.getConnection()){
            for(Game cartGame : cart){
                if(cartGame.getId() == gameID){
                    String queryString = new String();
                    if(cartGame.getQuantity() == 1) {
                        queryString = "DELETE FROM shopping_cart WHERE game_id = ? and customer_id = ?";
                    }else{
                        queryString = "UPDATE shopping_cart set quantity = quantity- 1 where game_id = ? and customer_id = ?";
                    }
                    PreparedStatement ps = con.prepareStatement(queryString);
                    ps.setInt(1, cartGame.getId());
                    ps.setInt(2, userID);
                    int rs = ps.executeUpdate();
                    return true;
                }
            }
            return false;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
