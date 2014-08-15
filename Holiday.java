// Holiday.java
// Written by Paul Jang

package magician_agent;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

public class Holiday extends Magician_Agent {

    private Vector<String> name;
    PreparedStatement pstatement;

    Holiday() {
        name = new Vector<String>();
    }

    Vector<String> getHolidayNames() {
        try {
            String sql = "Select * from HOLIDAY_LIST";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                name.add(rs.getString("EVENT_NAME"));
                System.out.println(name);
            }
        } catch (SQLException Ex) {
            Ex.printStackTrace();
        }
        return name;
    }

    void setHoliday(String name) {
        try {
            String SQL_INSERT = "INSERT INTO holiday_list (event_name)" + "VALUES (?)";
            pstatement = con.prepareStatement(SQL_INSERT);
            pstatement.setString(1, name);
            pstatement.executeUpdate();
        } catch (SQLException Ex) {
            Ex.printStackTrace();
        }
    }
}
