
package electricity.billing.system;

import java.sql.*;

/**
 * @author souma (SMIT)
 * @version v1.0
 * 
 */
public class Conn {
    private Connection c;
    private Statement s;
    
    private final String DATABASE_NAME = "ebs";
    private final String CONNECTION_URL = "jdbc:mysql:///"+DATABASE_NAME;
    private final String USER_NAME = "root";
    private final String PASSWORD = "Soumadip@1";
    
    public Conn(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(CONNECTION_URL,USER_NAME,PASSWORD);
            s = c.createStatement();
            System.out.println("Successfully connected with "+DATABASE_NAME+" database...!!!");
        } catch (ClassNotFoundException | SQLException ex) {
           ex.printStackTrace();
        }
        
    }
    
}
