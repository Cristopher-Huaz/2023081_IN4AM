/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ch.proyecto.controller;

import javafx.scene.image.Image;

/**
 *
 * @author almap
 */
public class ImagenController{
    private final String RUTA_IMAGENES = "/com/ch/proyecto/resources/";
    
  public Image getImageLogin( String nombreImagen ){
       Image imagenMostrar;
       
       switch (nombreImagen){
           case "Registro":
               imagenMostrar = new Image(RUTA_IMAGENES+"Quin.jpg");
               break;
           case "Login":
               imagenMostrar = new Image(RUTA_IMAGENES+"Login.jpg");
               break;
                      default:
                imagenMostrar = new Image(RUTA_IMAGENES+"login-logo.png");
       }
       return imagenMostrar;
   }
}
