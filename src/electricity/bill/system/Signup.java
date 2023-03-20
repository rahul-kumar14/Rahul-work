package electricity.bill.system;

/**
 *
 * @author Rahul kumar
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;


public class Signup extends JFrame implements ActionListener {
    JButton back, create;
    Choice accountType;
    JTextField meter , username, name, password;
    
    Signup(){
        super("Signup page");
        
        setBounds(450, 150,700,400);
        getContentPane().setBackground(Color.YELLOW);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBounds(30,30,650,300);
        p1.setBorder(new TitledBorder(new LineBorder(new Color(173,216,230),2),"Create Account", TitledBorder.LEADING, TitledBorder.TOP , null, new Color(173,216,230)));
        p1.setBackground(Color.red);
        p1.setLayout(null);
        p1.setForeground(new Color(34,139,34));
        add(p1);
        
        JLabel heading =new JLabel("Create Account As");
        heading.setBounds(100,50,140,20);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Tohoma", Font.BOLD,14));
        p1.add(heading);
        
        accountType= new Choice();
        accountType.add("Admin");
        accountType.add("Consumer");
        accountType.setBounds(260, 50,150,20);
        p1.add(accountType);
        
        JLabel lblmeter =new JLabel("Meter Number");
        lblmeter.setBounds(100,90,140,20);
        lblmeter.setForeground(Color.BLACK);
        lblmeter.setFont(new Font("Tohoma", Font.BOLD,14));
        lblmeter.setVisible(false);
        p1.add(lblmeter);
        
        meter =new JTextField();
        meter.setBounds(260,90,150,20);
        meter.setVisible(false);
        p1.add(meter);
        
       
        JLabel lblusername =new JLabel("User Name");
        lblusername.setBounds(100,130,140,20);
        lblusername.setForeground(Color.BLACK);
        lblusername.setFont(new Font("Tohoma", Font.BOLD,14));
        p1.add(lblusername);
        
        username =new JTextField();
        username.setBounds(260,130,150,20);
        p1.add(username);
        
        JLabel lblname =new JLabel("Name");
        lblname.setBounds(100,170,140,20);
        lblname.setForeground(Color.BLACK);
        lblname.setFont(new Font("Tohoma", Font.BOLD,14));
        p1.add(lblname);
        
        name =new JTextField();
        name.setBounds(260,170,150,20);
        p1.add(name);
        
        meter.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent fe) {}
     
        @Override
        public void focusLost(FocusEvent fe) {
         try {
             conn c  = new conn();
             ResultSet rs = c.s.executeQuery("select * from login where meter_no = '"+meter.getText()+"'");
             while(rs.next()) {
                 name.setText(rs.getString("name"));
             }
         } catch (Exception e) {
             e.printStackTrace();
             }
         }
     });
     
        
        JLabel lblpassword =new JLabel("Password");
        lblpassword.setBounds(100,210,140,20);
        lblpassword.setForeground(Color.BLACK);
        lblpassword.setFont(new Font("Tohoma", Font.BOLD,14));
        p1.add(lblpassword);
        
        password =new JTextField();
        password.setBounds(260,210,150,20);
        p1.add(password);
        
        accountType.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent ae) {
         String user = accountType.getSelectedItem();
         if (user.equals("Consumer")) {
             lblmeter.setVisible(true);
             meter.setVisible(true);
             name.setEditable(false);
         } else {
             lblmeter.setVisible(false);
             meter.setVisible(false);
             name.setEditable(true);
         }
     }
 });
 
        
        create =new JButton("Create");
        create.setBackground(Color.black);
        create.setForeground(Color.white);  
        create.setBounds(140,260,120,25);
        create.addActionListener(this);
        p1.add(create);
        
        back =new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);  
        back.setBounds(300,260,120,25);
        back.addActionListener(this);
        p1.add(back);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupimage.png"));
        Image i2=  i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(415, 30, 250, 250);
        p1.add(image);
        
        
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
    if  (ae.getSource()== create){
        String atype =accountType.getSelectedItem();
        String susername =username.getText();
        String sname = name.getText(); 
        String spass=password.getText();
        String smeter = meter.getText();
        
        
        try{
            
            conn c =new conn();
            
             String query = null;
             if (atype.equals("Admin")) {
             query = "insert into login values('"+smeter+"', '"+susername+"', '"+sname+"', '"+spass+"', '"+atype+"')";
            }else {
             query = "update login set usernsme = '"+susername+"', password = '"+spass+"', user = '"+atype+"' where meter_no = '"+smeter+"'";
            }
             c.s.executeUpdate(query);
 
            
            JOptionPane.showMessageDialog(null, "Account Created Successfully");
            
            setVisible(false);
            new Login(); 
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }else if (ae.getSource()== back){
        setVisible(false);
        new Login();
    }
    }
    
    public static void main(String args []){
        new Signup();
    }
    
    
    
}
