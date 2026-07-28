/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ch.proyecto.controller;

import com.ch.proyecto.view.VentanaOpciones;

/**
 *
 * @author almap
 */
public class VentanaOpcionesController {
    private final VentanaOpciones VENTANA_VIEW;

    public VentanaOpcionesController(VentanaOpciones VENTANA_VIEW) {
        this.VENTANA_VIEW = VENTANA_VIEW;
        construirAcciones();
    }
    
    public void construirAcciones(){
        this.VENTANA_VIEW.getBtnCerrarVentana().setOnMouseClicked(
                e -> {
                    System.exit(0);
                }
        );
    }
}
