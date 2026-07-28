/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ch.proyecto.controller;
import com.ch.proyecto.repository.UsuarioRepository;
import com.ch.proyecto.view.LoginUsuarioView;
import com.ch.proyecto.view.LoginUsuarioView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
/**
 *
 * @author almap
 */
public class LoginUsuarioController {
   private final LoginUsuarioView LOGIN_VIEW;
    public LoginUsuarioController (LoginUsuarioView LOGIN_VIEW) {
        this.LOGIN_VIEW = LOGIN_VIEW;
        construirAcciones();
    }
    
    public void construirAcciones(){
           this.LOGIN_VIEW.getBtnCerrarVentanaLogin().setOnMouseClicked(
   (e)-> {
       System.exit(0);
   } 
    );
           //cambiar entre ventanas
           this.LOGIN_VIEW.getBtnCambiarARegistro().setOnMouseClicked(
           e -> {
               Stage stageLogin = (Stage) this.LOGIN_VIEW.getScene().getWindow();
               stageLogin.close();
               SceneManagerController.getInstanciaSceneManagerController().ventanaRegistroUsuario();
           }
            );
           this.LOGIN_VIEW.getBtnIniciarSesion().setOnMouseClicked(
           
                   e -> {
                       iniciarSesion();
                   }
           );
    }
    
    //metodoa
    public void iniciarSesion(){
        String nombreUsername = this.LOGIN_VIEW.getTxtNombreUsername().getText().trim();
        String passwordUSer = this.LOGIN_VIEW.getPwdContraseñaUser().getText().trim();
        
        if (nombreUsername.isEmpty() )
            JOptionPane.showMessageDialog(null, "No deje el nombre de Usuario vacio");
        else if (passwordUSer.isEmpty())
            JOptionPane.showMessageDialog(null, "Ingrese La contraseña de su Usuario");
        else {
            UsuarioRepository usuarioRepo = new UsuarioRepository();
            boolean estadoLogin = usuarioRepo.loginUsuario(nombreUsername, passwordUSer);
            
            if (estadoLogin){
                JOptionPane.showMessageDialog(null, "Bienvenido");
                SceneManagerController.getInstanciaSceneManagerController().ventanaOpciones();
            }
            else
                JOptionPane.showMessageDialog(null, "El usuario o la contraseña son Incorrectos");
        }
    }
    }