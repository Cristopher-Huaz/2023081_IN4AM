/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ch.proyecto.view;

import com.ch.proyecto.controller.ImagenController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

/**
 *
 * @author almap
 */
public class LoginUsuarioView extends BorderPane{
    public static LoginUsuarioView instanciaLoginUsuarioView;
    
    //BARRA OPCIONES
    private HBox cajaBarraVentana;
    private Button btnCerrarVentanaLogin;
    private Label lblTituloVentanaLogin;
    
    
    //VBOx
    private VBox cajaVerticalLogin;
    //TEXTFIELD
    private TextField txtNombreUsername;
    //PSWFIELD
    private PasswordField pwdContraseñaUser;
    //BUTTONS
    private Button btnIniciarSesion;
    private Button btnCambiarARegistro;
    //LAbels
    private Label lblIniciarSesion;
    private Label lblNombreUsername;
    private Label lblContraseñaUser;
    //GRID
    private GridPane cuadriculaLogin;
    //IMAGEN
    private ImageView imgLogin;
    
    public LoginUsuarioView(){
    this.setPadding(new Insets(5));
        //FONDO
        this.setBackground(new Background(
                new BackgroundFill(Paint.valueOf("#E65A96"),
                        new CornerRadii(25),
                        Insets.EMPTY)
        ));
        
        //ELEMENTOS DE LA VENTANA PERSONALIZADA
        cajaBarraVentana= new HBox();
        btnCerrarVentanaLogin = new Button("X");
        lblTituloVentanaLogin = new Label("INICIO SESION EXAMEN");
        
        cajaBarraVentana.getChildren().addAll(btnCerrarVentanaLogin, lblTituloVentanaLogin);
        this.setTop(cajaBarraVentana);
        
        //ELEMENTOS DE LA VENTANA
        cajaVerticalLogin = new VBox(20);
        cuadriculaLogin = new GridPane();
        
        lblNombreUsername = new Label("Nombre Usuario");
        txtNombreUsername = new TextField();
        txtNombreUsername.setPromptText("Username");
        
        lblContraseñaUser = new Label("Contraseña");
        pwdContraseñaUser = new PasswordField();
        pwdContraseñaUser.setPromptText("Password");
        
        btnIniciarSesion = new Button("Iniciar Sesion");
        btnCambiarARegistro = new Button("Registrar Usuario");
        
        cuadriculaLogin.add(lblNombreUsername, 0, 0);
        cuadriculaLogin.add(txtNombreUsername, 1, 0);
        cuadriculaLogin.add(lblContraseñaUser, 0, 2);
        cuadriculaLogin.add(pwdContraseñaUser, 1, 2);
        
        cuadriculaLogin.add(btnIniciarSesion, 0, 3);
        cuadriculaLogin.add(btnCambiarARegistro, 1, 3);
        
        lblIniciarSesion = new Label("Iniciar Sesion");
        lblIniciarSesion.setFont(new Font("Arial", 45));
        lblIniciarSesion.setTextFill(Color.WHITE);
                
        lblContraseñaUser.setFont(new Font("Arial", 20));
        lblContraseñaUser.setTextFill(Color.WHITE);
        
        lblNombreUsername.setFont(new Font("Arial", 20));
        lblNombreUsername.setTextFill(Color.WHITE);
        
        lblTituloVentanaLogin.setFont(new Font("Arial", 20));
        lblTituloVentanaLogin.setTextFill(Color.WHITE);
        
        imgLogin = new ImageView(new ImagenController().getImageLogin("Login"));
        imgLogin.setFitHeight(200);
        imgLogin.setFitWidth(200);
        Circle clip = new Circle(100, 100, 100);
        imgLogin.setClip(clip);
        
        cajaVerticalLogin.setAlignment(Pos.CENTER);
        
        cajaVerticalLogin.getChildren().addAll(lblIniciarSesion, imgLogin, cuadriculaLogin);
        this.setCenter(cajaVerticalLogin);
    }
    //INSTANCIA

    public static LoginUsuarioView getInstanciaLoginUsuarioView() {
        if(instanciaLoginUsuarioView == null)
            instanciaLoginUsuarioView = new LoginUsuarioView();
       return instanciaLoginUsuarioView;
    }
    //GETTERS Y SETTERS

    public HBox getCajaBarraVentana() {
        return cajaBarraVentana;
    }

    public void setCajaBarraVentana(HBox cajaBarraVentana) {
        this.cajaBarraVentana = cajaBarraVentana;
    }

    public Button getBtnCerrarVentanaLogin() {
        return btnCerrarVentanaLogin;
    }

    public void setBtnCerrarVentanaLogin(Button btnCerrarVentanaLogin) {
        this.btnCerrarVentanaLogin = btnCerrarVentanaLogin;
    }

    public Label getLblTituloVentanaLogin() {
        return lblTituloVentanaLogin;
    }

    public void setLblTituloVentanaLogin(Label lblTituloVentanaLogin) {
        this.lblTituloVentanaLogin = lblTituloVentanaLogin;
    }

    public VBox getCajaVerticalLogin() {
        return cajaVerticalLogin;
    }

    public void setCajaVerticalLogin(VBox cajaVerticalLogin) {
        this.cajaVerticalLogin = cajaVerticalLogin;
    }

    public TextField getTxtNombreUsername() {
        return txtNombreUsername;
    }

    public void setTxtNombreUsername(TextField txtNombreUsername) {
        this.txtNombreUsername = txtNombreUsername;
    }

    public PasswordField getPwdContraseñaUser() {
        return pwdContraseñaUser;
    }

    public void setPwdContraseñaUser(PasswordField pwdContraseñaUser) {
        this.pwdContraseñaUser = pwdContraseñaUser;
    }

    public Button getBtnIniciarSesion() {
        return btnIniciarSesion;
    }

    public void setBtnIniciarSesion(Button btnIniciarSesion) {
        this.btnIniciarSesion = btnIniciarSesion;
    }

    public Button getBtnCambiarARegistro() {
        return btnCambiarARegistro;
    }

    public void setBtnCambiarARegistro(Button btnCambiarARegistro) {
        this.btnCambiarARegistro = btnCambiarARegistro;
    }

    public Label getLblIniciarSesion() {
        return lblIniciarSesion;
    }

    public void setLblIniciarSesion(Label lblIniciarSesion) {
        this.lblIniciarSesion = lblIniciarSesion;
    }

    public Label getLblNombreUsername() {
        return lblNombreUsername;
    }

    public void setLblNombreUsername(Label lblNombreUsername) {
        this.lblNombreUsername = lblNombreUsername;
    }

    public Label getLblContraseñaUser() {
        return lblContraseñaUser;
    }

    public void setLblContraseñaUser(Label lblContraseñaUser) {
        this.lblContraseñaUser = lblContraseñaUser;
    }

    public GridPane getCuadriculaLogin() {
        return cuadriculaLogin;
    }

    public void setCuadriculaLogin(GridPane cuadriculaLogin) {
        this.cuadriculaLogin = cuadriculaLogin;
    }

    public ImageView getImgLogin() {
        return imgLogin;
    }

    public void setImgLogin(ImageView imgLogin) {
        this.imgLogin = imgLogin;
    }
    
}
