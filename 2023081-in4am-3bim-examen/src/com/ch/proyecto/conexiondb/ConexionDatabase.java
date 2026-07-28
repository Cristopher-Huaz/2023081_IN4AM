/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ch.proyecto.conexiondb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author almap
 */
public class ConexionDatabase {
    private static ConexionDatabase instanciaConexionDatabase;
    private String userKinal = "IN4AM";
    private String passKinal = "@dmin4AM";
    private String url = "jdbc:mysql://localhost:3306/inicioSesion_bim3_in4am";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private Connection instanciaConnection;

    
    private ConexionDatabase(){
        try{
            Class.forName(DRIVER);
             instanciaConnection = DriverManager.getConnection(url, userKinal, passKinal);
        }catch(ClassNotFoundException errorClassNotFound){
            JOptionPane.showMessageDialog(null, "Error Clase no encontrada");
            errorClassNotFound.printStackTrace();
        }catch(SQLException errorSQL){
            JOptionPane.showMessageDialog(null, "Error SQL");
            errorSQL.printStackTrace();
        }catch(Exception errorPadre){
            JOptionPane.showMessageDialog(null, "Error Padre");
            errorPadre.printStackTrace();
        }
    }

    public static ConexionDatabase getInstanciaConexionDatabase() {
        if(instanciaConexionDatabase == null)
            instanciaConexionDatabase = new ConexionDatabase();
        return instanciaConexionDatabase;
    }

    public Connection getInstanciaConnection() {
        return instanciaConnection;
    }
    
}
