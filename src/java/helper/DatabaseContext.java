package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kandito Agung
 */
public class DatabaseContext {
    public static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DATABASE_URL = "jdbc:mysql://localhost/law";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    private Connection conn = null;
    private Statement statement = null;
    
    private void openConnection() {
        try {
            Class.forName(DATABASE_DRIVER);
            conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseContext.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void closeConnection() {
        if(statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public int countUsed(int id_alat) {
        try {
            String query = "SELECT SUM(peminjaman_item.jumlah) AS total FROM peminjaman_item, peminjaman, alat \n" +
                            "WHERE \n" +
                            "peminjaman_item.id_peminjaman = peminjaman.id_peminjaman AND\n" +
                            "alat.id_alat = peminjaman_item.id_alat AND\n" +
                            "peminjaman.status <> 0 AND\n" +
                            "alat.id_alat = " + id_alat;
            
            openConnection();
            ResultSet result = statement.executeQuery(query);
            
            result.next();
            
            int total = result.getInt("total");
            
            closeConnection();
            return total;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public int countInStock(int id_alat) {
        try {
            String query = "SELECT jumlah FROM alat WHERE id_alat = " + id_alat;
            
            openConnection();
            ResultSet result = statement.executeQuery(query);
            
            result.next();
            
            int total = result.getInt("jumlah");
            int inStock = total - this.countUsed(id_alat);
            closeConnection();
            return inStock;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public boolean isInStock(int id_alat) {
        return this.countInStock(id_alat) > 0;
    }
}
