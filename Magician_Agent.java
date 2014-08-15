// Magician_Agent.java
// Written by Paul Jang

package magician_agent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Magician_Agent {

    Connection con;
    Statement st;
    ResultSet rs;

    public Magician_Agent() {
        connect();
    }

    public void connect() {
        try {

            con = DriverManager.getConnection("jdbc:derby://localhost:1527/Magician_Agent", "ryj5095", "chaterjee10");
            st = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_UPDATABLE);

        } catch (Exception Ex) {
            Ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Magician_Agent();
        GUI gui = new GUI();
    }
}
