// Waitlist.java
// Written by Paul Jang

package magician_agent;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

public class Waitlist extends Magician_Agent {

    ArrayList<ArrayList<String>> arr;
    PreparedStatement pstatement = null;
    Vector<String> name;

    Waitlist() {
        arr = new ArrayList<ArrayList<String>>();
        name = new Vector<String>();
    }

    ArrayList<ArrayList<String>> GetSchedule() {
        try {
            String sql = "Select * from WAITLIST";
            int i = 0;
            rs = st.executeQuery(sql);
            while (rs.next()) {
                arr.add(new ArrayList<String>());
                arr.get(i).add(rs.getString("CUSTOMER_NAME"));
                arr.get(i).add(rs.getString("HOLIDAY"));
                i++;
            }
            rs.close();
            rs = st.executeQuery(sql);
        } catch (SQLException Ex) {
            Ex.printStackTrace();
        }
        return arr;
    }

    void SetWaitlist(String customer_name, String holiday) {
        try {
            Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
            String SQL_INSERT = "INSERT INTO WAITLIST (customer_name,holiday,timestamp)" + "VALUES (?,?,?)";
            PreparedStatement pstatement2 = con.prepareStatement(SQL_INSERT);
            pstatement2.setString(1, customer_name);
            pstatement2.setString(2, holiday);
            pstatement2.setTimestamp(3, currentTimestamp);
            pstatement2.executeUpdate();
        } catch (SQLException Ex) {
            Ex.printStackTrace();
        }
    }

    void checkWaitlist(String Holiday) {
        try {
            int i = 0;
            if (Holiday == "") {
                pstatement = con.prepareStatement("Select * from WAITLIST where HOLIDAY = ?");
                Holiday holiday = new Holiday();
                name = holiday.getHolidayNames();
                for (int j = 0; j < name.size(); j++) {
                    pstatement.setString(1, name.get(j));
                    rs = pstatement.executeQuery();
                    if (rs.next()) {
                        arr.add(new ArrayList<String>());
                        arr.get(i).add(rs.getString("CUSTOMER_NAME"));
                        arr.get(i).add(rs.getString("HOLIDAY"));
                        i++;
                    }
                }
            } else {
                pstatement = con.prepareStatement("Select * from WAITLIST where HOLIDAY = ?");
                pstatement.setString(1, Holiday);
                rs = pstatement.executeQuery();
                if (rs.next()) {
                    arr.add(new ArrayList<String>());
                    arr.get(i).add(rs.getString("CUSTOMER_NAME"));
                    arr.get(i).add(rs.getString("HOLIDAY"));
                    i++;
                }
            }
            Schedule schedule = new Schedule();
            Customer customer = new Customer();
            for (i = 0; i < arr.size(); i++) {
                ArrayList<String> sublist = new ArrayList<String>();
                sublist = arr.get(i);
                customer.removeCustomer(sublist.get(0), sublist.get(1));
                schedule.SetSchedule(sublist.get(0), sublist.get(1));
            }
        } catch (SQLException Ex) {
            Ex.printStackTrace();
        }
    }
}
