package electricity.bill.system;

/**
 *
 * @author Rahul kumar
 */

import java.sql.*;
public class conn {
    Connection c;
    Statement s;
    conn(){
        
        
        try{
        c= DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs" , "root","root");
        s= c.createStatement();
        
        
                }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
