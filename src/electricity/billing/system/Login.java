package electricity.billing.system;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author souma (SMIT)
 * @version v1.0
 *
 */
public class Login extends JFrame implements ActionListener {

    JLabel usernameLabel, passwordLabel,userTypeLabel,leftImageLabel;
    JTextField usernameTextField;
    JPasswordField passwordField;
    JButton loginButton, cancelButton, signupButton;
    Choice choice;

    public Login() {
        initComponent();
    }

    private void initComponent() {
        this.setTitle("Login Page");
        getContentPane().setBackground(Color.WHITE);
        
        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(300, 20, 100, 20);
        this.add(usernameLabel);
        
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(300, 60, 100, 20);
        this.add(passwordLabel);
        
        usernameTextField = new JTextField(15);
        usernameTextField.setBounds(400, 20, 150, 20);
        this.add(usernameTextField);
        
        passwordField = new JPasswordField(15);
        passwordField.setBounds(400, 60, 150, 20);
        this.add(passwordField);
        
        userTypeLabel = new JLabel("Login as ");
        userTypeLabel.setBounds(300, 100, 100, 20);
        this.add(userTypeLabel);
        
        choice = new Choice();
        choice.add("Admin");
        choice.add("Customer");
        choice.setBounds(400, 100, 150, 20);
        this.add(choice);
        
        ImageIcon loginIcon = new ImageIcon(Login.class.getResource("icon/login.png"));
        Image loginImage = loginIcon.getImage().getScaledInstance(16, 16,Image.SCALE_SMOOTH);
        loginButton = new JButton("Login", new ImageIcon(loginImage));
        loginButton.setBounds(330, 160, 110, 25);
        this.add(loginButton);
        
        ImageIcon cancelIcon = new ImageIcon(Login.class.getResource("icon/cancel.jpg"));
        Image cancelImage = cancelIcon.getImage().getScaledInstance(16, 16,Image.SCALE_SMOOTH);
        cancelButton = new JButton("Cancel",new ImageIcon(cancelImage));
        cancelButton.setBounds(450, 160, 110, 25);
        this.add(cancelButton);
        
        ImageIcon signupIcon = new ImageIcon(Login.class.getResource("icon/user.png"));
        Image signupImage = signupIcon.getImage().getScaledInstance(16, 16,Image.SCALE_SMOOTH);
        signupButton = new JButton("Signup",new ImageIcon(signupImage));
        signupButton.setBounds(380, 200, 110, 25);
        this.add(signupButton);
        
        ImageIcon profileIcon = new ImageIcon(Login.class.getResource("icon/login_banner.png"));
        Image profileImage = profileIcon.getImage().getScaledInstance(200, 200,Image.SCALE_SMOOTH);
        profileIcon = new ImageIcon(profileImage);
        leftImageLabel = new JLabel(profileIcon);
        leftImageLabel.setBounds(5, 5, 250, 250);
        this.add(leftImageLabel);
        
        loginButton.addActionListener(this);
        signupButton.addActionListener(this);
        cancelButton.addActionListener(this);
        
        setLayout(new BorderLayout());
 
        setSize(640,300);
        setLocation(600,300);
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
          if(ae.getSource() == loginButton){
            try{        
                Conn conn = new Conn();
                String username  = usernameTextField.getText();
                String password  = passwordField.getText();
                String user = choice.getSelectedItem();
                String query  = "select * from login where username = '"+username+"' and password = '"+password+"' and user = '"+user+"'";
                ResultSet resultSet = conn.statement.executeQuery(query);
                if(resultSet.next()){
                    String meter = resultSet.getString("meter_no");
                    new Dashboard(meter, user).setVisible(true);
                    this.setVisible(false);

                }else{
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    usernameTextField.setText("");
                    passwordField.setText("");
                }
            }catch(HeadlessException | SQLException e){
                System.out.println("error: "+e);
            }
        }else if(ae.getSource() == cancelButton){
            this.setVisible(false);
        }else if(ae.getSource() == signupButton){
              this.dispose();
            new Signup().setVisible(true);
            
        }
    }
    
    
     public static void main(String[] args){
        new Login().setVisible(true);
    }

}
