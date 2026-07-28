/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ch.proyecto.controller;

import com.ch.proyecto.view.IniciarSesionView;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import com.ch.proyecto.view.RegistroUsuarioView;
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
    
    public void cambiarEscenaPrincipal(Pane panel, int ancho, int alto){
         try{
             escenaPrincipal = new Scene(panel, ancho, alto);
             escenarioPrincipal.setScene(escenaPrincipal);
             escenarioPrincipal.sizeToScene();
             escenarioPrincipal.show();
         }catch(NullPointerException objetoNulo){
             JOptionPane.showMessageDialog(null, "Error de objeto nulo: Cambiar Escena Principal");
             objetoNulo . printStackTrace(); 
         }catch(Exception errorPadre){
            JOptionPane.showMessageDialog(null, "Error padre: Cambiar Escena Principal");
            errorPadre. printStackTrace();
         }
    }
    // VENTANA DE REGISTRO USUARIO
    public void ventanaRegistroUsuario(){
        try{
            this.escenarioPrincipal.initStyle(StageStyle.TRANSPARENT);
            RegistroUsuarioView registro = RegistroUsuarioView.getinstanciaRegistroUsuarioView();
            cambiarEscenaPrincipal(registro, 450 , 500);
            this.escenaPrincipal.setFill(Color.TRANSPARENT);  
            new  RegistroUsuarioController(registro);
        }catch(NullPointerException objetoNulo){
             JOptionPane.showMessageDialog(null, "Error de objeto nulo: Ventana Registro Usuario");
             objetoNulo . printStackTrace(); 
         }catch(Exception errorPadre){
            JOptionPane.showMessageDialog(null, "Error padre: Ventana Registro");
            errorPadre. printStackTrace();
         }
    }
    //VENTANA INICIO DE SESION
    public void ventanaInicioSesionUsuario(){
        try{
            escenarioSecundario = new Stage();
            this.escenarioSecundario.initStyle(StageStyle.TRANSPARENT);
            this.escenarioSecundario.initModality(Modality.APPLICATION_MODAL);
            
            RegistroUsuarioView bienvenida = new RegistroUsuarioView();
            
            escenaPrincipal = new Scene( bienvenida, 200, 300);
            this.escenarioSecundario.setScene(escenaPrincipal);
            this.escenarioSecundario.sizeToScene();
            this.escenarioSecundario.showAndWait();
            
            
        }catch(NullPointerException objetoNulo){
             JOptionPane.showMessageDialog(null, "Error de objeto nulo: Ventana Inicio Sesion Usuario");
             objetoNulo . printStackTrace(); 
         }catch(Exception errorPadre){
            JOptionPane.showMessageDialog(null, "Error padre: Ventana Inicio sesion");
            errorPadre. printStackTrace();
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
