package model;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class WishlistDOA {
    public void addToWishlist(int gameID, int CustomerID ) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO wishlist(game_id, customer_id, date_added) VALUES(?,?,CURRENT_DATE)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, gameID);
            ps.setInt(2, CustomerID);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Game> getWishlist(int customer_id){
        try (Connection con = ConPool.getConnection()) {

            List<Game> gameRes = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement("SELECT game_id,date_added from wishlist where customer_id = ?");
            ps.setInt(1, customer_id);
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