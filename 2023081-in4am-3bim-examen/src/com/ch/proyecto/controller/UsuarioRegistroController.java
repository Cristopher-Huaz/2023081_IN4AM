/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ch.proyecto.controller;

import com.ch.proyecto.conexiondb.ConexionDatabase;
import com.ch.proyecto.model.UsuarioRegistro;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author almap
 */
public class UsuarioRegistroController {
    private ArrayList <UsuarioRegistro> listaUsuariosDB = new ArrayList<UsuarioRegistro>();
    
    
    //COMPROBAR SI EL USUARIO EXISTE 
    public boolean buscarNombreUsuario(String nombreUsuarioRegistrar){
        boolean existe = false;
        for(UsuarioRegistro obtenerUsuarioRegistrar : listaUsuariosDB){
            if(obtenerUsuarioRegistrar.getNombreUsername().equals(nombreUsuarioRegistrar))
                existe = true;
        }
        return existe ;
    }
    //COMPROBAR SI EL CORREO YA SE REGISTRO
    public boolean buscarCorreoUsuario(String correoUsuarioRegistrar){
        boolean existe = false;
        for(UsuarioRegistro obtenerCorreoRegistrar : listaUsuariosDB){
            if(obtenerCorreoRegistrar.getCorreoUsuario().equals(correoUsuarioRegistrar))
                existe = true;
        }
        return existe;
    }
    
    //Obtener los usuarios
public void readUsuarios(){
    try{
    PreparedStatement prepararLlamada = ConexionDatabase.getInstanciaConexionDatabase().getInstanciaConnection().prepareCall("{call sp_read_user}");
    ResultSet tablaResultados = prepararLlamada.executeQuery();
    
    listaUsuariosDB.clear();
    while(tablaResultados.next()){
        //Crear el objeto del usuario
    UsuarioRegistro objUsuarioRegistroDB = new UsuarioRegistro();
    
    //irle dando valores
    objUsuarioRegistroDB.setIdUser(tablaResultados.getString("idUser"));
    objUsuarioRegistroDB.setNombreUsername(tablaResultados.getString("username"));
    objUsuarioRegistroDB.setNombresUsuario(tablaResultados.getString("nombres"));
    objUsuarioRegistroDB.setApellidosUsuario(tablaResultados.getString("apellidos"));
    objUsuarioRegistroDB.setCorreoUsuario(tablaResultados.getString("correo"));
    objUsuarioRegistroDB.setPasswordUsuario(tablaResultados.getString("clave"));
    
    
    listaUsuariosDB.add(objUsuarioRegistroDB);
    }
            
}catch (SQLException errorSql){
            JOptionPane.showMessageDialog(null, "Error al leer Usuarios");
}catch (Exception errorPadre){
       JOptionPane.showMessageDialog(null, "Error Padre");
}
}
public ArrayList<UsuarioRegistro> getUsuarioRegistrosDB (){
                    return listaUsuariosDB;
}

    }

