package electricity.billing.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author souma (SMIT)
 * @version v1.0
 *
 */
public class Dashboard  extends JFrame implements ActionListener{
 


    String meter;
    Dashboard(String meter, String person){
        super("Electricity Billing System");
        this.meter = meter;
        
        setSize(1920,1030);
        
        /* Adding background image */
        ImageIcon backgroundImageIcon =  new ImageIcon(Dashboard.class.getResource("icon/elect1.jpg"));
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(1900, 950,Image.SCALE_DEFAULT);
        backgroundImageIcon = new ImageIcon(backgroundImage);
        JLabel backgroundImageLabel = new JLabel(backgroundImageIcon);
        add(backgroundImageLabel);
       
        /* First Column */
        JMenuBar menuBar  = new JMenuBar();
        JMenu master = new JMenu("Master");
        JMenuItem newCustomer = new JMenuItem("New Customer");
        JMenuItem customerDetails = new JMenuItem("Customer Details");
        JMenuItem depositDetails = new JMenuItem("Deposit Details");
        JMenuItem calculateBill = new JMenuItem("Calculate Bill");
        master.setForeground(Color.BLUE);
        
        
        /* ---- Customer Details ---- */
        newCustomer.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon newCustomerMenuIcon = new ImageIcon(Dashboard.class.getResource("icon/new_customer_menu_icon.png"));
        Image newCustomerImage = newCustomerMenuIcon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        newCustomer.setIcon(new ImageIcon(newCustomerImage));
        newCustomer.setMnemonic('D');
        newCustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        newCustomer.setBackground(Color.WHITE);
        
        /* ---- Meter Details ---- */
        customerDetails.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon customerDetailsMenuIcon = new ImageIcon(Dashboard.class.getResource("icon/customer_details_icon.png"));
        Image customerDetailsImage = customerDetailsMenuIcon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        customerDetails.setIcon(new ImageIcon(customerDetailsImage));
        customerDetails.setMnemonic('M');
        customerDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        customerDetails.setBackground(Color.WHITE);
        
         /* ---- Deposit Details  ----- */
        depositDetails.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon depositMenuIcon = new ImageIcon(Dashboard.class.getResource("icon/deposit_menu_icon.png"));
        Image depositIcon = depositMenuIcon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        depositDetails.setIcon(new ImageIcon(depositIcon));
        depositDetails.setMnemonic('N');
        depositDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        depositDetails.setBackground(Color.WHITE);
        
        calculateBill.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon calculateBillMenuIcon = new ImageIcon(Dashboard.class.getResource("icon/calculate_bill_menu_icon.png"));
        Image calculateBillMenuImage = calculateBillMenuIcon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        calculateBill.setIcon(new ImageIcon(calculateBillMenuImage));
        calculateBill.setMnemonic('B');
        calculateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        calculateBill.setBackground(Color.WHITE);
        
        
        newCustomer.addActionListener(this);
        customerDetails.addActionListener(this);
        depositDetails.addActionListener(this);
        calculateBill.addActionListener(this);
        
        
        
        //-----------------------------
        
        /* Second Column */
        JMenu info = new JMenu("Information");
        JMenuItem updateInfo = new JMenuItem("Update Information");
        JMenuItem viewInfo = new JMenuItem("View Information");
        
        info.setForeground(Color.RED);
        
        /* ---- Pay Bill ---- */
        updateInfo.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon updateInfoIcon = new ImageIcon(Dashboard.class.getResource("icon/update_info_icon.png"));
        Image updateInfoImage = updateInfoIcon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        updateInfo.setIcon(new ImageIcon(updateInfoImage));
        updateInfo.setMnemonic('P');
        updateInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        updateInfo.setBackground(Color.WHITE);
        
        /* ---- Last Bill ----*/
        viewInfo.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon viewInfoIcon = new ImageIcon(Dashboard.class.getResource("icon/view_info_icon.png"));
        Image viewInfoImage = viewInfoIcon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        viewInfo.setIcon(new ImageIcon(viewInfoImage));
        viewInfo.setMnemonic('L');
        viewInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        viewInfo.setBackground(Color.WHITE);
        
        updateInfo.addActionListener(this);
        viewInfo.addActionListener(this);
        
        
        
        
        
        // --------------------------------------------------------------------------------------------
        
        
        /* Second Column */
        JMenu user = new JMenu("User");
        JMenuItem payBill = new JMenuItem("Pay Bill");
        
        JMenuItem billDetails = new JMenuItem("Bill Details");
        user.setForeground(Color.RED);
        
        /* ---- Pay Bill ---- */
        payBill.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon payBillIcon = new ImageIcon(Dashboard.class.getResource("icon/update_info_icon.png"));
        Image payBillImage = payBillIcon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        payBill.setIcon(new ImageIcon(payBillImage));
        payBill.setMnemonic('P');
        payBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        payBill.setBackground(Color.WHITE);
        
        /* ---- Last Bill ----*/
        billDetails.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon lastBillIcon = new ImageIcon(Dashboard.class.getResource("icon/view_info_icon.png"));
        Image lastBillImage = lastBillIcon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        billDetails.setIcon(new ImageIcon(lastBillImage));
        billDetails.setMnemonic('L');
        billDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        billDetails.setBackground(Color.WHITE);
        
        payBill.addActionListener(this);
        billDetails.addActionListener(this);
        
        
        // --------------------------------------------------------------------------------------------- 
        
        /* Third Column*/
        JMenu report = new JMenu("Report");
        JMenuItem generateBill = new JMenuItem("Generate Bill");
        report.setForeground(Color.BLUE);
        
        /* ---- Report ---- */
        generateBill.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon generateBillIcon = new ImageIcon(Dashboard.class.getResource("icon/generate_bill_icon.png"));
        Image image7 = generateBillIcon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        generateBill.setIcon(new ImageIcon(image7));
        generateBill.setMnemonic('R');
        generateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        generateBill.setBackground(Color.WHITE);
        
        generateBill.addActionListener(this);
        
        // -----------------------------------------------------------------------------------------------
        
        /* Fourth Column*/
        JMenu utility = new JMenu("Utility");
        JMenuItem notapadUtility = new JMenuItem("Notepad");
        JMenuItem calculatorUtility = new JMenuItem("Calculator");
        JMenuItem webBrowseUtlity = new JMenuItem("Web Browser");
        utility.setForeground(Color.RED); 
        
        /* ---- Calender ---- */
        notapadUtility.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon notepadIcon = new ImageIcon(Dashboard.class.getResource("icon/notepad_icon.png"));
        Image notepadImage = notepadIcon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        notapadUtility.setIcon(new ImageIcon(notepadImage));
        notapadUtility.setMnemonic('C');
        notapadUtility.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        notapadUtility.setBackground(Color.WHITE);
        
        /* ---- Calculator ---- */
        calculatorUtility.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon calculatorIcon = new ImageIcon(Dashboard.class.getResource("icon/calculator_icon.png"));
        Image calculatorImage = calculatorIcon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        calculatorUtility.setIcon(new ImageIcon(calculatorImage));
        calculatorUtility.setMnemonic('X');
        calculatorUtility.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        calculatorUtility.setBackground(Color.WHITE);
        
        /* ---- Web Browser ---- */
        webBrowseUtlity.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon webBrowserIcon = new ImageIcon(Dashboard.class.getResource("icon/web_browser_icon.png"));
        Image webBrowserImage = webBrowserIcon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        webBrowseUtlity.setIcon(new ImageIcon(webBrowserImage));
        webBrowseUtlity.setMnemonic('W');
        webBrowseUtlity.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        webBrowseUtlity.setBackground(Color.WHITE);
        
        
        notapadUtility.addActionListener(this);
        calculatorUtility.addActionListener(this);
        webBrowseUtlity.addActionListener(this);
        
        // ---------------------------------------------------------------------------------------
        
        /*Fifth Column */
        JMenu exit = new JMenu("Logout");
        JMenuItem logout = new JMenuItem("Logout");
        exit.setForeground(Color.BLUE);
        
        /* ---- Exit ---- */
        logout.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon logoutIcon = new ImageIcon(Dashboard.class.getResource("icon/logout_icon.png"));
        Image logoutImage = logoutIcon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        logout.setIcon(new ImageIcon(logoutImage));
        logout.setMnemonic('Z');
        logout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        logout.setBackground(Color.WHITE);
        
        logout.addActionListener(this);
        
        
        // ---------------------------------------------------------------------------------------------
               
        
        master.add(newCustomer);
        master.add(customerDetails);
        master.add(depositDetails);
        master.add(calculateBill);
        
        info.add(updateInfo);
        info.add(viewInfo);
        
        user.add(payBill);
        user.add(billDetails);
        
        report.add(generateBill);
        
        utility.add(notapadUtility);
        utility.add(calculatorUtility);
        utility.add(webBrowseUtlity);
        
        exit.add(logout);
         
        if(person.equals("Admin")){
            menuBar.add(master);
        }else{             
            menuBar.add(info);
            menuBar.add(user);
            menuBar.add(report);
        }
        menuBar.add(utility);
        menuBar.add(exit);
        
        setJMenuBar(menuBar);    
        
        setFont(new Font("Senserif",Font.BOLD,16));
        setLayout(new FlowLayout());
        setVisible(false);
    }
    public void actionPerformed(ActionEvent events){
        String menuItem = events.getActionCommand();
        if(menuItem.equals("New Customer")){
            new NewCustomer().setVisible(true);
            
        }else if(menuItem.equals("Customer Details")){
            new CustomerDetails().setVisible(true);
            
        }else if(menuItem.equals("Calculate Bill")){
            new CalculateBill().setVisible(true);
            
        }else if(menuItem.equals("Pay Bill")){
            new PayBill(meter).setVisible(true);
           
        }else if(menuItem.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){ }
        }else if(menuItem.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){ }
        }else if(menuItem.equals("Web Browser")){
            try{
                Runtime.getRuntime().exec("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
            }catch(Exception e){ }
        }else if(menuItem.equals("Logout")){
            this.setVisible(false);
            new Login().setVisible(true);
        }else if(menuItem.equals("Generate Bill")){
//            new GenerateBill(meter).setVisible(true);     
        }else if(menuItem.equals("Deposit Details")){
//            new DepositDetails().setVisible(true);
        }else if(menuItem.equals("View Information")){
//            new ViewInformation(meter).setVisible(true);
        }else if(menuItem.equals("Update Information")){
//            new UpdateInformation(meter).setVisible(true);
        }else if(menuItem.equals("Bill Details")){
//            new BillDetails(meter).setVisible(true);
        }
        
        
    }
    
    
    public static void main(String[] args){
        new Dashboard("", "").setVisible(true);
    }
    


    
}
