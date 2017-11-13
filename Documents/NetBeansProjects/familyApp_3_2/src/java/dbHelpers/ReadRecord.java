
package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Family;


public class ReadRecord {
   
    private Connection conn;
    private ResultSet results;
    
    private Family member = new Family();
    private int memberID;
    
    
    public ReadRecord (int memberID) {
   
    Properties props = new Properties(); //mwc
       InputStream instr = getClass().getResourceAsStream("dbConn.properties");
       try {
           props.load(instr);
       } catch (IOException ex) {
           Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
       }
       try {
           instr.close();
       } catch (IOException ex) {
           Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
       String driver = props.getProperty("driver.name");
       String url = props.getProperty("server.name");
       String username = props.getProperty("user.name");
       String passwd = props.getProperty("user.password");
       
       this.memberID = memberID;
       
       try {
           Class.forName(driver);
           conn = DriverManager.getConnection(url, username, passwd);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
       }
       
   }
   
   public void doRead(){
       
        try {
            String query = "SELECT * FROM family WHERE memberID = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1, memberID);
            
            this.results = ps.executeQuery();
            
            this.results.next();
            
            member.setMemberID(this.results.getInt("memberID"));
            member.setMemberName(this.results.getString("memberName"));
            member.setEmailAddr(this.results.getString("emailAddr"));
            member.setAge(this.results.getInt("age"));
            member.setFavoriteColor(this.results.getString("favoriteColor"));
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
   }
       
   }

   public Family getMember() {
       
       return this.member;
   }





}

    

