/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao2;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ADM
 */
public class ConexaoBD1 {
    
    
    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exercicio2Biblioteca", "adm","adm");
        } catch (Exception e) {
            System.err.println(e);
        }

        return conn;
    }


    
}
