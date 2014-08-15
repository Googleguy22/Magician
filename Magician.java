// Magician.java
// Written by Paul Jang

package magician_agent;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

public class Magician extends Magician_Agent {

    private Vector<String> name;
    PreparedStatement pstatement;

    Magician() {
        name = new Vector<String>();
    }

    Vector<String> getMagicianNames() {
        try {
            String sql = "Select * from MAGICIAN_NAMES";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                name.add(rs.getString("NAMES"));
                System.out.println(name);
            }
        } catch (SQLException Ex) {
            Ex.printStackTrace();
        }
        return name;
    }

    void setMagician(String name) {
        try {
            String SQL_INSERT = "INSERT INTO MAGICIAN_NAMES (names)" + "VALUES (?)";
            pstatement = con.prepareStatement(SQL_INSERT);
            pstatement.setString(1, name);
            pstatement.executeUpdate();
        } catch (SQLException Ex) {
            Ex.printStackTrace();
        }
    }

    void removeMagician(String name) {
        try {
            String SQL_INSERT = "DELETE from MAGICIAN_NAMES where names = ?";
            pstatement = con.prepareStatement(SQL_INSERT);
            pstatement.setString(1, name);
            pstatement.executeUpdate();
        } catch (SQLException Ex) {
            Ex.printStackTrace();
        }
    }
}
