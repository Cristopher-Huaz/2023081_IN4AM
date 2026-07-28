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
 * @author almap
 */
public class RegistroUsuarioView extends BorderPane{
    private static RegistroUsuarioView instanciaRegistroUsuarioView;
    private HBox barraOpcionesVentana;
    private Button btnCerrarVentana;
    private Label lblTituloVentana;
    
    //Label
    private Label lblUsername;
    private Label lblNombres;
    private Label lblApellidos;
    private Label lblContraseña;
    private Label lblConfirmarContraseña;
    private Label lblCorreo;
   //
   private VBox cajaVertical;
   private GridPane cuadricula;
   private Label lblRegistrarse;
   //
    //Text field
    private TextField txtNombres;
    private TextField txtApellidos;
    private TextField txtCorreo;
    private TextField txtUsername;
    //PasswordField
    private PasswordField pwdContraseña;
    private PasswordField pwdConfirmarContraseña;
    //Boton
    private Button btnRegistrarse;
    
    
    //Constructor
    public RegistroUsuarioView(){
        this.setPadding(new Insets(10));
        //FONDO
        this.setBackground(new Background(
                new BackgroundFill(Paint.valueOf("#AFC06A"),
                new CornerRadii(20),
                Insets.EMPTY)
        ));
        // Barra de cerrar Ventana e informacion
        barraOpcionesVentana = new HBox(10);
        btnCerrarVentana = new Button("X");
        lblTituloVentana = new Label("REGISTRO E INICIO DE SESION");
        barraOpcionesVentana.getChildren().addAll(lblTituloVentana, btnCerrarVentana);
        this.setTop(barraOpcionesVentana);
        
        cajaVertical = new VBox(10);
        cuadricula = new GridPane();
        
        lblUsername = new Label("Nombre Usuario");
        txtUsername = new TextField();
        txtUsername.setPromptText("Username");
        
        lblNombres = new Label("Nombres");
        txtNombres = new TextField();
        txtNombres.setPromptText("Nombres");
        
        lblApellidos = new Label("Apellidos");
        txtApellidos = new TextField();
        txtApellidos.setPromptText("Apellidos");
        
        lblCorreo = new Label("Correo");
        txtCorreo = new TextField();
        txtCorreo.setPromptText("Correo");
        
        lblContraseña = new Label("Ingrese su Contraseña");
        pwdContraseña = new PasswordField();
        pwdContraseña.setPromptText("Contraseña");
        
        lblConfirmarContraseña = new Label("Confirme su Contraseña");
        pwdConfirmarContraseña = new PasswordField();
        pwdConfirmarContraseña.setPromptText("Confirme su Contraseña");
        
        cuadricula.add( lblUsername, 0, 0);
        cuadricula.add( txtUsername, 1, 0);
        cuadricula.add( lblNombres,  0, 1);
        cuadricula.add( txtNombres, 1, 1);
        cuadricula.add( lblApellidos, 0, 2);
        cuadricula.add( txtApellidos, 1, 2);
        cuadricula.add( lblCorreo, 0, 3);
        cuadricula.add( txtCorreo, 1, 3);
        cuadricula.add( lblContraseña, 0, 4);
        cuadricula.add( pwdContraseña, 1, 4);
        cuadricula.add( lblConfirmarContraseña, 0, 5);
        cuadricula.add( pwdConfirmarContraseña, 1, 5);
        
        btnRegistrarse = new Button("Registrarse");
        lblRegistrarse = new Label("Registrarse");
        
        lblRegistrarse.setAlignment(Pos.CENTER);
        
        lblRegistrarse.setFont(new Font("Arial", 25));
        cajaVertical.setAlignment(Pos.CENTER);
        cajaVertical.getChildren().addAll(
        lblRegistrarse, cuadricula, btnRegistrarse
        );
        this.setCenter(cajaVertical);
        
    }
    
