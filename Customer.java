// Customer.java
// Written by Paul Jang

package magician_agent;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

public class Customer extends Magician_Agent {

    private Vector<String> name;
    PreparedStatement pstatement;

    Customer() {
        name = new Vector<String>();
    }

    Vector<String> getCustomers(String holiday) {
        try {
            pstatement = con.prepareStatement("Select * from SCHEDULE_LIST where HOLIDAY = ?");
            pstatement.setString(1, holiday);
            rs = pstatement.executeQuery();
            while (rs.next()) {
                name.add(rs.getString("CUSTOMER_NAME"));
            }
            pstatement = con.prepareStatement("Select * from Waitlist where HOLIDAY = ?");
            pstatement.setString(1, holiday);
            rs = pstatement.executeQuery();
            while (rs.next()) {
                name.add(rs.getString("CUSTOMER_NAME"));
            }
        } catch (SQLException Ex) {
            Ex.printStackTrace();
        }
        return name;
    }

    void removeCustomer(String name, String holiday) {
        try {
            String SQL_INSERT = "DELETE from schedule_list where customer_name = ? and holiday = ?";
            pstatement = con.prepareStatement(SQL_INSERT);
            pstatement.setString(1, name);
            pstatement.setString(2, holiday);
            pstatement.executeUpdate();
            SQL_INSERT = "DELETE from waitlist where customer_name = ? and holiday = ?";
            pstatement = con.prepareStatement(SQL_INSERT);
            pstatement.setString(1, name);
            pstatement.setString(2, holiday);
            pstatement.executeUpdate();
        } catch (SQLException Ex) {
            Ex.printStackTrace();
        }
    }
}
