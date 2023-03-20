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
import java.sql.*;


public class CalculateBill extends JFrame implements ActionListener {
    
    JTextField customer ,  unit1, state1, mail, cont ;
    JButton next,cancel;
    JLabel  lblname, addrr;
    Choice meternumber , months;
     
    CalculateBill(){
        
        super("ANCHOR ELECTRICITY PVT.LTD");
    setSize(700 ,500);
    setLocation(400, 200);
    
    JPanel p1 = new JPanel();
        p1.setBackground(new Color(51,204,255));
        p1.setLayout(null);
        add(p1);
        
        JLabel heading =new JLabel("Calculate Electricity Bill");
        heading.setBounds(100,10,400,25);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Tohoma", Font.BOLD,24));
        p1.add(heading);
        
       JLabel customername =new JLabel("Meter Number");
       customername.setBounds(100,80,100,20);
       p1.add(customername);
        
        meternumber =new Choice();
        meternumber.setBounds(240,80,200,20);
        p1.add(meternumber);
        
        
        try {
            conn c =new conn();
            ResultSet rs =c.s.executeQuery("select * from customer");
            while(rs.next()){
               meternumber.add( rs.getString("meter_no"));
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
        JLabel metern =new JLabel("Name");
        metern.setBounds(100,120,100,20);
        p1.add(metern);
        
        lblname =new JLabel(            );
        lblname.setBounds(240,120,100,20);
        p1.add(lblname);
        
       
        
        
        
        JLabel address =new JLabel("Address");
        address.setBounds(100,160,100,20);
        p1.add(address);
        
        addrr =new JLabel();
        addrr.setBounds(240,160,200,20);
        p1.add(addrr);
        
        try {
            conn c =new conn();
            ResultSet rs =c.s.executeQuery("select * from customer where meter_no ='"+meternumber.getSelectedItem()+"'");
            while(rs.next()){
            lblname.setText(rs.getString("customername"));
            addrr.setText(rs.getString("address"));
            }
        }catch(Exception e ){
            e.printStackTrace();
        }
        
        
        meternumber.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent ie){
            
               
        try {
            conn c =new conn();
            ResultSet rs =c.s.executeQuery("select * from customer where meter_no ='"+meternumber.getSelectedItem()+"'");
            while(rs.next()){
            lblname.setText(rs.getString("customername"));
            addrr.setText(rs.getString("address"));
            }
        }catch(Exception e ){
            e.printStackTrace();
        }
            
            
        }
    });
        
        
        JLabel unit =new JLabel("Units Consume");
        unit.setBounds(100,200,100,20);
        p1.add(unit);
        
        unit1 =new JTextField();
        unit1.setBounds(240,200,200,20);
        p1.add(unit1);
        
         
        JLabel month =new JLabel("Months");
        month.setBounds(100,240,100,20);
        p1.add(month);
        
        months =new Choice();
        months.setBounds(240,240,200,20);
        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("August");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");
        p1.add(months);
        
      
        
        next =new JButton("Submit");
        next.setBackground(Color.black);
        next.setForeground(Color.white);  
        next.setBounds(120,350,100,25);
        next.addActionListener(this);
        p1.add(next);
        
        cancel =new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);  
        cancel.setBounds(250,350,100,25);
        cancel.addActionListener(this);
        p1.add(cancel);
    
        
    setLayout(new BorderLayout());
    add(p1, "Center");
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
    Image i2 =  i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
    ImageIcon i3 =new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    add(image, "West");
    getContentPane().setBackground(Color.WHITE);
    
    setVisible(true);
        
   
    }
    
     public void actionPerformed(ActionEvent ae){
         if  (ae.getSource()== next){
             String meter= meternumber.getSelectedItem();
             String units= unit1.getText();
             String month =months.getSelectedItem();
             
         int totalbill = 0;
         int unit_consumed = Integer.parseInt(units);
         String query = "select * from tax";
         
         try {
             conn c = new conn();
             ResultSet rs = c.s.executeQuery(query);
             
             while(rs.next()) {
                 totalbill += unit_consumed * Integer.parseInt(rs.getString("cost_per_unit"));
                 totalbill += Integer.parseInt(rs.getString("meter_rent"));
                 totalbill += Integer.parseInt(rs.getString("service_charge"));
                 totalbill += Integer.parseInt(rs.getString("service_tax"));
                 totalbill += Integer.parseInt(rs.getString("swacch_bharat_cess"));
                 totalbill += Integer.parseInt(rs.getString("fixed_tax"));
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         
         String query2 = "insert into bill values('"+meter+"', '"+month+"', '"+units+"', '"+totalbill+"', 'Not Paid')";
     
         try {
             conn c  =  new conn();
             c.s.executeUpdate(query2);
             
             JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
             setVisible(false);
         } catch (Exception e) {
             e.printStackTrace();
         }
     } else {
         setVisible(false);
     }
 }
    
    
    
    public static void main(String[]args){
        new CalculateBill();
    }
    
}

