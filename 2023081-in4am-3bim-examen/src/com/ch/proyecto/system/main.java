/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.ch.proyecto.system;
import javafx.stage.StageStyle;

import javafx.application.Application;
import com.ch.proyecto.controller.SceneManagerController;
import javafx.stage.Stage;


public class main extends Application{


    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage escenarioRoot){{
        escenarioRoot.initStyle(StageStyle.TRANSPARENT);
    }
        SceneManagerController.getInstanciaSceneManagerController().setEscenarioPrincipal(escenarioRoot);
        SceneManagerController.getInstanciaSceneManagerController().ventanaLoginusuario();
    }
}
