/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricity.billing.system;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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
        Image loginImage = loginIcon.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        loginButton = new JButton("Login", new ImageIcon(loginImage));
        loginButton.setBounds(330, 160, 100, 20);
        this.add(loginButton);
        
        ImageIcon cancelIcon = new ImageIcon(Login.class.getResource("icon/cancel.jpg"));
        Image cancelImage = cancelIcon.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        cancelButton = new JButton("Cancel",new ImageIcon(cancelImage));
        cancelButton.setBounds(450, 160, 100, 20);
        this.add(cancelButton);
        
        ImageIcon signupIcon = new ImageIcon(Login.class.getResource("icon/pop.png"));
        Image signupImage = signupIcon.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        signupButton = new JButton("Signup",new ImageIcon(signupImage));
        signupButton.setBounds(380, 200, 130, 20);
        this.add(signupButton);
        
        ImageIcon profileIcon = new ImageIcon(Login.class.getResource("icon/second.jpg"));
        Image profileImage = profileIcon.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
        profileIcon = new ImageIcon(profileImage);
        leftImageLabel = new JLabel(profileIcon);
        leftImageLabel.setBounds(0, 0, 250, 250);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
     public static void main(String[] args){
        new Login().setVisible(true);
    }

}
