
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class ViewInformation extends JFrame implements ActionListener{
    
    ViewInformation(String meter){
        setBounds(600,250, 850, 650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel headingLabel = new JLabel("VIEW CUSTOMER INFORMATION");
        headingLabel.setBounds(250, 0, 500, 40);
        headingLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(headingLabel);
        
        JLabel nameHeadingLabel = new JLabel("Name");
        nameHeadingLabel.setBounds(70, 80, 100, 20);
        add(nameHeadingLabel);
        
        JLabel nameLabel = new JLabel();
        nameLabel.setBounds(250, 80, 100, 20);
        add(nameLabel);
        
        JLabel meterNumberHeadingLabel = new JLabel("Meter Number");
        meterNumberHeadingLabel.setBounds(70, 140, 100, 20);
        add(meterNumberHeadingLabel);
        
        JLabel meterNumberLabel = new JLabel();
        meterNumberLabel.setBounds(250, 140, 100, 20);
        add(meterNumberLabel);
        
        JLabel addressHeadingLabel = new JLabel("Address");
        addressHeadingLabel.setBounds(70, 200, 100, 20);
        add(addressHeadingLabel);
        
        JLabel addressLabel = new JLabel();
        addressLabel.setBounds(250, 200, 100, 20);
        add(addressLabel);
        
        JLabel cityHeadingLabel = new JLabel("City");
        cityHeadingLabel.setBounds(70, 260, 100, 20);
        add(cityHeadingLabel);
        
        JLabel cityLabel = new JLabel();
        cityLabel.setBounds(250, 260, 100, 20);
        add(cityLabel);
        
        JLabel stateHeadingLabel = new JLabel("State");
        stateHeadingLabel.setBounds(500, 80, 100, 20);
        add(stateHeadingLabel);
        
        JLabel stateLabel = new JLabel();
        stateLabel.setBounds(650, 80, 100, 20);
        add(stateLabel);
        
        JLabel emailHeadingLabel = new JLabel("Email");
        emailHeadingLabel.setBounds(500, 140, 100, 20);
        add(emailHeadingLabel);
        
        JLabel emailLabel = new JLabel();
        emailLabel.setBounds(650, 140, 150, 20);
        add(emailLabel);
        
        JLabel phoneHeadingLabel = new JLabel("Phone");
        phoneHeadingLabel.setBounds(500, 200, 100, 20);
        add(phoneHeadingLabel);
        
        JLabel phoneLabel = new JLabel();
        phoneLabel.setBounds(650, 200, 100, 20);
        add(phoneLabel);
        
        try{
            Conn connection = new Conn();
            ResultSet resultSet = connection.statement.executeQuery("select * from customer where meter = '"+meter+"'");
            while(resultSet.next()){
                nameLabel.setText(resultSet.getString(1));
                meterNumberLabel.setText(resultSet.getString(2));
                addressLabel.setText(resultSet.getString(3));
                cityLabel.setText(resultSet.getString(4));
                stateLabel.setText(resultSet.getString(5));
                emailLabel.setText(resultSet.getString(6));
                phoneLabel.setText(resultSet.getString(7));
                
            }
        }catch(SQLException e){}
        
        JButton backButton;
        backButton = new JButton("Back");
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setBounds(350, 340, 100, 25);
        backButton.addActionListener(this);
        add(backButton);
        
        ImageIcon viewCustomerBannerIcon = new ImageIcon(ViewInformation.class.getResource("icon/viewcustomer.jpg"));
        Image viewCustomerBannerImage = viewCustomerBannerIcon.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        viewCustomerBannerIcon = new ImageIcon(viewCustomerBannerImage);
        JLabel viewCustomerBannerImageLabel  = new JLabel(viewCustomerBannerIcon);
        viewCustomerBannerImageLabel.setBounds(20, 350, 600, 300);
        add(viewCustomerBannerImageLabel);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        this.dispose();
    }
    
    public static void main(String[] args){
        new ViewInformation("").setVisible(true);
    }
}