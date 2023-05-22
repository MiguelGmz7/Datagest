/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app;

import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Oscar Miguel Gómez López
 */
public class Cconexion {
    
    private final String user = "postgres";
    private final String password = "volomanere";
    private final String bd = "datagest";
    private final String ip = "localhost";
    private final String port = "5432";
    private Connection conectar = null;
    private final String url = "jdbc:postgresql://"+ip+":"+port+"/"+bd; 
    
    
    public Connection EstablecerConexion() {
        try {
            Class.forName("org.postgresql.Driver");
            conectar = DriverManager.getConnection(url, user, password);
        } catch (Exception e){
        //JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: \n"+e.toString());
    }
       return conectar;
    }

}
