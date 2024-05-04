package model;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class GameDOA {

    public List<Game> retrieveByCategory(String category) {
        try (Connection con = ConPool.getConnection()) {
            List<Game> gameRes = new ArrayList<Game>();
            PreparedStatement ps = con.prepareStatement("SELECT id, game_name, price, category_category from game  where category_category = ?");
            ps.setString(1, category);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Game p = new Game();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setPrice((double) rs.getInt(3));
                p.setCategory(rs.getString(4));
                gameRes.add(p);
            }

            return gameRes;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Game> getTrending(){
        try (Connection con = ConPool.getConnection()) {
            List<Game> gameRes = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement("SELECT id, game_name, price, category_category, is_trending from game where is_trending = true ");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Game p = new Game();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setPrice((double) rs.getInt(3));
                p.setCategory(rs.getString(4));
                gameRes.add(p);
            }

            return gameRes;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void saveGame(Game game) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO game (game_name, price, category_category) VALUES(?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, game.getName());
            ps.setDouble(2, game.getPrice());
            ps.setString(3, game.getCategory());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            game.setId(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}