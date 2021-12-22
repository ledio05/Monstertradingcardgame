package project;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private int elo;
    private int coins = 20;
    private boolean isLooged;

    Stack stack;

    private List<Package> cardpackages = new ArrayList<Package>();

    public User(String username, String password, int elo, int coins){
        this.username=username;
        this.password=password;
        this.elo=elo;
        this.coins=coins;
        this.isLooged=false;

    }

    public String getUsername() {
        return username;
    }

    public int getElo() {
        return elo;
    }

    public void setElo(int elo) {
        this.elo = elo;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public boolean isLooged() {
        return isLooged;
    }

    public void setLooged(boolean looged) {
        isLooged = looged;
    }

    public Stack getStack() {
        return stack;
    }

    public boolean addCardToStack(Card card){

        if(card.getID() > 0) {
            try {
                Connection conn = DataBaseService.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO Stack (username, cardid) VALUES (?, ?);");
                ps.setString(1, this.username);
                ps.setInt(2, card.getID());
                int rows = ps.executeUpdate();
                if (rows == 1) {
                    stack.addCard(card);
                    return true;
                }
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean removeCardFromStack(Card card){
        if(card.getID() > 0) {
            try {
                Connection conn = DataBaseService.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement("DROP FROM Stack WHERE cardid = ?;");
                ps.setInt(1, card.getID());
                int rows = ps.executeUpdate();
                if (rows == 1) {
                    stack.removeCard(card);
                    return true;
                }
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;

    }

    public List<Package> getCardpackages() {
        return cardpackages;
    }

    public boolean addCardpackages(Package cardpackage) {
        if(cardpackage.isValid() && this.coins >= 5) { // only if package has 5 cards

            this.cardpackages.add(cardpackage);
            // update user -= 5 coins

            for(Card card: cardpackage.getCards()){
                if(this.addCardToStack(card) == false){
                    return false;
                }
            }
            updateCoins(this.coins - 5);
            // add 5 cards to stack


            // add new package table row

            // update user table, stack table
            return true;
        }
        // else do nothing
        return false;
    }

    private boolean updateCoins(int coins){
        try {
            Connection conn = DataBaseService.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE TABLE users SET coins = ? WHERE username = ?;");
            ps.setInt(1, coins);
            ps.setString(2, this.username);
            int rows = ps.executeUpdate();
            if (rows == 1) {
                this.coins = coins;
                return true;
            }
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
