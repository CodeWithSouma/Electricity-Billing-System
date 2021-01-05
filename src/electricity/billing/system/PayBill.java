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

public class PayBill extends JFrame implements ActionListener{
    JLabel meterNoHeadingLabel,l2,monthLabel,unitsHeadingLabel,totalBillHeadingLabel, statusHeadingLabel;
    JLabel l11, l12, l13, l14, l15;
    JTextField t1;
    Choice monthChooser,c2;
    JButton payButton,backButton;
    String meter;
    PayBill(String meter){
        this.meter = meter;
        setLayout(null);
        
        setBounds(550, 220, 900, 600);
        
        JLabel headingLabel = new JLabel("Electricity Bill");
        headingLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        headingLabel.setBounds(120, 5, 400, 30);
        add(headingLabel);
        
        meterNoHeadingLabel = new JLabel("Meter No");
        meterNoHeadingLabel.setBounds(35, 80, 200, 20);
        add(meterNoHeadingLabel);
        
        JLabel meterNoLabel = new JLabel();
        meterNoLabel.setBounds(300, 80, 200, 20);
        add(meterNoLabel);
        
        JLabel nameHeadingLabel = new JLabel("Name");
        nameHeadingLabel.setBounds(35, 140, 200, 20);
        add(nameHeadingLabel);
        
        JLabel nameLabel = new JLabel();
        nameLabel.setBounds(300, 140, 200, 20);
        add(nameLabel);
        
        monthLabel = new JLabel("Month");
        monthLabel.setBounds(35, 200, 200, 20);
        add(monthLabel);
        
        monthChooser = new Choice();
        monthChooser.setBounds(300, 200, 200, 20);
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
        add(monthChooser);
        
        
        unitsHeadingLabel = new JLabel("Units");
        unitsHeadingLabel.setBounds(35, 260, 200, 20);
        add(unitsHeadingLabel);
        
        JLabel unitLabel = new JLabel();
        unitLabel.setBounds(300, 260, 200, 20);
        add(unitLabel);
        
        totalBillHeadingLabel = new JLabel("Total Bill");
        totalBillHeadingLabel.setBounds(35, 320, 200, 20);
        add(totalBillHeadingLabel);
        
        JLabel totalBillLabel = new JLabel();
        totalBillLabel.setBounds(300, 320, 200, 20);
        add(totalBillLabel);
        
        statusHeadingLabel = new JLabel("Status");
        statusHeadingLabel.setBounds(35, 380, 200, 20);
        add(statusHeadingLabel);
        
        JLabel statusLabel = new JLabel();
        statusLabel.setBounds(300, 380, 200, 20);
        statusLabel.setForeground(Color.RED);
        add(statusLabel);
        
        
        
        try{
            Conn connection = new Conn();
            ResultSet resultSet = connection.statement.executeQuery("select * from customer where meter = '"+meter+"'");
            while(resultSet.next()){
                meterNoLabel.setText(resultSet.getString("meter"));
                nameLabel.setText(resultSet.getString("name"));
            }
            resultSet = connection.statement.executeQuery("select * from bill where meter = '"+meter+"' AND month = 'January' ");
            while(resultSet.next()){
                unitLabel.setText(resultSet.getString("units"));
                totalBillLabel.setText(resultSet.getString("total_bill"));
                statusLabel.setText(resultSet.getString("status"));
            }
        }catch(SQLException e){}
        
        monthChooser.addItemListener((ItemEvent ae) -> {
            try{
                Conn connection = new Conn();
                ResultSet resultSet = connection.statement.executeQuery("select * from bill where meter = '"+meter+"' AND month = '"+monthChooser.getSelectedItem()+"'");
                while(resultSet.next()){
                    unitLabel.setText(resultSet.getString("units"));
                    totalBillLabel.setText(resultSet.getString("total_bill"));
                    statusLabel.setText(resultSet.getString("status"));
                }
            }catch(SQLException e){}
        });
        
        payButton = new JButton("Pay");
        payButton.setBounds(100, 460, 100, 25);
        add(payButton);
        
        backButton = new JButton("Back");
        backButton.setBounds(230, 460, 100, 25);
        add(backButton);
        
        payButton.setBackground(Color.BLACK);
        payButton.setForeground(Color.WHITE);
        payButton.addActionListener(this);
        
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        
        ImageIcon payBillIcon = new ImageIcon(PayBill.class.getResource("icon/bill.png"));
        Image payBillImage = payBillIcon.getImage().getScaledInstance(600, 300,Image.SCALE_DEFAULT);
        payBillIcon = new ImageIcon(payBillImage);
        JLabel payBillLabel = new JLabel(payBillIcon);
        payBillLabel.setBounds(400, 120, 600, 300);
        add(payBillLabel);      
        
        getContentPane().setBackground(Color.WHITE);        
    }
    
    @Override
    public void actionPerformed(ActionEvent events){
        if(events.getSource() == payButton){
            try{
                Conn connection = new Conn();
                connection.statement.executeQuery("update bill status = 'Paid' where meter = '"+meter+"' AND month = '"+monthChooser.getSelectedItem()+"'");
                
            }catch(SQLException e){}
            this.setVisible(false);
//            new Paytm(meter).setVisible(true);

        }else if(events.getSource()== backButton){
            this.setVisible(false);
        }        
    }
    
       
    public static void main(String[] args){
        new PayBill("").setVisible(true);
    }
}