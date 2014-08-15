// Schedule.java
// Written by Paul Jang

package magician_agent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

public class Schedule extends Magician_Agent {

    Connection con2;
    ArrayList<ArrayList<String>> arr;
    PreparedStatement pstatement = null;
    ResultSet rs_magician;
    Vector<String> name;

    Schedule() {
        arr = new ArrayList<ArrayList<String>>();
        name = new Vector<String>();
    }

    void SetSchedule(String customer_name, String holiday) {
        try {
            String sql = "Select * from SCHEDULE_LIST";

            pstatement = con.prepareStatement(" SELECT Names FROM Magician_names WHERE Names not in (SELECT Magician FROM Schedule_list WHERE Holiday = ?)");
            pstatement.setString(1, holiday);;

            rs_magician = pstatement.executeQuery();
            if (rs_magician.next()) {
                String availMagician = rs_magician.getString(1);
                Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
                String SQL_INSERT = "INSERT INTO SCHEDULE_LIST (Customer_name,magician,holiday,timeStamp)" + "VALUES (?,?,?,?)";
                PreparedStatement pstatement2 = con.prepareStatement(SQL_INSERT);
                pstatement2.setString(1, customer_name);
                pstatement2.setString(2, availMagician);
                pstatement2.setString(3, holiday);
                pstatement2.setTimestamp(4, currentTimestamp);
                pstatement2.executeUpdate();
            } else {
                Waitlist wl = new Waitlist();
                wl.SetWaitlist(customer_name, holiday);
            }
        } catch (SQLException Ex) {
            Ex.printStackTrace();
        }
    }

    ArrayList<ArrayList<String>> GetSchedule(int choice, String select) {

        switch (choice) {
            case 1:
                try {
                    pstatement = con.prepareStatement("Select * from SCHEDULE_LIST where HOLIDAY = ?");
                    int i = 0;
                    pstatement.setString(1, select);
                    rs = pstatement.executeQuery();
                    while (rs.next()) {
                        arr.add(new ArrayList<String>());
                        arr.get(i).add(rs.getString("CUSTOMER_NAME"));
                        arr.get(i).add(rs.getString("MAGICIAN"));
                        i++;
                    }
                } catch (SQLException Ex) {
                    Ex.printStackTrace();
                }
                break;
            case 2:
                try {
                    pstatement = con.prepareStatement("Select * from SCHEDULE_LIST where MAGICIAN = ?");
                    int i = 0;
                    pstatement.setString(1, select);
                    rs = pstatement.executeQuery();
                    while (rs.next()) {
                        arr.add(new ArrayList<String>());
                        arr.get(i).add(rs.getString("CUSTOMER_NAME"));
                        arr.get(i).add(rs.getString("HOLIDAY"));
                        i++;
                    }
                } catch (SQLException Ex) {
                    Ex.printStackTrace();
                }
                break;
        }
        return arr;
    }

    void checkSchedule(String Magician) {
        try {
            int i = 0;
            pstatement = con.prepareStatement("Select * from Schedule_list where magician = ?");
            pstatement.setString(1, Magician);
            rs = pstatement.executeQuery();
            while (rs.next()) {
                arr.add(new ArrayList<String>());
                arr.get(i).add(rs.getString("CUSTOMER_NAME"));
                arr.get(i).add(rs.getString("HOLIDAY"));
                i++;
            }
            Waitlist waitlist = new Waitlist();
            Customer customer = new Customer();
            for (i = 0; i < arr.size(); i++) {
                ArrayList<String> sublist = new ArrayList<String>();
                sublist = arr.get(i);
                customer.removeCustomer(sublist.get(0), sublist.get(1));
                waitlist.SetWaitlist(sublist.get(0), sublist.get(1));
            }
        } catch (SQLException Ex) {
            Ex.printStackTrace();
        }
    }
}
