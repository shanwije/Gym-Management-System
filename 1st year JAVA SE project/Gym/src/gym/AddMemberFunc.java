/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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
public class AddMemberFunc {
    
    
    private static int lastid;
    
Connection conn = new DBConnection().connect();
    void addToMemberDetails(String memName,  String contactNo, String memAddress) {
    try {
        PreparedStatement ps;
        ps = conn.prepareStatement("insert into "
                + "memberdetails"+"(name,contact_number,address,registered_on,registered_by) "
                + "values(?,?,?,?,?)");
        
        ps.setString(1, memName);
        ps.setString(2, contactNo);
        ps.setString(3, memAddress);
        
        
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        ps.setTimestamp(4, date);
        
        
        ps.setString(5, new LoginFunc().getLogName());
        JOptionPane.showMessageDialog(null, memName+"'s information succefully entered to the database");
        
        ps.executeUpdate();
    
    
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "error: "+ex);
    }
        
    }

   // void addTOMoreMemDetails(String NIC, String emailAddress, String emContact, String gender, String remarks) 

   
    
    
    
    
    void addTOMoreMemDetails(String NIC, String emailAddress, String emContact, 
            String Gender, String Remarks, Double H, Double W,String MemberCat , String ReciptNo , String payments) {
    try {
        PreparedStatement ps;
        ps = conn.prepareStatement("insert into "
                + "morememberdetails"+"(id,nic,email,emcontact,gender,height,weight,bmi,remarks,lastUpdated,membership_cat,recipt_no,payment_plan) "
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, getId());
        ps.setString(2, NIC);
        ps.setString(3, emailAddress);
        ps.setString(4, emContact);
        ps.setString(5, Gender);
        ps.setDouble(6, H);
        ps.setDouble(7, W);
        ps.setInt(8,getBMI(H,W));
        ps.setString(9, Remarks);
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        ps.setTimestamp(10, date);
        ps.setString(11,MemberCat );
        ps.setString(12,ReciptNo );
        ps.setString(13,payments );
        
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "information succefully entered to the database");
        
    } catch (SQLException ex) {
        Logger.getLogger(AddMemberFunc.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
   
    
    
    
    
    public int getId(){
    try{
            
            PreparedStatement st = conn.prepareStatement("select * from  memberdetails where id");

            

            ResultSet rs = st.executeQuery();
           rs = st.executeQuery("SELECT MAX(id) AS id FROM memberdetails");
           if(rs.next())
             lastid = rs.getInt("id");
           System.out.println("last id from the function :"+lastid);

                
               return lastid; 
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"problem at setting foriegn key: "+e );
                System.out.println(e);
            }
    
    
    return lastid;
}
    
    public int getBMI(double h, double w){
        int b = (int) (w/(h*h));
       return b; 
    }
    

    
    
}
