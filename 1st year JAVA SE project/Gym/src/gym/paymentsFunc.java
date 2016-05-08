/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Shan Wijenayaka
 */
class paymentsFunc {

    public paymentsFunc() {
    }

    boolean addNewPayment(String IDp, String paymentp, String reciptp) {
        
        try {
            Connection conn = new DBConnection().connect();
            PreparedStatement ps;
            ps = conn.prepareStatement("insert into "
                    + "pay"+"(id,reciptNo,payment,date,added_by) "
                    + "values(?,?,?,?,?)");
            
            ps.setString(1, IDp);
            ps.setString(3, paymentp);
            ps.setString(2, reciptp);
            
            
            java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
            ps.setTimestamp(4, date);
            
            
            ps.setString(5, new LoginFunc().getLogName());
            JOptionPane.showMessageDialog(null, "Id number = "+IDp+"\npayment = "+paymentp+"\nrecipt No = "+reciptp+" information succefully entered to the database");
            
            ps.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "error at paymentsFunc Class : "+ex);
        }
        return false;
    }
    }
    

