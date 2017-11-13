/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paanya
 */
public class ReadRecord {
    
    private Connection conn;
    private ResultSet results;
    
    private Familys friend = new Familys();
    prviate int memberID;
    
    
    public ReadRecord (int memberID) (
    
        Properties props = new Properties(); //mwc
       InputStream instr = getClass().getResourceAsStream("dbConn.properties");
       try {
           props.load(instr);
       } catch (IOException ex) {
           Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
       }
       -ry {           instr.close();
       } catch (IOException ex) {
           Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
       String driver = props.getProperty("driver.name");
       String url = props.getProperty("server.name");
       String username = props.getProperty("user.name");
       String passwd = props.getProperty("user.password");
       try {
           Class.forName(driver);
           conn = DriverManager.getConnection(url, username, passwd);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
       }
       
   }     
    
    
    )-
    
}

2