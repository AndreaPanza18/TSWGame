package model;
import java.sql.*;
import java.util.*;

public class PurchaseDOA {
    //Function for purchase games that are in the cart
    public void PurchaseFromCart(List<Game> cart, int userID) throws SQLException {

        try (Connection con = ConPool.getConnection()){
            int purchaseId= 0;
            int totalCost = 0;
            int quantity = 0;
            for(Game cartGame : cart){
                totalCost += cartGame.getPrice()*cartGame.getQuantity();
                quantity += cartGame.getQuantity();
            }
            PreparedStatement tp = con.prepareStatement("insert into purchase( total_cost, quantity, customer_id) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            tp.setInt(1, totalCost);
            tp.setInt(2, quantity);
            tp.setInt(3, userID);
            int rows = tp.executeUpdate();
            if (rows > 0) {
                try (ResultSet generatedKeys = tp.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        purchaseId = generatedKeys.getInt(1);
                        System.out.println("the purchaseID is " + purchaseId +"!!!" );
                    } else {
                        throw new SQLException("Creating purchase failed, no ID obtained.");
                    }
                }
            }
            tp.close();
            for(Game cartGame : cart){
                int cost = cartGame.getQuantity()*cartGame.getPrice();
                PreparedStatement ps = con.prepareStatement("insert into purchase_game(quantity, cost, game_id, purchase_id, purchase_customer_id) values(?,?,?,?,?)");
                ps.setInt(1, cartGame.getQuantity());
                ps.setInt(2, cost);
                ps.setInt(3, cartGame.getId());
                ps.setInt(4, purchaseId);
                ps.setInt(5, userID);

                ps.executeUpdate();
                ps.close();
            }



            CartDOA emptyCart = new CartDOA();
            emptyCart.EmptyCart(userID);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //List of all the games bought by this User
    public List<Game> ViewBoughtGames(int userID){
        try (Connection con = ConPool.getConnection()) {


            List<Game> gameRes = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement("SELECT game_id from purchase_game where purchase_customer_id = ?");
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Game p = new Game();
                GameDOA getGame = new GameDOA();
                int id = rs.getInt(1);
                p = getGame.getByID(id);
                gameRes.add(p);
            }
            return gameRes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
