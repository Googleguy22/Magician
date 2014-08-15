// GUI.java
// Written by Paul Jang

package magician_agent;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GUI {
    
    public GUI() {
        f = new JFrame("Magician Agent");
        f.setVisible(true);
        f.setLocation(600, 300);
        f.setSize(500, 420);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TabbedPane = new JTabbedPane();
        f.add(TabbedPane);
        tabbedPane();
    }
    
    private void tabbedPane() {
        
        schedule_tab();
        TabbedPane.addTab("<html><b>Schedule</b></html>", Schedule_Pane);
        
        status_tab();
        TabbedPane.addTab("<html><b>Status</b></html>", Status_Pane);
        
        TabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(!Button_Group.isSelected(null))
                {
                    Button_Group.clearSelection();
                    Status_Pane.remove(Show_Status);
                }
                Status_Pane.updateUI();
                
            }
        });
    }
    
    void schedule_tab() {
        SelectionPanel();
        Schedule_Pane = new JPanel();
        GroupLayout Schedule_PaneLayout = new GroupLayout(Schedule_Pane);
        Schedule_Pane.setLayout(Schedule_PaneLayout);
        Schedule_PaneLayout.setHorizontalGroup(
                Schedule_PaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(Selection_Panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Schedule_PaneLayout.setVerticalGroup(
                Schedule_PaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(Schedule_PaneLayout.createSequentialGroup()
                        .addComponent(Selection_Panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 271, Short.MAX_VALUE))
        );
    }
    
    void SelectionPanel() {
        Scheduling_Options = new JComboBox();
        Scheduling_Options.setModel(new DefaultComboBoxModel(new String[]{"Add Holiday", "Add Magician", "Drop Magician", "Schedule Customer", "Cancel Customer"}));
        Selection_Panel = new JPanel();
        GroupLayout Selection_PanelLayout = new GroupLayout(Selection_Panel);
        Selection_Panel.setLayout(Selection_PanelLayout);
        Selection_PanelLayout.setHorizontalGroup(
                Selection_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, Selection_PanelLayout.createSequentialGroup()
                        .addContainerGap(188, Short.MAX_VALUE)
                        .addComponent(Scheduling_Options, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                        .addGap(187, 187, 187))
        );
        Selection_PanelLayout.setVerticalGroup(
                Selection_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(Selection_PanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(Scheduling_Options, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Scheduling_Options.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cust_name = Scheduling_Options.getSelectedItem().toString();
                switch (cust_name) {
                    case "Add Holiday":
                        Schedule_Pane.removeAll();
                        AddHolidayPanel();
                        Schedule_Pane.updateUI();
                        break;
                    case "Add Magician":
                        Schedule_Pane.removeAll();
                        AddMagicianPanel();
                        Schedule_Pane.updateUI();
                        break;
                    case "Drop Magician":
                        Schedule_Pane.removeAll();
                        DropMagicianPanel();
                        Schedule_Pane.updateUI();
                        break;
                    case "Schedule Customer":
                        Schedule_Pane.removeAll();
                        ScheduleCustomerPanel();
                        Schedule_Pane.updateUI();
                        break;
                    case "Cancel Customer":
                        Schedule_Pane.removeAll();
                        CancelCustomerPanel();
                        Schedule_Pane.updateUI();
                        break;
                }
            }
        });
    }
    
    void AddHolidayPanel() {
        AddHoliday();
        GroupLayout Schedule_PaneLayout = new GroupLayout(Schedule_Pane);
        Schedule_Pane.setLayout(Schedule_PaneLayout);
        Schedule_PaneLayout.setHorizontalGroup(
                Schedule_PaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(Selection_Panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Add_Holiday_Panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Schedule_PaneLayout.setVerticalGroup(
                Schedule_PaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(Schedule_PaneLayout.createSequentialGroup()
                        .addComponent(Selection_Panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Add_Holiday_Panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
        );
    }
    
    void AddHoliday() {
        Add_Holiday_Panel = new JPanel();
        Add_Holiday_Button = new JButton();
        Add_Holiday_Label = new JLabel();
        Add_Holiday_Textfield = new JTextField();
        Add_Holiday_Label.setText("<html><b>Enter Holiday Name to be Added</b></html>");
        Add_Holiday_Button.setText("<html><b>Add</b></html>");
        GroupLayout Add_Holiday_PanelLayout = new GroupLayout(Add_Holiday_Panel);
        Add_Holiday_Panel.setLayout(Add_Holiday_PanelLayout);
        Add_Holiday_PanelLayout.setHorizontalGroup(
                Add_Holiday_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(Add_Holiday_PanelLayout.createSequentialGroup()
                        .addGroup(Add_Holiday_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(Add_Holiday_PanelLayout.createSequentialGroup()
                                        .addGap(156, 156, 156)
                                        .addComponent(Add_Holiday_Label, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(Add_Holiday_PanelLayout.createSequentialGroup()
                                        .addGap(205, 205, 205)
                                        .addGroup(Add_Holiday_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(Add_Holiday_Textfield)
                                                .addComponent(Add_Holiday_Button, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Add_Holiday_PanelLayout.setVerticalGroup(
                Add_Holiday_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(Add_Holiday_PanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(Add_Holiday_Label, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Add_Holiday_Textfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(Add_Holiday_Button)
                        .addContainerGap(118, Short.MAX_VALUE))
        );
        Add_Holiday_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String holiday_name = Add_Holiday_Textfield.getText();
                if (holiday_name.length() > 0) {
                    Holiday holiday = new Holiday();
                    holiday.setHoliday(holiday_name);
                    Add_Holiday_Textfield.setText("");
                }
            }
        });
    }
    
    void AddMagicianPanel() {
        AddMagician();
        GroupLayout Schedule_PaneLayout = new GroupLayout(Schedule_Pane);
        Schedule_Pane.setLayout(Schedule_PaneLayout);
        Schedule_PaneLayout.setHorizontalGroup(
                Schedule_PaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(Selection_Panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Add_Magician_Panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Schedule_PaneLayout.setVerticalGroup(
                Schedule_PaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(Schedule_PaneLayout.createSequentialGroup()
                        .addComponent(Selection_Panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Add_Magician_Panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
        );
    }
    
    void AddMagician() {
        Add_Magician_Panel = new JPanel();
        Add_Magician_Button = new JButton();
        Add_Magician_Label = new JLabel();
        Add_Magician_Textfield = new JTextField();
        Add_Magician_Label.setText("<html><b>Enter Magician Name to be Added</b></html>");
        Add_Magician_Button.setText("<html><b>Add</b></html>");
        GroupLayout Add_Magician_PanelLayout = new GroupLayout(Add_Magician_Panel);
        Add_Magician_Panel.setLayout(Add_Magician_PanelLayout);
        Add_Magician_PanelLayout.setHorizontalGroup(
                Add_Magician_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(Add_Magician_PanelLayout.createSequentialGroup()
                        .addGroup(Add_Magician_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(Add_Magician_PanelLayout.createSequentialGroup()
                                        .addGap(156, 156, 156)
                                        .addComponent(Add_Magician_Label, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(Add_Magician_PanelLayout.createSequentialGroup()
                                        .addGap(205, 205, 205)
                                        .addGroup(Add_Magician_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(Add_Magician_Textfield)
                                                .addComponent(Add_Magician_Button, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Add_Magician_PanelLayout.setVerticalGroup(
                Add_Magician_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(Add_Magician_PanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(Add_Magician_Label, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Add_Magician_Textfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(Add_Magician_Button)
                        .addContainerGap(118, Short.MAX_VALUE))
        );
        Add_Magician_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String magician_name = Add_Magician_Textfield.getText();
                if (magician_name.length() > 0) {
                    Magician magician = new Magician();
                    magician.setMagician(magician_name);
                    Add_Magician_Textfield.setText("");
                    Waitlist waitlist = new Waitlist();
                    waitlist.checkWaitlist("");
                }
            }
        });
    }
    
    void DropMagicianPanel() {
        DropMagician();
        GroupLayout Schedule_PaneLayout = new GroupLayout(Schedule_Pane);
        Schedule_Pane.setLayout(Schedule_PaneLayout);
        Schedule_PaneLayout.setHorizontalGroup(
                Schedule_PaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(Selection_Panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Drop_Magician_Panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Schedule_PaneLayout.setVerticalGroup(
                Schedule_PaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(Schedule_PaneLayout.createSequentialGroup()
                        .addComponent(Selection_Panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Drop_Magician_Panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
        );
    }
    
    void DropMagician() {
        Drop_Magician_Panel = new JPanel();
        Drop_Magician_Button = new JButton();
        Drop_Magician_Label = new JLabel();
        Magician_List = new JComboBox();
        Drop_Magician_Label.setText("<html><b>Select Magician to Drop</b></html>");
        Magician magician = new Magician();
        Magician_List.setModel(new DefaultComboBoxModel(magician.getMagicianNames()));
        Drop_Magician_Button.setText("<html><b>Drop</b></html>");
        
        GroupLayout Drop_Magician_PanelLayout = new GroupLayout(Drop_Magician_Panel);
        Drop_Magician_Panel.setLayout(Drop_Magician_PanelLayout);
        Drop_Magician_PanelLayout.setHorizontalGroup(
                Drop_Magician_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(Drop_Magician_PanelLayout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Drop_Magician_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.TRAILING, Drop_Magician_PanelLayout.createSequentialGroup()
                                        .addComponent(Drop_Magician_Label, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(178, 178, 178))
                                .addGroup(GroupLayout.Alignment.TRAILING, Drop_Magician_PanelLayout.createSequentialGroup()
                                        .addComponent(Magician_List, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addGap(193, 193, 193))
                                .addGroup(GroupLayout.Alignment.TRAILING, Drop_Magician_PanelLayout.createSequentialGroup()
                                        .addComponent(Drop_Magician_Button, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(214, 214, 214))))
        );
        Drop_Magician_PanelLayout.setVerticalGroup(
                Drop_Magician_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(Drop_Magician_PanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(Drop_Magician_Label, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Magician_List, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addComponent(Drop_Magician_Button, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
        );
        Drop_Magician_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String magician_name = Magician_List.getSelectedItem().toString();
                if (magician_name.length() > 0) {
                    Magician magician = new Magician();
                    magician.removeMagician(magician_name);
                    Magician_List.setModel(new DefaultComboBoxModel(magician.getMagicianNames()));
                    Schedule schedule = new Schedule();
                    schedule.checkSchedule(magician_name);
                }
            }
        });
    }
    
    void ScheduleCustomerPanel() {
        ScheduleCustomer();
        GroupLayout Schedule_PaneLayout = new GroupLayout(Schedule_Pane);
        Schedule_Pane.setLayout(Schedule_PaneLayout);
        Schedule_PaneLayout.setHorizontalGroup(
                Schedule_PaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(Selection_Panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Schedule_Customer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Schedule_PaneLayout.setVerticalGroup(
                Schedule_PaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(Schedule_PaneLayout.createSequentialGroup()
                        .addComponent(Selection_Panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Schedule_Customer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );
    }
    
    void ScheduleCustomer() {
        Schedule_Customer = new JPanel();
        textfieldpanel();
        holidaylistpanel();
        schedulingpanel();
        GroupLayout Schedule_CustomerLayout = new GroupLayout(Schedule_Customer);
        Schedule_Customer.setLayout(Schedule_CustomerLayout);
        Schedule_CustomerLayout.setHorizontalGroup(
                Schedule_CustomerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(Schedule_CustomerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Schedule_CustomerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(textField_Panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(HolidayList_Panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Scheduling_Button_Panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
        );
        Schedule_CustomerLayout.setVerticalGroup(
                Schedule_CustomerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(Schedule_CustomerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(textField_Panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HolidayList_Panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Scheduling_Button_Panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
        );
    }
    
    void textfieldpanel() {
        textField_Panel = new JPanel();
        Schdule_Customer_Label1 = new JLabel();
        Schdule_Customer_Label1.setText("<html><b>Enter Customer Name</b></html>");
        Customer_Name = new JTextField();
        GroupLayout textField_PanelLayout = new GroupLayout(textField_Panel);
        textField_Panel.setLayout(textField_PanelLayout);
        textField_PanelLayout.setHorizontalGroup(
                textField_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, textField_PanelLayout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(textField_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(textField_PanelLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(Customer_Name, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                                .addGroup(GroupLayout.Alignment.TRAILING, textField_PanelLayout.createSequentialGroup()
                                        .addComponent(Schdule_Customer_Label1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(174, 174, 174))))
        );
        textField_PanelLayout.setVerticalGroup(
                textField_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(textField_PanelLayout.createSequentialGroup()
                        .addComponent(Schdule_Customer_Label1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Customer_Name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(18, Short.MAX_VALUE))
        );
    }
    
    void holidaylistpanel() {
        Holiday_List = new JComboBox();
        Schdule_Customer_Label2 = new JLabel();
        Schdule_Customer_Label2.setText("<html><b>Pick a Holiday</b></html>");
        Holiday holiday = new Holiday();
        Holiday_List.setModel(new DefaultComboBoxModel(holiday.getHolidayNames()));
        HolidayList_Panel = new JPanel();
        GroupLayout HolidayList_PanelLayout = new GroupLayout(HolidayList_Panel);
        HolidayList_Panel.setLayout(HolidayList_PanelLayout);
        HolidayList_PanelLayout.setHorizontalGroup(
                HolidayList_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(HolidayList_PanelLayout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(HolidayList_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.TRAILING, HolidayList_PanelLayout.createSequentialGroup()
                                        .addComponent(Schdule_Customer_Label2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(198, 198, 198))
                                .addGroup(GroupLayout.Alignment.TRAILING, HolidayList_PanelLayout.createSequentialGroup()
                                        .addComponent(Holiday_List, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                        .addGap(182, 182, 182))))
        );
        HolidayList_PanelLayout.setVerticalGroup(
                HolidayList_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(HolidayList_PanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Schdule_Customer_Label2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Holiday_List, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(35, Short.MAX_VALUE))
        );
    }
    
    void schedulingpanel() {
        Scheduling_Button_Panel = new JPanel();
        Scheduling_Button = new JButton();
        Scheduling_Button.setText("<html><b>Schedule</b></html>");
        
        GroupLayout Scheduling_Button_PanelLayout = new GroupLayout(Scheduling_Button_Panel);
        Scheduling_Button_Panel.setLayout(Scheduling_Button_PanelLayout);
        Scheduling_Button_PanelLayout.setHorizontalGroup(
                Scheduling_Button_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(Scheduling_Button_PanelLayout.createSequentialGroup()
                        .addGap(175)
                        .addComponent(Scheduling_Button, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Scheduling_Button_PanelLayout.setVerticalGroup(
                Scheduling_Button_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, Scheduling_Button_PanelLayout.createSequentialGroup()
                        .addContainerGap(50, Short.MAX_VALUE)
                        .addComponent(Scheduling_Button, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );
        Scheduling_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cust_name = Customer_Name.getText();
                if (cust_name.length() > 0) {
                    Schedule schedule = new Schedule();
                    schedule.SetSchedule(cust_name, Holiday_List.getSelectedItem().toString());
                    Customer_Name.setText("");
                }
            }
        });
        
    }
    
    void CancelCustomerPanel() {
        CancelCustomer();
        javax.swing.GroupLayout Schedule_PaneLayout = new javax.swing.GroupLayout(Schedule_Pane);
        Schedule_Pane.setLayout(Schedule_PaneLayout);
        Schedule_PaneLayout.setHorizontalGroup(
                Schedule_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Selection_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Cancellation_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Schedule_PaneLayout.setVerticalGroup(
                Schedule_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Schedule_PaneLayout.createSequentialGroup()
                        .addComponent(Selection_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cancellation_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
        );
    }
    
    void CancelCustomer() {
        Cancellation_Panel = new JPanel();
        Cancellation_Label1 = new JLabel();
        Cancellation_Customer_List = new JComboBox();
        Cancellation_Holiday_List = new JComboBox();
        Cancellation_Label2 = new JLabel();
        Cancellation_Button = new JButton();
        
        Cancellation_Label1.setText("<html><b>Select Holiday</b></html>");
        
        Holiday holiday = new Holiday();
        Cancellation_Holiday_List.setModel(new javax.swing.DefaultComboBoxModel(holiday.getHolidayNames()));
        
        Cancellation_Button.setText("<html><b>Unschedule</b></html>");
        Cancellation_Customer_List.setModel(new javax.swing.DefaultComboBoxModel(new String[]{""}));
        
        Cancellation_Label2.setText("<html><b>Select Customer</b></html>");
        
        javax.swing.GroupLayout Cancellation_PanelLayout = new javax.swing.GroupLayout(Cancellation_Panel);
        Cancellation_Panel.setLayout(Cancellation_PanelLayout);
        Cancellation_PanelLayout.setHorizontalGroup(
                Cancellation_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Cancellation_PanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Cancellation_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Cancellation_PanelLayout.createSequentialGroup()
                                        .addComponent(Cancellation_Label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(204, 204, 204))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Cancellation_PanelLayout.createSequentialGroup()
                                        .addGroup(Cancellation_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(Cancellation_Customer_List, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Cancellation_Holiday_List, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Cancellation_Label2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Cancellation_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(193, 193, 193))))
        );
        Cancellation_PanelLayout.setVerticalGroup(
                Cancellation_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Cancellation_PanelLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(Cancellation_Label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Cancellation_Holiday_List, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(Cancellation_Label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Cancellation_Customer_List, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(Cancellation_Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
        );
        
        Cancellation_Holiday_List.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer customer = new Customer();
                Cancellation_Customer_List.setModel(new javax.swing.DefaultComboBoxModel(customer.getCustomers(Cancellation_Holiday_List.getSelectedItem().toString())));
            }
        });
        
        Cancellation_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer customer = new Customer();
                customer.removeCustomer(Cancellation_Customer_List.getSelectedItem().toString(), Cancellation_Holiday_List.getSelectedItem().toString());
                Cancellation_Customer_List.setModel(new javax.swing.DefaultComboBoxModel(customer.getCustomers(Cancellation_Holiday_List.getSelectedItem().toString())));
                Waitlist waitlist = new Waitlist();
                waitlist.checkWaitlist(Cancellation_Holiday_List.getSelectedItem().toString());
            }
        });
    }
    
    void status_tab() {
        RadioButtons();
        Status_Pane = new JPanel();
        GroupLayout Status_PaneLayout = new GroupLayout(Status_Pane);
        Status_Pane.setLayout(Status_PaneLayout);
        Status_PaneLayout.setHorizontalGroup(
                Status_PaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(Status_PaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(RadioButton_Panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
        );
        Status_PaneLayout.setVerticalGroup(
                Status_PaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(Status_PaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(RadioButton_Panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(256, Short.MAX_VALUE))
        );
    }
    
    void RadioButtons() {
        RadioButton_Panel = new JPanel();
        Button_Group = new ButtonGroup();
        Holiday_Button = new JRadioButton();
        Magician_Button = new JRadioButton();
        Waitlist_Button = new JRadioButton();
        GroupLayout RadioButton_PanelLayout = new GroupLayout(RadioButton_Panel);
        RadioButton_Panel.setLayout(RadioButton_PanelLayout);
        RadioButton_PanelLayout.setHorizontalGroup(
                RadioButton_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(RadioButton_PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Holiday_Button)
                        .addGap(60)
                        .addComponent(Magician_Button)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                        .addComponent(Waitlist_Button)
                        .addContainerGap())
        );
        RadioButton_PanelLayout.setVerticalGroup(
                RadioButton_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(RadioButton_PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(RadioButton_PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(Holiday_Button)
                                .addComponent(Magician_Button)
                                .addComponent(Waitlist_Button))
                        .addContainerGap(25, Short.MAX_VALUE))
        );
        Button_Group.add(Holiday_Button);
        Holiday_Button.setText("Holiday Status");
        
        Button_Group.add(Magician_Button);
        Magician_Button.setText("Magician Status");
        
        Button_Group.add(Waitlist_Button);
        Waitlist_Button.setText("Waitlist Status");
        
        Holiday_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Status_Pane.removeAll();
                StatusPanel(1);
                Status_Pane.updateUI();
            }
        });
        Magician_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Status_Pane.removeAll();
                StatusPanel(2);
                Status_Pane.updateUI();
            }
        });
        Waitlist_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Status_Pane.removeAll();
                StatusPanel(3);
                Status_Pane.updateUI();
                textpane(3);
            }
        });
    }
    
    void StatusPanel(int choice) {
        if (choice == 1) {
            HolidayStatus();
        } else if (choice == 2) {
            MagicianStatus();
        } else if (choice == 3) {
            WaitlistStatus();
        }
        javax.swing.GroupLayout Status_PaneLayout = new javax.swing.GroupLayout(Status_Pane);
        Status_Pane.setLayout(Status_PaneLayout);
        Status_PaneLayout.setHorizontalGroup(
                Status_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Status_PaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Status_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Show_Status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(RadioButton_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
        );
        Status_PaneLayout.setVerticalGroup(
                Status_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Status_PaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(RadioButton_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Show_Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(21, Short.MAX_VALUE))
        );
    }
    
    void HolidayStatus() {
        Show_Status = new JPanel();
        Holiday_List = new JComboBox();
        TextArea = new JTextArea();
        jScrollPane1 = new JScrollPane();
        Holiday holiday = new Holiday();
        Holiday_List.setModel(new javax.swing.DefaultComboBoxModel(holiday.getHolidayNames()));
        
        TextArea.setColumns(20);
        TextArea.setRows(5);
        jScrollPane1.setViewportView(TextArea);
        
        javax.swing.GroupLayout Show_StatusLayout = new javax.swing.GroupLayout(Show_Status);
        Show_Status.setLayout(Show_StatusLayout);
        Show_StatusLayout.setHorizontalGroup(
                Show_StatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Show_StatusLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(Holiday_List, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );
        Show_StatusLayout.setVerticalGroup(
                Show_StatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Show_StatusLayout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(Holiday_List, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(125, Short.MAX_VALUE))
                .addGroup(Show_StatusLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
        );
        
        Holiday_List.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textpane(1);
            }
        });
    }
    
    void MagicianStatus() {
        Show_Status = new JPanel();
        Magician_List = new JComboBox();
        TextArea = new JTextArea();
        jScrollPane1 = new JScrollPane();
        Magician magician = new Magician();
        Magician_List.setModel(new javax.swing.DefaultComboBoxModel(magician.getMagicianNames()));
        
        TextArea.setColumns(20);
        TextArea.setRows(5);
        jScrollPane1.setViewportView(TextArea);
        
        javax.swing.GroupLayout Show_StatusLayout = new javax.swing.GroupLayout(Show_Status);
        Show_Status.setLayout(Show_StatusLayout);
        Show_StatusLayout.setHorizontalGroup(
                Show_StatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Show_StatusLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(Magician_List, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );
        Show_StatusLayout.setVerticalGroup(
                Show_StatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Show_StatusLayout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(Magician_List, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(125, Short.MAX_VALUE))
                .addGroup(Show_StatusLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
        );
        
        Magician_List.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textpane(2);
            }
        });
    }
    
    void WaitlistStatus() {
        Show_Status = new JPanel();
        TextArea = new JTextArea();
        jScrollPane1 = new JScrollPane();
        
        TextArea.setColumns(20);
        TextArea.setRows(5);
        jScrollPane1.setViewportView(TextArea);
        
        javax.swing.GroupLayout Show_StatusLayout = new javax.swing.GroupLayout(Show_Status);
        Show_Status.setLayout(Show_StatusLayout);
        Show_StatusLayout.setHorizontalGroup(
                Show_StatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Show_StatusLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))
        );
        Show_StatusLayout.setVerticalGroup(
                Show_StatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Show_StatusLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))
        );
    }
    
    void textpane(int status_choice) {
        TextArea.setText("");
        ArrayList<ArrayList<String>> someArray = new ArrayList<ArrayList<String>>();
        switch (status_choice) {
            case 1:
                Schedule schedule1 = new Schedule();
                someArray = schedule1.GetSchedule(status_choice, Holiday_List.getSelectedItem().toString());
                TextArea.append("Customer\t\tMagician\n");
                TextArea.append("--------------------------------------------------------------\n");
                break;
            case 2:
                Schedule schedule2 = new Schedule();
                someArray = schedule2.GetSchedule(status_choice, Magician_List.getSelectedItem().toString());
                TextArea.append("Customer\t\tHoliday\n");
                TextArea.append("--------------------------------------------------------------\n");
                break;
            case 3:
                Waitlist waitlist = new Waitlist();
                someArray = waitlist.GetSchedule();
                TextArea.append("Customer\t\tHoliday\n");
                TextArea.append("--------------------------------------------------------------\n");
                break;
            
        }
        //Make sure at least 1 list to avoid a null reference on the next line
        if (someArray.size() > 0) {
            //Assuming that all the nested lists are the same length
            for (int i = 0; i < someArray.size(); i++) {
                ArrayList<String> sublist = new ArrayList<String>();
                sublist = someArray.get(i);
                for (int j = 0; j < sublist.size(); j++) {
                    if (sublist.get(j).length() <= 10) {
                        TextArea.append(sublist.get(j) + "\t\t");
                    } else {
                        TextArea.append(sublist.get(j) + "\t");
                    }
                }
                TextArea.append("\n");
            }
        }
    }

    private JButton Add_Holiday_Button;
    private JLabel Add_Holiday_Label;
    private JPanel Add_Holiday_Panel;
    private JTextField Add_Holiday_Textfield;
    private JButton Add_Magician_Button;
    private JLabel Add_Magician_Label;
    private JPanel Add_Magician_Panel;
    private JTextField Add_Magician_Textfield;
    private ButtonGroup Button_Group;
    private JButton Cancellation_Button;
    private JComboBox Cancellation_Customer_List;
    private JComboBox Cancellation_Holiday_List;
    private JLabel Cancellation_Label1;
    private JLabel Cancellation_Label2;
    private JPanel Cancellation_Panel;
    private JTextField Customer_Name;
    private JButton Drop_Magician_Button;
    private JLabel Drop_Magician_Label;
    private JComboBox Magician_List;
    private JPanel Drop_Magician_Panel;
    private JPanel HolidayList_Panel;
    private JRadioButton Holiday_Button;
    private JComboBox Holiday_List;
    private JRadioButton Magician_Button;
    private JPanel RadioButton_Panel;
    private JLabel Schdule_Customer_Label1;
    private JLabel Schdule_Customer_Label2;
    private JPanel Schedule_Customer;
    private JPanel Schedule_Pane;
    private JButton Scheduling_Button;
    private JPanel Scheduling_Button_Panel;
    private JComboBox Scheduling_Options;
    private JPanel Selection_Panel;
    private JPanel Show_Status;
    private JPanel Status_Pane;
    private JTabbedPane TabbedPane;
    private JTextArea TextArea;
    private JRadioButton Waitlist_Button;
    private JPanel textField_Panel;
    private JScrollPane jScrollPane1;
    private JFrame f;         
}
