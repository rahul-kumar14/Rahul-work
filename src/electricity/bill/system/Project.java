package electricity.bill.system;

/**
 *
 * @author Rahul kumar
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Project extends JFrame implements ActionListener {
     String atype , meter;
     Project(String atype, String meter){
        super ("ANCHOR ELECTRICITY PVT.LTD");
        this.atype= atype;
        this.meter= meter;
        
        
      setExtendedState(JFrame.MAXIMIZED_BOTH);  
      
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect2.jpg"));
      Image i2 =  i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
      ImageIcon i3 =new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      add(image);   
      
     
      
        JMenuBar mb =new JMenuBar();
        setJMenuBar(mb);
        
        JMenu master = new JMenu("Master");
        master.setForeground(Color.BLUE);
        
        
        JMenuItem newcustomer = new JMenuItem("New Customer");
        newcustomer.setFont(new Font ("monospaced" , Font.PLAIN ,12));
        newcustomer.setBackground(Color.WHITE);
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image i6 =  i5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        newcustomer.setIcon(new ImageIcon(i6));
        newcustomer.addActionListener(this);
        master.add(newcustomer);
        
        JMenuItem customerdetail = new JMenuItem("Customer Details");
        customerdetail.setFont(new Font ("monospaced" , Font.PLAIN ,12));
        customerdetail.setBackground(Color.WHITE);
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image icon1 =  icon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        customerdetail.setIcon(new ImageIcon(icon1));
        customerdetail.addActionListener(this);
        master.add(customerdetail);
        
        JMenuItem depositedetail = new JMenuItem("Diposited Details");
        depositedetail.setFont(new Font ("monospaced" , Font.PLAIN ,12));
        depositedetail.setBackground(Color.WHITE);
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image icon3 =  icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        depositedetail.setIcon(new ImageIcon(icon3));
        depositedetail.addActionListener(this);
        master.add(depositedetail);
        
        JMenuItem calculatebill = new JMenuItem("Calculate Bill");
        calculatebill.setFont(new Font ("monospaced" , Font.PLAIN ,12));
        calculatebill.setBackground(Color.WHITE);
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image icon5 =  icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculatebill.setIcon(new ImageIcon(icon5));
        calculatebill.addActionListener(this);
        master.add(calculatebill);
        
        
        JMenu info = new JMenu("Information");
        info.setForeground(Color.RED);
       
        JMenuItem updateinfo = new JMenuItem("Update Information");
        updateinfo.setFont(new Font ("monospaced" , Font.PLAIN ,12));
        updateinfo.setBackground(Color.WHITE);
        ImageIcon i8 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image i7 =  i8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        updateinfo.setIcon(new ImageIcon(i7));
        updateinfo.addActionListener(this);
       
        info.add(updateinfo);
        
        JMenuItem viewinfo = new JMenuItem("View information");
        viewinfo.setFont(new Font ("monospaced" , Font.PLAIN ,12));
        viewinfo.setBackground(Color.WHITE);
        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image icon7 =  icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        viewinfo.setIcon(new ImageIcon(icon7));
        viewinfo.addActionListener(this);
        info.add(viewinfo);
        
        JMenu user = new JMenu("User");
        user.setForeground(Color.BLUE);
        
        
        JMenuItem paybill = new JMenuItem("Pay Bill");
        paybill.setFont(new Font ("monospaced" , Font.PLAIN ,12));
        paybill.setBackground(Color.WHITE);
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image i9 =  i10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        paybill.setIcon(new ImageIcon(i9));
        paybill.addActionListener(this);
       
        user.add(paybill);
        
        JMenuItem billdetail = new JMenuItem("Bill Details");
        billdetail.setFont(new Font ("monospaced" , Font.PLAIN ,12));
        billdetail.setBackground(Color.WHITE);
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icon/icon8.png"));
        Image icon9 =  icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        billdetail.setIcon(new ImageIcon(icon9));
        billdetail.addActionListener(this);
        user.add(billdetail);
        
        JMenu report = new JMenu("Report");
        report.setForeground(Color.RED);
      
        
        JMenuItem generatebill = new JMenuItem("Generate Bill");
        generatebill.setFont(new Font ("monospaced" , Font.PLAIN ,12));
        generatebill.setBackground(Color.WHITE);
        ImageIcon i12 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image i13 =  i12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        generatebill.setIcon(new ImageIcon(i13));
        generatebill.addActionListener(this);
        report.add(generatebill);
        
        
        
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.blue);
     
        
        JMenuItem notepad = new JMenuItem("NotePad");
        notepad.setFont(new Font ("monospaced" , Font.PLAIN ,12));
        notepad.setBackground(Color.WHITE);
        ImageIcon i15 = new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image i14 =  i15.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(i14));
        notepad.addActionListener(this);
        utility.add(notepad);
        
        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setFont(new Font ("monospaced" , Font.PLAIN ,12));
        calculator.setBackground(Color.WHITE);
        ImageIcon i17 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image i16 =  i17.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(i16));
        calculator.addActionListener(this);
        utility.add(calculator);
        
        
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.red);
       
        
        JMenuItem exit1 = new JMenuItem("Exit");
        exit1.setFont(new Font ("monospaced" , Font.PLAIN ,12));
        exit1.setBackground(Color.WHITE);
        ImageIcon i19= new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image i18 =  i19.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        exit1.setIcon(new ImageIcon(i18));
        exit1.addActionListener(this);
        exit.add(exit1);
        
         if (atype.equals("Admin")) {
         mb.add(master);
         } else {
         mb.add(info);
         mb.add(user);
         mb.add(report);
    }
 
     mb.add(utility);
     mb.add(exit);

        
        
        
        
        setLayout(new FlowLayout());
         setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae) {
     String msg = ae.getActionCommand();
     
     if (msg.equals("New Customer")) {
         new NewCustomer();
     
    } else if (msg.equals("Customer Details")) {
         new CustomerDetails();
    } else if (msg.equals("Diposited Details")) {
         new DipositeDetail();
     } else if (msg.equals("Calculate Bill")) {
         new CalculateBill();
      } else if (msg.equals("View information")) {
        new ViewInformation(meter);
         } else if (msg.equals("Update Information")) {
           new UpdateInformation(meter);
     } else if (msg.equals("Bill Details")) {
         new BillDetails(meter);
     } else if (msg.equals("NotePad")) {
         try {
             Runtime.getRuntime().exec("notepad.exe");
         } catch (Exception e) {
             e.printStackTrace();
         }
     } else if (msg.equals("Calculator")) {
         try {
             Runtime.getRuntime().exec("calc.exe");
         } catch (Exception e) {
             e.printStackTrace();
         }
     } else if (msg.equals("Exit")) {
         setVisible(false);
         new Login();
     } else if (msg.equals("Pay Bill")) {
         new PayBill(meter);
     } else if (msg.equals("Generate Bill")) {
         new GenerateBill(meter);
    }
 }
     
    public static void main(String args[]){
        new Project("", "");
        
    }
}
