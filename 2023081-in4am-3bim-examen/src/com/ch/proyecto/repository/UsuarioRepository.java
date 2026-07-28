/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ch.proyecto.repository;

import com.ch.proyecto.conexiondb.ConexionDatabase;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author almap
 */
public class UsuarioRepository {
        public void crearUsuario(String username, String nombres, String apellidos, String correo, String clave){
            try{
                PreparedStatement prepararLlamada = ConexionDatabase
                                                                                            .getInstanciaConexionDatabase()
                                                                                            .getInstanciaConnection()
                                                                                            .prepareCall("{call sp_create_User(?, ?, ?, ?, ?)}");
                prepararLlamada.setString( 1, username);
                prepararLlamada.setString( 2, nombres);
                prepararLlamada.setString( 3, apellidos);
                prepararLlamada.setString( 4, correo);
                prepararLlamada.setString( 5, clave);
                                prepararLlamada.execute();
            }catch(SQLException errorSQL){
                JOptionPane.showMessageDialog(null, "Error al guardar el Usuario");
                errorSQL.printStackTrace();
            }catch (Exception errorPadre){
                   JOptionPane.showMessageDialog(null, "Error Padre");
                   errorPadre.printStackTrace();
            }
        }
        
        public boolean loginUsuario(String username, String clave){
            boolean loginExitoso = false;
            try{
                PreparedStatement prepararLlamada = ConexionDatabase.
                                                                                              getInstanciaConexionDatabase()
                                                                                             .getInstanciaConnection()
                                                                                             .prepareCall("{call sp_login_user(?, ?)}");
                prepararLlamada.setString(1, username);
                prepararLlamada.setString(2, clave);
                
                    ResultSet resultado = prepararLlamada.executeQuery();
                    
                    if (resultado.next()){
                        loginExitoso = true;
                            }
               
            }catch(SQLException errorSQL){
                JOptionPane.showMessageDialog(null, "Error con el Login");
                errorSQL.printStackTrace();
            }catch(Exception errorPadre){
                JOptionPane.showMessageDialog(null, "Error Padre");
                errorPadre.printStackTrace();
            }
            return loginExitoso;
        }
}
