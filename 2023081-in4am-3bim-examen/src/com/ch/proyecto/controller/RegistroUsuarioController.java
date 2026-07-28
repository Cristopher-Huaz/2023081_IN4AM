/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ch.proyecto.controller;

import com.ch.proyecto.repository.UsuarioRepository;
import com.ch.proyecto.view.RegistroUsuarioView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author almap
 */
public class RegistroUsuarioController {
    private final RegistroUsuarioView REGISTRO_VIEW;
    private double ejeX = 0;
    private double ejeY = 0;
    private Stage escenario = SceneManagerController.getInstanciaSceneManagerController().getEscenarioPrincipal();

    public RegistroUsuarioController(RegistroUsuarioView REGISTRO_VIEW) {
        this.REGISTRO_VIEW = REGISTRO_VIEW;
        construirAcciones();
    }
    
    public void construirAcciones(){
        //boton borrar
    this.REGISTRO_VIEW.getBtnCerrarVentana().setOnMouseClicked(
   (e)-> {
       System.exit(0);
   } 
    );
        
    this.REGISTRO_VIEW.getBtnRegistrarse().setOnMouseClicked(
            e ->{
                registroUsuarioDB();
            }
    );
    
    this.REGISTRO_VIEW.getBtnCambiarALogin().setOnMouseClicked(
            (e)-> {
                SceneManagerController.getInstanciaSceneManagerController().ventanaLoginusuario();
              }
    );
}
    
    
    //METODOS Acciones
public void registroUsuarioDB(){
    String nombreUsername = this.REGISTRO_VIEW.getTxtUsername().getText().trim();
    String nombresUsuario = this.REGISTRO_VIEW.getTxtNombre().getText().trim();
    String apellidosUsuario = this.REGISTRO_VIEW.getTxtApellidos().getText().trim();
    String correoUsuario = this.REGISTRO_VIEW.getTxtCorreo().getText().trim();
    String passUsuario = this.REGISTRO_VIEW.getPwdContraseña().getText().trim();
    String passConfirmarUsuario = this.REGISTRO_VIEW.getPwdConfirmarContraseña().getText().trim();
//EXTRA---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    UsuarioRegistroController usuarioRegistroController = new UsuarioRegistroController();
    usuarioRegistroController.readUsuarios();
    boolean existeNombreUsername = usuarioRegistroController.buscarNombreUsuario(nombreUsername); // se le da el valor true o false
    boolean existeCorreoUSuario = usuarioRegistroController.buscarCorreoUsuario(correoUsuario);
   //EXTRA ------------------------------------------------------------------------------------------------------------------------------------------------------------------------d
    if(nombreUsername.isEmpty())
        JOptionPane.showMessageDialog(null, "Ingrese nombre de Usuario");
    else if(nombresUsuario.isEmpty())
        JOptionPane.showMessageDialog(null, "Ingrese sus Nombres");
    else if(apellidosUsuario.isEmpty())
        JOptionPane.showMessageDialog(null, "Ingrese sus Apellidos");
    else if(correoUsuario.isEmpty())
        JOptionPane.showMessageDialog(null, "Ingrese su Correo");
    else if(passUsuario.isEmpty())
        JOptionPane.showMessageDialog(null, "Ingrese su Contraseña");
    else if(passConfirmarUsuario.isEmpty())
        JOptionPane.showMessageDialog(null, "Ingrese la contraseña a Confirmar");
    else if(! passConfirmarUsuario.equals(passUsuario))
        JOptionPane.showMessageDialog(null, "La contraseña, y la contraseña a confirmar deben ser iguales");
    else if(existeNombreUsername) //---------------------------------------------------------------------------------------------------------------------------------------------EXTRA
        JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe, elija otro");
    else if(existeCorreoUSuario)
         JOptionPane.showMessageDialog(null, "El correo ya esta registrado en otra cuenta");
    else if(!correoUsuario.contains("@"))
        JOptionPane.showMessageDialog(null, "El correo debe tener @");//--------------------------------------------------------------------------------------------------------
    else {
        UsuarioRepository usuarioRepo = new UsuarioRepository();
        usuarioRepo.crearUsuario(nombreUsername, nombresUsuario, apellidosUsuario, correoUsuario, passUsuario);
        SceneManagerController.getInstanciaSceneManagerController().ventanaLoginusuario();
    }
}
    
}