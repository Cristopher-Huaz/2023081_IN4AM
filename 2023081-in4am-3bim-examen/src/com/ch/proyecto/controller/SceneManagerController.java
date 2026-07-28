/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ch.proyecto.controller;

import com.ch.proyecto.view.LoginUsuarioView;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import com.ch.proyecto.view.RegistroUsuarioView;
import com.ch.proyecto.view.VentanaOpciones;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
/**
 *
 * @author almap
 */
public class SceneManagerController {
    private static SceneManagerController instanciaSceneManagerController;
    private Scene escenaPrincipal; 
    private Stage escenarioPrincipal;
    private Stage escenarioSecundario;
    private Stage escenarioTerciario;
    
    private SceneManagerController(){}
    
      public void cambiarEscenaPrincipal(Pane panel, int ancho, int alto) {
        try {
            if (escenaPrincipal == null) {
                escenaPrincipal = new Scene(panel, ancho, alto);
                escenarioPrincipal.setScene(escenaPrincipal);
            } else {
                escenaPrincipal.setRoot(panel);
                escenarioPrincipal.setWidth(ancho);
                escenarioPrincipal.setHeight(alto);
            }
            escenarioPrincipal.sizeToScene();
            escenarioPrincipal.show();
        } catch (NullPointerException objetoNulo) {
            JOptionPane.showMessageDialog(null, "Error de objeto nulo: Cambiar Escena Principal");
            objetoNulo.printStackTrace();
        } catch (Exception errorPadre) {
            JOptionPane.showMessageDialog(null, "Error padre: Cambiar Escena Principal");
            errorPadre.printStackTrace();
        }
    }
    // VENTANA DE REGISTRO USUARIO
    public void ventanaRegistroUsuario() {
        try {
            this.escenarioPrincipal.hide();
            RegistroUsuarioView registro = RegistroUsuarioView.getinstanciaRegistroUsuarioView();
            cambiarEscenaPrincipal(registro, 500, 600);
            this.escenaPrincipal.setFill(Color.TRANSPARENT);
            new RegistroUsuarioController(registro);
        } catch (NullPointerException objetoNulo) {
            JOptionPane.showMessageDialog(null, "Error Objeto nulo: Ventana Registro de Usuario");
            objetoNulo.printStackTrace();
        } catch (Exception errorPadre) {
            JOptionPane.showMessageDialog(null, "Error Padre: Ventana Registro de Usuario");
            errorPadre.printStackTrace();
        }
    }
    //VENTANA INICIO DE SESION
    public void ventanaLoginusuario() {
        try {
            this.escenarioPrincipal.hide();
            escenarioSecundario = new Stage();
            this.escenarioSecundario.initStyle(StageStyle.TRANSPARENT);
            this.escenarioSecundario.initModality(Modality.APPLICATION_MODAL);
            LoginUsuarioView loginView = new LoginUsuarioView();

            Scene escenaLogin = new Scene(loginView, 400, 600);
            escenaLogin.setFill(Color.TRANSPARENT);
            this.escenarioSecundario.setScene(escenaLogin);
            this.escenarioSecundario.sizeToScene();

            new LoginUsuarioController(loginView);

            this.escenarioSecundario.showAndWait();

        } catch (NullPointerException objetoNulo) {
            JOptionPane.showMessageDialog(null, "Error Objeto nulo: Ventana Login Usuario");
            objetoNulo.printStackTrace();
        } catch (Exception errorPadre) {
            JOptionPane.showMessageDialog(null, "Error Padre: Ventana Login Usuario");
            errorPadre.printStackTrace();
        }
    }
    
    public void ventanaOpciones(){
     try {
            this.escenarioSecundario.hide();
            escenarioTerciario = new Stage();
            this.escenarioTerciario.initStyle(StageStyle.TRANSPARENT);
            this.escenarioTerciario.initModality(Modality.APPLICATION_MODAL);
            VentanaOpciones opcionesView = new VentanaOpciones();

            Scene escenaLogin = new Scene(opcionesView, 400, 600);
            escenaLogin.setFill(Color.TRANSPARENT);
            this.escenarioSecundario.setScene(escenaLogin);
            this.escenarioSecundario.sizeToScene();

            new VentanaOpcionesController(opcionesView);

            this.escenarioSecundario.showAndWait();

        } catch (NullPointerException objetoNulo) {
            JOptionPane.showMessageDialog(null, "Error Objeto nulo: Ventana Login Usuario");
            objetoNulo.printStackTrace();
        } catch (Exception errorPadre) {
            JOptionPane.showMessageDialog(null, "Error Padre: Ventana Login Usuario");
            errorPadre.printStackTrace();
        }
    }
    // Getter de la instancia

    public static SceneManagerController getInstanciaSceneManagerController() {
        if (instanciaSceneManagerController == null)
            instanciaSceneManagerController = new SceneManagerController();
        return instanciaSceneManagerController;
    }
    //GETTERS Y SETTERS

    public Scene getEscenaPrincipal() {
        return escenaPrincipal;
    }

    public void setEscenaPrincipal(Scene escenaPrincipal) {
        this.escenaPrincipal = escenaPrincipal;
    }

    public Stage getEscenarioPrincipal() {
        return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Stage escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }

    public Stage getEscenarioSecundario() {
        return escenarioSecundario;
    }

    public void setEscenarioSecundario(Stage escenarioSecundario) {
        this.escenarioSecundario = escenarioSecundario;
    }

    public Stage getEscenarioTerciario() {
        return escenarioTerciario;
    }

    public void setEscenarioTerciario(Stage escenarioTerciario) {
        this.escenarioTerciario = escenarioTerciario;
    }
    
}