    //Getter de la instancia
    public static RegistroUsuarioView getinstanciaRegistroUsuarioView(){
            if( instanciaRegistroUsuarioView == null )
            instanciaRegistroUsuarioView = new RegistroUsuarioView();
        return instanciaRegistroUsuarioView;
    }
    
    //GETTERS Y SETTERS
    public static void setInstanciaRegistroUsuarioView(RegistroUsuarioView instanciaRegistroUsuarioView) {
        RegistroUsuarioView.instanciaRegistroUsuarioView = instanciaRegistroUsuarioView;
    }

    public HBox getBarraOpcionesVentana() {
        return barraOpcionesVentana;
    }

    public void setBarraOpcionesVentana(HBox barraOpcionesVentana) {
        this.barraOpcionesVentana = barraOpcionesVentana;
    }

    public Button getBtnCerrarVentana() {
        return btnCerrarVentana;
    }

    public void setBtnCerrarVentana(Button btnCerrarVentana) {
        this.btnCerrarVentana = btnCerrarVentana;
    }

    public Label getLblTituloVentana() {
        return lblTituloVentana;
    }

    public void setLblTituloVentana(Label lblTituloVentana) {
        this.lblTituloVentana = lblTituloVentana;
    }

    public Label getLblUsername() {
        return lblUsername;
    }

    public void setLblUsername(Label lblUsername) {
        this.lblUsername = lblUsername;
    }

    public Label getLblNombres() {
        return lblNombres;
    }

    public void setLblNombres(Label lblNombres) {
        this.lblNombres = lblNombres;
    }

    public Label getLblApellidos() {
        return lblApellidos;
    }

    public void setLblApellidos(Label lblApellidos) {
        this.lblApellidos = lblApellidos;
    }

    public Label getLblContraseña() {
        return lblContraseña;
    }

    public void setLblContraseña(Label lblContraseña) {
        this.lblContraseña = lblContraseña;
    }

    public Label getLblConfirmarContraseña() {
        return lblConfirmarContraseña;
    }

    public void setLblConfirmarContraseña(Label lblConfirmarContraseña) {
        this.lblConfirmarContraseña = lblConfirmarContraseña;
    }

    public Label getLblCorreo() {
        return lblCorreo;
    }

    public void setLblCorreo(Label lblCorreo) {
        this.lblCorreo = lblCorreo;
    }

    public VBox getCajaVertical() {
        return cajaVertical;
    }

    public void setCajaVertical(VBox cajaVertical) {
        this.cajaVertical = cajaVertical;
    }

    public GridPane getCuadricula() {
        return cuadricula;
    }

    public void setCuadricula(GridPane cuadricula) {
        this.cuadricula = cuadricula;
    }

    public Label getLblRegistrarse() {
        return lblRegistrarse;
    }

    public void setLblRegistrarse(Label lblRegistrarse) {
        this.lblRegistrarse = lblRegistrarse;
    }

    public TextField getTxtNombres() {
        return txtNombres;
    }

    public void setTxtNombres(TextField txtNombres) {
        this.txtNombres = txtNombres;
    }

    
    public TextField getTxtApellidos() {
        return txtApellidos;
    }

    public void setTxtApellidos(TextField txtApellidos) {
        this.txtApellidos = txtApellidos;
    }

    public TextField getTxtCorreo() {
        return txtCorreo;
    }

    public void setTxtCorreo(TextField txtCorreo) {
        this.txtCorreo = txtCorreo;
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

    public PasswordField getPwdConfirmarContraseña() {
        return pwdConfirmarContraseña;
    }

    public void setPwdConfirmarContraseña(PasswordField pwdConfirmarContraseña) {
        this.pwdConfirmarContraseña = pwdConfirmarContraseña;
    }

    public Button getBtnRegistrarse() {
        return btnRegistrarse;
    }

    public void setBtnRegistrarse(Button btnRegistrarse) {
        this.btnRegistrarse = btnRegistrarse;
    }
    
}   
