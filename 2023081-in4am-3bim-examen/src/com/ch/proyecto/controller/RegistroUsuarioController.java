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
 * @author informatica
 */
public class RegistroUsuarioController {
    private final RegistroUsuarioView REGISTRO_VIEW;
    private double posX;
    private double posY;
    private Stage ventana = SceneManagerController.getInstanciaSceneManagerController().getEscenarioPrincipal();
    
    // constructor
    public RegistroUsuarioController(RegistroUsuarioView REGISTRO_VIEW) {
        this.REGISTRO_VIEW = REGISTRO_VIEW;
        construirAcciones();
    }
    
    //Metodos
    public void construirAcciones(){
        /*BOTON CERRAR VENTANA */
        this.REGISTRO_VIEW.getBtnCerrarVentana().setOnMouseClicked( 
                (e)-> {
                System.exit(0);
                }
        );
        /*PARA QUE LA VENTANA SE PUEDA ARRASTRAR*/
        this.REGISTRO_VIEW.setOnMouseDragged(
        (e)-> {
            double desVentanaX = e.getScreenX();
            double desVentanaY = e.getScreenY();
            
            ventana.setX(desVentanaX - posX);
            ventana.setY(desVentanaY - posY);
        }
        );
        
        this.REGISTRO_VIEW.getBtnRegistrarse().setOnMouseClicked(
                (e)-> {
            registrarUsuario();
                }
        );
    }
    
    //METODOS PARA construirAcciones
    public void registrarUsuario(){
        String nombreUsuario = this.REGISTRO_VIEW.getTxtUsername().getText().trim();
        String nombresUsuario = this.REGISTRO_VIEW.getTxtNombres().getText().trim();
        String apellidosUsuario = this.REGISTRO_VIEW.getTxtApellidos().getText().trim();
        String correoUsuario = this.REGISTRO_VIEW.getTxtCorreo().getText().trim();
        String passUsuario = this.REGISTRO_VIEW.getPwdContraseña().getText().trim();
        String passConfirmarUsuario = this.REGISTRO_VIEW.getPwdConfirmarContraseña().getText().trim();
        
        if (nombreUsuario.isEmpty())
            JOptionPane.showMessageDialog(null, "No deje Vacio el UserName");
        else if (nombresUsuario.isEmpty())
            JOptionPane.showMessageDialog(null, "No deje Vacio los Nombres");
        else if (apellidosUsuario.isEmpty())
            JOptionPane.showMessageDialog(null, "No deje Vacio los Apellidos");
        else if (correoUsuario.isEmpty())
            JOptionPane.showMessageDialog(null, "No deje Vacio el correo");
        else if (passUsuario.isEmpty())
            JOptionPane.showMessageDialog(null, "No deje Vacia la contraseña");
        else if (passConfirmarUsuario.isEmpty())
            JOptionPane.showMessageDialog(null, "No deje Vacia el confirmar la contraseña");
        
        else if ( ! passConfirmarUsuario.equals(passUsuario)){
            JOptionPane.showMessageDialog(null, "La constraseña a confirmar debe ser igual a la que ingreso");
        this.REGISTRO_VIEW.getPwdConfirmarContraseña().clear();
        this.REGISTRO_VIEW.getPwdContraseña().clear();
        }
        else{
             
            UsuarioRepository usuarioRepo = new UsuarioRepository();
            
            usuarioRepo.crearUsuarioDB(nombreUsuario, 
                                      nombresUsuario, 
                                      apellidosUsuario, 
                                      correoUsuario, 
                                      passConfirmarUsuario);
         //  SceneManagerController.getInstanciaSceneManagerController().ventanaInicioSesionUsuario();
        }
    }
}
