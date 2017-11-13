
package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Family;

public class UpdateQuery {
  
    private Connection conn;
    
    public UpdateQuery() {
    
    
       Properties props = new Properties(); //mwc
       InputStream instr = getClass().getResourceAsStream("dbConn.properties");
       try {
           props.load(instr);
       } catch (IOException ex) {
           Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
       }
       try {
           instr.close();
       } catch (IOException ex) {
           Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
       String driver = props.getProperty("driver.name");
       String url = props.getProperty("server.name");
       String username = props.getProperty("user.name");
       String passwd = props.getProperty("user.password");
       try {
           Class.forName(driver);
           conn = DriverManager.getConnection(url, username, passwd);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
      
       
       
       
       
       }
       
}
    
    public void doUpdate (Family member){
        
        PreparedStatement ps = null;
        try {
            String query = "UPDATE family set memberName = ?, emailAddr = ?, age = ?, favoriteColor = ? WHERE memberID = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, member.getMemberName());
            ps.setString(2, member.getEmailAddr());
            ps.setInt(3, member.getAge());
            ps.setString(4, member.getFavoriteColor());
            ps.setInt(5, member.getMemberID());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
            
        
    }
}   
