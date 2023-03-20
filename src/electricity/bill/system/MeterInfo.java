package electricity.bill.system;

/**
 *
 * @author Rahul kumar
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.*;


public class MeterInfo extends JFrame implements ActionListener {
    
    JTextField customer , addr , city1, state1, mail, cont ;
    JButton next,cancel;
     JLabel  meterno;
     Choice meterlocation, metertype , phasecode , billtype;
     String meternumber;
     
    MeterInfo(String meternumber){
        
        super("ANCHOR ELECTRICITY PVT.LTD");
        this.meternumber= meternumber;
    setSize(700 ,500);
    setLocation(400, 200);
    
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(51,204,255));
        p1.setLayout(null);
        add(p1);
        
        JLabel heading =new JLabel(" Meter Information");
        heading.setBounds(180,10,200,25);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Tohoma", Font.BOLD,22));
        p1.add(heading);
        
       JLabel customername =new JLabel("Meter Number");
       customername.setBounds(100,80,100,20);
        p1.add(customername);
        
        JLabel lblmeterno =new JLabel(meternumber);
        lblmeterno.setBounds(240,80,200,20);
        p1.add(lblmeterno);
        
        JLabel metern =new JLabel("Meter Location");
        metern.setBounds(100,120,100,20);
        p1.add(metern);
        
        meterlocation = new Choice();
        meterlocation.add("Outside");
        meterlocation.add("Inside");
        meterlocation.setBounds(240,120,200,20);
        p1.add(meterlocation);
        
       
              
        JLabel address =new JLabel("Meter Type");
        address.setBounds(100,160,100,20);
        p1.add(address);
        
        metertype = new Choice();
        metertype.add("Electric Meter");
        metertype.add("Solar Meter");
        metertype.add("Smart Meter");
        metertype.setBounds(240,160,200,20);
        p1.add(metertype);
        
        
        JLabel city =new JLabel("Phase code");
        city.setBounds(100,200,100,20);
        p1.add(city);
        
        phasecode = new Choice();
        phasecode.add("011");
        phasecode.add("022");
        phasecode.add("033");
        phasecode.add("044");
        phasecode.add("055");
        phasecode.add("066");
        phasecode.add("077");
        phasecode.add("088");
        phasecode.add("099");
        phasecode.add("010");
        phasecode.setBounds(240,200,200,20);
        p1.add(phasecode);
        
         
        JLabel state =new JLabel("Bill Type");
        state.setBounds(100,240,100,20);
        p1.add(state);
        
        billtype = new Choice();
        billtype.add("Industrial");
        billtype.add("Normal");
        billtype.setBounds(240,240,200,20);
        p1.add(billtype);
        
        JLabel email =new JLabel("Days");
        email.setBounds(100,280,100,20);
        p1.add(email);
        
        JLabel emails =new JLabel("30 Days");
        emails.setBounds(240,280,100,20);
        p1.add(emails);
        
        JLabel emailss =new JLabel("Note");
        emailss.setBounds(100,320,100,20);
        p1.add(emailss);
        
        JLabel contacts =new JLabel("By Default Bill Is Calculated For 30 Days Only.");
        contacts.setBounds(240,320,500,20);
        p1.add(contacts);
        
        
        next =new JButton("Submit");
        next.setBackground(Color.black);
        next.setForeground(Color.white);  
        next.setBounds(220,390,100,25);
        next.addActionListener(this);
        p1.add(next);
        
        
    
        
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
             String meter= meternumber;
             String location= meterlocation.getSelectedItem();
             String type =metertype.getSelectedItem();
             String code =phasecode.getSelectedItem();
             String billt= billtype.getSelectedItem();
            String days = "30";
             
             String query= "insert into meter_info values('"+location+"', '"+type+"', '"+code+"' ,'"+billt+"', '"+days+"','"+meter+"')";
             
             
             try{
                 conn c= new conn();
                 c.s.executeUpdate(query);
                 
                 
                 JOptionPane.showMessageDialog(null, "Meter Information Added Successfully");
                 setVisible(false);
                 
                 
                 
             }catch(Exception e){
                 e.printStackTrace();
                 
             }
             
             
         }else{
             setVisible(false);
         }
        
       
     }
    
    
    
    
    
    public static void main(String[]args){
        new MeterInfo("");
    }
    
}

    

