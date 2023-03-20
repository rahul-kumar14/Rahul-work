package electricity.bill.system;

/**
 *
 * @author Rahul kumar
 * 
 * 
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class NewCustomer extends JFrame implements ActionListener {
    
    JTextField customer , addr , city1, state1, mail, cont ;
    JButton next,cancel;
     JLabel  meterno;
    NewCustomer(){
        super("ANCHOR ELECTRICITY PVT.LTD");
    setSize(700 ,500);
    setLocation(400, 200);
    
    JPanel p1 = new JPanel();
        p1.setBackground(new Color(51,204,255));
        p1.setLayout(null);
        add(p1);
        
        JLabel heading =new JLabel("New Customer");
        heading.setBounds(180,10,200,25);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Tohoma", Font.BOLD,26));
        p1.add(heading);
        
       JLabel customername =new JLabel("Customer Name");
        customername.setBounds(100,80,100,20);
        p1.add(customername);
        
        customer =new JTextField();
        customer.setBounds(240,80,200,20);
        p1.add(customer);
        
        JLabel metern =new JLabel("Meter Number");
        metern.setBounds(100,120,100,20);
        p1.add(metern);
        
        meterno =new JLabel(" ");
        meterno.setBounds(240,120,100,20);
        p1.add(meterno);
        
        Random ran =new Random();
        long number=ran.nextLong() % 1000000;
        meterno.setText("" + Math.abs(number));
        
        
        
        JLabel address =new JLabel("Address");
        address.setBounds(100,160,100,20);
        p1.add(address);
        
        addr =new JTextField();
        addr.setBounds(240,160,200,20);
        p1.add(addr);
        
        
        JLabel city =new JLabel("City");
        city.setBounds(100,200,100,20);
        p1.add(city);
        
        city1 =new JTextField();
        city1.setBounds(240,200,200,20);
        p1.add(city1);
        
         
        JLabel state =new JLabel("State");
        state.setBounds(100,240,100,20);
        p1.add(state);
        
        state1 =new JTextField();
        state1.setBounds(240,240,200,20);
        p1.add(state1);
        
        JLabel email =new JLabel("Email");
        email.setBounds(100,280,100,20);
        p1.add(email);
        
        mail =new JTextField();
        mail.setBounds(240,280,200,20);
        p1.add(mail);
        
        
        JLabel contact =new JLabel("Contact No.");
        contact.setBounds(100,320,100,20);
        p1.add(contact);
        
        cont =new JTextField();
        cont.setBounds(240,320,200,20);
        p1.add(cont);
        
        
        next =new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);  
        next.setBounds(120,390,100,25);
        next.addActionListener(this);
        p1.add(next);
        
        cancel =new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);  
        cancel.setBounds(250,390,100,25);
        cancel.addActionListener(this);
        p1.add(cancel);
    
        
    setLayout(new BorderLayout());
    add(p1, "Center");
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
    Image i2 =  i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
    ImageIcon i3 =new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    add(image, "West");
    getContentPane().setBackground(Color.WHITE);
    
    setVisible(true);
        
   
    }
    
     public void actionPerformed(ActionEvent ae){
         if  (ae.getSource()== next){
             String customername= customer.getText();
             String metern= meterno.getText();
             String address =addr.getText();
             String city =city1.getText();
             String state= state1.getText();
             String email=mail.getText();
             String contact=cont.getText();
             
             String query1= "insert into customer values('"+customername+"' , '"+metern+"', '"+address+"', '"+city+"' ,'"+state+"', '"+email+"', '"+contact+"')";
             String query2="insert into login values( '"+metern+"', '','"+customername+"','','')";
             
             try{
                 conn c= new conn();
                 c.s.executeUpdate(query1);
                 c.s.executeUpdate(query2);
                 
                 JOptionPane.showMessageDialog(null, "Customer Detail Added Successfully");
                 setVisible(false);
                 
                 new MeterInfo(metern);
                 
             }catch(Exception e){
                 e.printStackTrace();
                 
             }
             
             
         }else{
             setVisible(false);
         }
        
       
     }
    
    
    
    
    
    public static void main(String[]args){
        new NewCustomer();
    }
    
}
