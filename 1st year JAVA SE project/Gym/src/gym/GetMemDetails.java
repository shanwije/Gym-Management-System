/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Shan Wijenayaka
 */
public class GetMemDetails {
Connection conn = new DBConnection().connect();
String [] results = new String[18];
    
private static String name, memId ,contact,address,registeredBy,registeredOn;
private static String NIC, Email, emContact , Gender , Height , Weight , BMI , Remarks , LastUpdated ,
        MembershipCat,ReciptNo , PaymentPlan ;

    /**
     *
     * @param SearchName
     * @return
     */
    public String[] search(String SearchID) {
        if(SearchID == ""){
            JOptionPane.showMessageDialog(null,"please enter an id number to search member details" );
        }
        else{
            try {
            String sql1 = "Select * from memberdetails Where id = ?";
            
                PreparedStatement ps;
                
                ps = conn.prepareStatement(sql1);
                
                ps.setString(1, SearchID);
                ResultSet rs = ps.executeQuery();
                
                
                if(rs.next()){
                    name = rs.getString("name");
                    memId = rs.getString("id");
                    contact = rs.getString("contact_number");
                    address = rs.getString("address");
                    registeredOn = rs.getString("registered_on");
                    registeredBy = rs.getString("registered_by");
                }
                
                else{
                 JOptionPane.showMessageDialog(null,"there is no "+SearchID+" inside the database" );
                 
             }
                
                
             System.out.println("dffddddssdfdsdsf            "+memId);   
            
            
            String sql2 = "Select * from morememberdetails Where id = ?";
            
            
            
                PreparedStatement ps2;
                
                ps2 = conn.prepareStatement(sql2);
                
                ps2.setString(1, SearchID);
                ResultSet rs2 = ps2.executeQuery();
            
            
            
            
            
             if(rs2.next()){
                 NIC = rs2.getString("nic");
                 Email = rs2.getString("email");
                 emContact = rs2.getString("emcontact");
                 Gender = rs2.getString("gender");
                 Height = rs2.getString("height");
                 Weight = rs2.getString("weight");
                 BMI = rs2.getString("bmi");
                 Remarks = rs2.getString("remarks");
                 LastUpdated = rs2.getString("lastUpdated");
                 MembershipCat = rs2.getString("membership_cat"); 
                 ReciptNo = rs2.getString("recipt_no");
                 PaymentPlan = rs2.getString("payment_plan");
             
             }
             
            
            
            
        
         String [] r  = {name, memId ,contact,address,registeredBy,registeredOn,NIC, Email, emContact , Gender , Height , Weight , BMI , Remarks , LastUpdated ,
        MembershipCat,ReciptNo , PaymentPlan};
            System.arraycopy(r, 0, results, 0, 18);
         
        
        
        
    
    return results;
    }catch(SQLException | HeadlessException c ){
             JOptionPane.showMessageDialog(null,"error search "+c );
        }
    return results;
    }
        return results;
        }
        

    void searchByID(String SearchID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
