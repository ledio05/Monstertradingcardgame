package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Spellcard extends Card {

    public Spellcard(Elementtype elementtype, int damage){
        this.elementtype = elementtype;
        this.damage = damage;
        getName();
    }

    public void getName(){
        name = elementtype + "Spell";
    }

    @Override
    public int getID() {
        try {
            Connection conn = DataBaseService.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT cardid FROM Card WHERE name = ? AND damage = ? AND " +
                    "Elementtype = ? AND Cardtype = ?");
            ps.setString(1, this.name);
            ps.setInt(2, this.damage);
            ps.setString(3, this.elementtype.name());
            ps.setString(4, "Spell");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
