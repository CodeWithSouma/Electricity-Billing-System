
package electricity.billing.system;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

/**
 * @author souma (SMIT)
 * @version v1.0
 *
 */

public class GenerateBill extends JFrame implements ActionListener{
    JLabel generateBillLabel, meterNumberLabel;
    JTextArea billTextArea;
    JButton generateBillButton;
    Choice monthChooser;
    JPanel panel;
    String meter;
    GenerateBill(String meter){
        this.meter = meter;
        setSize(500,900);
        setLayout(new BorderLayout());
        
        panel = new JPanel();
        
        generateBillLabel = new JLabel("Generate Bill");
        
        meterNumberLabel = new JLabel(meter);
        
        monthChooser = new Choice();
        monthChooser.add("January");
        monthChooser.add("February");
        monthChooser.add("March");
        monthChooser.add("April");
        monthChooser.add("May");
        monthChooser.add("June");
        monthChooser.add("July");
        monthChooser.add("August");
        monthChooser.add("September");
        monthChooser.add("October");
        monthChooser.add("November");
        monthChooser.add("December");

        
        billTextArea = new JTextArea(50,15);
        billTextArea.setText("\n\n\t------- Click on the -------\n\t Generate Bill Button to get\n\tthe bill of the Selected Month\n\n");
        billTextArea.setFont(new Font("Senserif",Font.ITALIC,18));
        JScrollPane scrollPane = new JScrollPane(billTextArea);
        
        generateBillButton = new JButton("Generate Bill");
        
        panel.add(generateBillLabel);
        panel.add(meterNumberLabel);
        panel.add(monthChooser);
        add(panel,"North");
        add(scrollPane,"Center");
        add(generateBillButton,"South");
        
        generateBillButton.addActionListener(this);
        
        setLocation(750,100);
    }
    @Override
    public void actionPerformed(ActionEvent events){
        try{
            Conn connection = new Conn();
   
            String month = monthChooser.getSelectedItem();
            billTextArea.setText("\tWest Bengal State Electricity Distribution Company Limited\nELECTRICITY BILL FOR THE MONTH OF "+month+" ,2021\n\n\n");
            
            ResultSet resultSet = connection.statement.executeQuery("select * from customer where meter="+meter);
            
            if(resultSet.next()){
                billTextArea.append("\n    Customer Name:     "+resultSet.getString("name"));
                billTextArea.append("\n    Meter Number:      "+resultSet.getString("meter"));
                billTextArea.append("\n    Address:           "+resultSet.getString("address"));
                billTextArea.append("\n    State:             "+resultSet.getString("state"));
                billTextArea.append("\n    City:              "+resultSet.getString("city"));
                billTextArea.append("\n    Email:             "+resultSet.getString("email"));
                billTextArea.append("\n    Phone Number:      "+resultSet.getString("phone"));
                billTextArea.append("\n-------------------------------------------------------------");
                billTextArea.append("\n");
            }
            
            resultSet = connection.statement.executeQuery("select * from meter_info where meter_number = " + meter);
            
            if(resultSet.next()){
                billTextArea.append("\n    Meter Location:    "+resultSet.getString("meter_location"));
                billTextArea.append("\n    Meter Type:        "+resultSet.getString("meter_type"));
                billTextArea.append("\n    Phase Code:        "+resultSet.getString("phase_code"));
                billTextArea.append("\n    Bill Type:         "+resultSet.getString("bill_type"));
                billTextArea.append("\n    Days:              "+resultSet.getString("days"));
                billTextArea.append("\n");
            }
            resultSet = connection.statement.executeQuery("select * from tax");
            if(resultSet.next()){
                billTextArea.append("---------------------------------------------------------------");
                billTextArea.append("\n\n");
                billTextArea.append("\n    Cost per Unit:             Rs "+resultSet.getString("cost_per_unit"));
                billTextArea.append("\n    Meter Rent:                Rs "+resultSet.getString("meter_rent"));
                billTextArea.append("\n    Service Charge:            Rs "+resultSet.getString("service_charge"));
                billTextArea.append("\n    Service Tax:               Rs "+resultSet.getString("service_tax"));
                billTextArea.append("\n    Swacch Bharat Cess:        Rs "+resultSet.getString("swacch_bharat_cess"));
                billTextArea.append("\n    Fixed Tax:                 Rs "+resultSet.getString("fixed_tax"));
                billTextArea.append("\n");
                
            }
            
            resultSet = connection.statement.executeQuery("select * from bill where meter="+meter+" AND month = '"+monthChooser.getSelectedItem()+"'");
            
            if(resultSet.next()){
                billTextArea.append("\n    Current Month :\t"+resultSet.getString("month"));
                billTextArea.append("\n    Units Consumed:\t"+resultSet.getString("units"));
                billTextArea.append("\n    Total Charges :\t"+resultSet.getString("total_bill"));
                billTextArea.append("\n---------------------------------------------------------------");
                billTextArea.append("\n    TOTAL PAYABLE :\t"+resultSet.getString("total_bill"));
            }
            
            
            
            
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new GenerateBill("").setVisible(true);
    }
}
