package electricity.bill.system;

/**
 *
 * @author Rahul kumar
 */

 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class CustomerDetails extends JFrame implements ActionListener  {
    
    Choice meternumber, cmonth;
    JTable table;
    JButton search, print;
    
    
    CustomerDetails(){
        super("Deposited Details");
        
        
        setSize(1200,650);
        setLocation(00,100);
        
        
        table = new JTable();
        
        
        
        try {
    conn c = new conn();
    ResultSet rs = c.s.executeQuery("select * from customer");
    
    table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
    e.printStackTrace();
}
        
        JScrollPane sp = new JScrollPane(table);
        add(sp);
        
        
        print = new JButton("Print");
        print.addActionListener(this);
        add(print, "South");
        
        
        setVisible(true);
    }
          public void actionPerformed(ActionEvent ae){ 
         if (ae.getSource() == search) {
           String query = "select * from bill where meter_no = '"+meternumber.getSelectedItem()+"' and month = '"+cmonth.getSelectedItem()+"'";
    try {
        conn c = new conn();
        ResultSet rs = c.s.executeQuery(query);
        table.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (Exception e) {
        
    }
} else  {
    try {
        table.print();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
   }
    
    
     public static void main(String[]args){
        new CustomerDetails();
    }
    

}
