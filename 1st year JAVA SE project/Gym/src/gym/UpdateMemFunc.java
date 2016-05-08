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

import javax.swing.JOptionPane;

/**
 *
 * @author Shan Wijenayaka
 */
public class UpdateMemFunc {
     private static int lastid;
     private static String myID;
     
     
     public UpdateMemFunc(String MemID){
         myID = MemID;
     }
    
Connection conn = new DBConnection().connect();
    void addToMemberDetails(String memName,  String contactNo, String memAddress) {
    try {
        //"Update member_info SET name =?,idNo = ?,membershipCat =?,mNum = ?,hNum =?,email=?,birthday=?,
        //age=?,gender=?,spouseName=?,address=?,height=?,weight=?
        //,bmi=?,eName=?,eRelation=?,emNum=?,eAddress=?,Remarks=?,fullPayment=? where membershipNo = ?"
        PreparedStatement ps = conn.prepareStatement("Update memberdetails SET name =?,contact_number =?,address =? where id = ?");
                
        
        ps.setString(1, memName);
        ps.setString(2, contactNo);
        ps.setString(3, memAddress);
        ps.setString(4,myID);
        
        
         ps.executeUpdate();
        
        JOptionPane.showMessageDialog(null, memName+"'s information succefully entered to the database");
        
       
    
    
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "error: "+ex);
    }
        
    }

   // void addTOMoreMemDetails(String NIC, String emailAddress, String emContact, String gender, String remarks) 

   
    
    
    
    
    void addTOMoreMemDetails(String NIC, String emailAddress, String emContact, 
            String Gender, String Remarks, Double H, Double W,String MemberCat , String ReciptNo , String payments) {
    try {
        PreparedStatement ps;
        ps = conn.prepareStatement("Update morememberdetails SET nic =?,email =?,emcontact =?,gender =?,height =?,weight =?,bmi =?,remarks = ?,lastUpdated = ?,membership_cat =?,payment_plan =? where id = ?");
        
        ps.setString(1, NIC);
        ps.setString(2, emailAddress);
        ps.setString(3, emContact);
        ps.setString(4, Gender);
        ps.setDouble(5, H);
        ps.setDouble(6, W);
        ps.setInt(7,getBMI(H,W));
        ps.setString(8, Remarks);
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        ps.setTimestamp(9, date);
        ps.setString(10,MemberCat );
        
        ps.setString(11,payments );
        ps.setString(12,myID );
        
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "information succefully entered to the database");
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,"error at updating more memeber details table: "+ex );
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
