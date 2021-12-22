package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Monstercard extends Card {
    private Monstertype monstertype;

    public Monstercard(Elementtype elementtype, Monstertype monstertype, int damage){
        this.elementtype = elementtype;
        this.monstertype = monstertype;
        this.damage = damage;
        getName();
    }

    public void getName(){
        if(elementtype != Elementtype.Fire && elementtype != Elementtype.Water){
            name = monstertype + ""; // normal monster
        } else {
            name = elementtype + "" + monstertype;
        }

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
            ps.setString(4, this.monstertype.name());
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
