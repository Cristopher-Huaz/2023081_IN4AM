/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ch.proyecto.controller;

import com.ch.proyecto.view.IniciarSesionView;

/**
 *
 * @author informatica
 */
public class InicioSesionController {
    private final IniciarSesionView INICIO_SESION_VIEW;

    
    //constructor
    public InicioSesionController(IniciarSesionView INICIO_SESION_VIEW) {
        this.INICIO_SESION_VIEW = INICIO_SESION_VIEW;
        construirAcciones();
    }
    
    //metodos
    public void construirAcciones(){
        // FUNCION BTN CERRAR VENTANA
        this.INICIO_SESION_VIEW.getBtnCerrarVentana().setOnMouseClicked(
        (e) ->{
            System.exit(0);
        } 
        );
    };
}
