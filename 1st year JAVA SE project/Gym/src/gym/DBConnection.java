/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Shan Wijenayaka
 */
public class DBConnection {
    private Connection DBConnection;
    public Connection connect(){
         try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connection Success(1)");
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"error check mysql driver for java : "+ex );
            System.exit(0);
            
        }
        
        String url = "jdbc:mysql://localhost:3306/gymdb";
        String name = "root";
        String password = "";
        
        try{
            DBConnection = (Connection) DriverManager.getConnection(url, name, password);
            System.out.println("Database Connected(2)");
            
        }
        catch(SQLException se){
            System.out.println("Database application is not running or incorrect url/name/password for the database :"+se);
            JOptionPane.showMessageDialog(null,"base application is not running or incorrect url/name/password for the database : "+se );
            System.exit(0);
        }
        return DBConnection;
    }

    PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
