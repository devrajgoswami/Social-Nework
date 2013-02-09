
package com.app.dao.DBService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class ConnectionManager {
    
    private static String driver="com.mysql.jdbc.Driver";
    private static String url="jdbc:mysql://localhost:3306/social";
    private static String user="root";
    private static String password="root";
    private static final Logger logger=Logger.getLogger(ConnectionManager.class.getName());
    
    public static Connection getMySQLConnection(){
        Connection con = null;
        logger.info("Establishing Database Connection...");
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
        }catch(ClassNotFoundException ex){
            logger.severe(ex.toString());
        } catch(SQLException ex){
            logger.severe(ex.toString());
        }
        return con;
    }
    
    public static void releaseResource(Statement st,ResultSet rs){
        //logger.info("Releasing Database Resources...");
        if(st!=null){
            try{
                st.close();
            }catch(SQLException ex){
                logger.severe(ex.toString());
            }
        }
        if(rs!=null){
            try{
                rs.close();
            }catch(SQLException ex){
                logger.severe(ex.toString());
            }
        }
    }
    
    public static void closeMySQLConnection(Connection con){
        logger.info("Closing Database Connection...");
        if(con!=null){
            try{
                con.close();
            }catch(SQLException ex){
                logger.severe(ex.toString());
            }
        }
    }
    
}
