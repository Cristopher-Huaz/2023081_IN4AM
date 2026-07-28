/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ch.proyecto.model;

/**
 *
 * @author almap
 */
public class UsuarioRegistro {
   private String idUser;
   private String nombreUsername;
   private String nombresUsuario;
   private String apellidosUsuario;
   private String correoUsuario;
   private String passwordUsuario;

    public UsuarioRegistro() {
    }

    public UsuarioRegistro(String idUser, String nombreUsername, String nombresUsuario, String apellidosUsuario, String correoUsuario, String passwordUsuario) {
        this.idUser = idUser;
        this.nombreUsername = nombreUsername;
        this.nombresUsuario = nombresUsuario;
        this.apellidosUsuario = apellidosUsuario;
        this.correoUsuario = correoUsuario;
        this.passwordUsuario = passwordUsuario;
    }
   
   //GETTERS YSETTERS

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNombreUsername() {
        return nombreUsername;
    }

    public void setNombreUsername(String nombreUsername) {
        this.nombreUsername = nombreUsername;
    }

    public String getNombresUsuario() {
        return nombresUsuario;
    }

    public void setNombresUsuario(String nombresUsuario) {
        this.nombresUsuario = nombresUsuario;
    }

    public String getApellidosUsuario() {
        return apellidosUsuario;
    }

    public void setApellidosUsuario(String apellidosUsuario) {
        this.apellidosUsuario = apellidosUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }
    
}
