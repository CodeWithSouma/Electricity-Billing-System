
package electricity.billing.system;

import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import javax.swing.*;
import java.sql.*;

/**
 * @author souma (SMIT)
 * @version v1.0
 *
 */

public class CustomerDetails extends JFrame implements ActionListener{
 
    JTable customerTable;
    JButton printButton;
    String x[] = {"Customer Name","Meter Number","Address","City","State","Email","Phone"};
    String y[][] = new String[40][8];
    int i=0, j=0;
    CustomerDetails(){
        super("Customer Details");
        setSize(1200,650);
        setLocation(400,150);
        
        try{
            Conn connection  = new Conn();
            String query = "select * from customer";
            ResultSet resultSet  = connection.statement.executeQuery(query);
            while(resultSet.next()){
                y[i][j++]=resultSet.getString("name");
                y[i][j++]=resultSet.getString("meter");
                y[i][j++]=resultSet.getString("address");
                y[i][j++]=resultSet.getString("city");
                y[i][j++]=resultSet.getString("state");
                y[i][j++]=resultSet.getString("email");
                y[i][j++]=resultSet.getString("phone");
                i++;
                j=0;
            }
            customerTable = new JTable(y,x);
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        
        printButton = new JButton("Print");
        add(printButton,"South");
        JScrollPane sp = new JScrollPane(customerTable);
        add(sp);
        printButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        try{
            customerTable.print();
        }catch(PrinterException e){}
    }
    
    public static void main(String[] args){
        new CustomerDetails().setVisible(true);
    }
    
}
