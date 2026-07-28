/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ch.proyecto.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

/**
 *
 * @author informatica
 */
public class IniciarSesionView extends BorderPane {

    //ATRIBUTOS
    private static IniciarSesionView instanciaIniciarSesionView;
    //COMPONENTES PARA LA VENTANA PERSONALIZADA
    private Label lblBarraInicioSesion;
    private Button btnCerrarVentana;
    private HBox barraVentanaSesion;
    //LABELS
    private Label lblUsername;
    private Label lblContraseña;
    private Label lblInicioSesion;
    //BUTTONs
    private Button btnIniciarSesion;
    //TXTFIELD Y PSSWORDFIELD
    private TextField txtUsername;
    private PasswordField pwdContraseña;
    //GRIDPANE
    private GridPane cuadriculaSesion;
    //VBOX
    private VBox cajaVertical;
    
    //CONSTRUCTOR
    private IniciarSesionView() {
        //FONDO DE LA VENTANA
        this.setBackground(new Background(
                new BackgroundFill(Paint.valueOf("#169DD9"),
                        new CornerRadii(25),
                        Insets.EMPTY)
        ));
        
        barraVentanaSesion = new HBox(10);
        btnCerrarVentana = new Button("X");
        lblBarraInicioSesion = new Label("INICIO DE SESION");
        barraVentanaSesion.getChildren().addAll(lblBarraInicioSesion, btnCerrarVentana);
        this.setTop(barraVentanaSesion);
        
        cajaVertical = new VBox(10);
        cuadriculaSesion = new GridPane();
        
        lblInicioSesion = new Label("INICIAR SESION");
        lblBarraInicioSesion.setFont(new Font("Arial", 25));
        
        lblUsername = new Label("Nombre Usuario");
        txtUsername = new TextField();
        txtUsername.setPromptText("Username");
        
        lblContraseña = new Label("Contraseña");
        pwdContraseña = new PasswordField();
        pwdContraseña.setPromptText("Contraseña");
        
        cuadriculaSesion.add( lblUsername, 0,0);
        cuadriculaSesion.add( txtUsername, 1,0);
        cuadriculaSesion.add( lblContraseña, 0,1);
        cuadriculaSesion.add( pwdContraseña, 1,1);
        
        btnIniciarSesion = new Button("INICIAR SESION");
        cajaVertical.setAlignment(Pos.CENTER);
        
        cajaVertical.getChildren().addAll(lblInicioSesion, cuadriculaSesion, btnIniciarSesion);
    }

    //GETTER DE LA INSTANCIA
    public static IniciarSesionView getInstanciaIniciarSesionView() {
        if (instanciaIniciarSesionView == null) {
            instanciaIniciarSesionView = new IniciarSesionView();
        }
        return instanciaIniciarSesionView;
    }

    public static void setInstanciaIniciarSesionView(IniciarSesionView instanciaIniciarSesionView) {
        IniciarSesionView.instanciaIniciarSesionView = instanciaIniciarSesionView;
    }
        //GETTERS Y SETTERS

    public Label getLblBarraInicioSesion() {
        return lblBarraInicioSesion;
    }

    public void setLblBarraInicioSesion(Label lblBarraInicioSesion) {
        this.lblBarraInicioSesion = lblBarraInicioSesion;
    }

    public Button getBtnCerrarVentana() {
        return btnCerrarVentana;
    }

    public void setBtnCerrarVentana(Button btnCerrarVentana) {
        this.btnCerrarVentana = btnCerrarVentana;
    }

    public HBox getBarraVentanaSesion() {
        return barraVentanaSesion;
    }

    public void setBarraVentanaSesion(HBox barraVentanaSesion) {
        this.barraVentanaSesion = barraVentanaSesion;
    }

    public Label getLblUsername() {
        return lblUsername;
    }

    public void setLblUsername(Label lblUsername) {
        this.lblUsername = lblUsername;
    }

    public Label getLblContraseña() {
        return lblContraseña;
    }

    public void setLblContraseña(Label lblContraseña) {
        this.lblContraseña = lblContraseña;
    }

    public Label getLblInicioSesion() {
        return lblInicioSesion;
    }

    public void setLblInicioSesion(Label lblInicioSesion) {
        this.lblInicioSesion = lblInicioSesion;
    }

    public Button getBtnIniciarSesion() {
        return btnIniciarSesion;
    }

    public void setBtnIniciarSesion(Button btnIniciarSesion) {
        this.btnIniciarSesion = btnIniciarSesion;
    }

    public TextField getTxtUsername() {
        return txtUsername;
    }

    public void setTxtUsername(TextField txtUsername) {
        this.txtUsername = txtUsername;
    }

    public PasswordField getPwdContraseña() {
        return pwdContraseña;
    }

    public void setPwdContraseña(PasswordField pwdContraseña) {
        this.pwdContraseña = pwdContraseña;
    }

    public GridPane getCuadriculaSesion() {
        return cuadriculaSesion;
    }

    public void setCuadriculaSesion(GridPane cuadriculaSesion) {
        this.cuadriculaSesion = cuadriculaSesion;
    }

    public VBox getCajaVertical() {
        return cajaVertical;
    }

    public void setCajaVertical(VBox cajaVertical) {
        this.cajaVertical = cajaVertical;
    }
    
}
