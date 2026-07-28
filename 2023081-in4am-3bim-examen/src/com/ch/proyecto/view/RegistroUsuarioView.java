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
import javafx.scene.image.Image;
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
    private Label lblRegistro;
    
    //Text field
    private TextField txtUsername;
    private TextField txtNombre;
    private TextField txtApellidos;
    private TextField txtCorreo;
    //PasswordField
    private PasswordField pwdContraseña;
    private PasswordField pwdConfirmarContraseña;
    //Boton
    private Button btnRegistrarse;
    private Button btnCambiarALogin;
    //VBOX
    private VBox cajaV;
    //GRID
    private GridPane cuadriculaRegistro;
   //IMAGEN 
   private ImageView imgRegistro;
    
    private RegistroUsuarioView(){
        this.setPadding(new Insets(5));
        //FONDO
        this.setBackground(new Background(
                new BackgroundFill(Paint.valueOf("#1D63BF"),
                        new CornerRadii(25),
                        Insets.EMPTY)
        ));
        //INSTANCIAR LOS ELEMENTOS DE LA VENTANA PERSONALIZADA
        barraOpcionesVentana = new HBox();
        btnCerrarVentana = new Button("X");
        lblTituloVentana = new Label("REGISTRO USUARIO EXAMEN");
        
        barraOpcionesVentana.getChildren().addAll(btnCerrarVentana, lblTituloVentana);
        
        this.setTop(barraOpcionesVentana);
        
        //OBJETOS DEL REGISTRO DE USUARIO
        cajaV = new VBox(20);
        cuadriculaRegistro = new GridPane();
        
        //COMPONENTES
        lblUsername = new Label("Ingrese su Username");
        txtUsername = new TextField();
        txtUsername.setPromptText("Ingrese Nombre Usuario");
        
        lblNombres = new Label("Ingrese su Nombre");
        txtNombre = new TextField();
        txtNombre.setPromptText("Ingrese su Nombre");
        
        lblApellidos = new Label("Ingrese su Apellido");
        txtApellidos = new TextField();
        txtApellidos.setPromptText("Ingrese sus Apellidos");
        
        lblCorreo = new Label("Ingrese su correo");
        txtCorreo = new TextField();
        txtCorreo.setPromptText("Ingrese su correo");
        
        lblContraseña = new Label("Ingrese su Contraseña");
        pwdContraseña = new PasswordField();
        pwdContraseña.setPromptText("Ingrese su contraseña");
        
        lblConfirmarContraseña = new Label("Ingrese su Contraseña");
        pwdConfirmarContraseña = new PasswordField();
        pwdConfirmarContraseña.setPromptText("Ingrese su contraseña");
        
        cuadriculaRegistro.add( lblUsername, 0,0);
        cuadriculaRegistro.add(txtUsername, 1, 0);
        cuadriculaRegistro.add(lblNombres, 0, 1);
        cuadriculaRegistro.add( txtNombre, 1,1);
        cuadriculaRegistro.add(lblApellidos, 0,2);
        cuadriculaRegistro.add(txtApellidos , 1,2);
        cuadriculaRegistro.add( lblCorreo, 0, 3);
        cuadriculaRegistro.add( txtCorreo, 1,3);
        cuadriculaRegistro.add( lblContraseña, 0,4);
        cuadriculaRegistro.add( pwdContraseña, 1,4);
        cuadriculaRegistro.add(lblConfirmarContraseña , 0,5);
        cuadriculaRegistro.add(pwdConfirmarContraseña ,1 ,5);
        
        btnCambiarALogin = new Button("Cambiar a Login");
        btnRegistrarse = new Button("Registrarse");
        
        cuadriculaRegistro.add(btnCambiarALogin, 0, 6);
        cuadriculaRegistro.add(btnRegistrarse, 1,6);
        
        lblRegistro = new Label();
        imgRegistro = new ImageView(new ImagenController().getImageLogin("Registro"));
        imgRegistro.setFitHeight(200);
        imgRegistro.setFitWidth(200);
        Circle clip =  new Circle(100, 100, 100);
        imgRegistro.setClip(clip);
        cajaV.setAlignment(Pos.CENTER);
        //lables colorcito blanco
        
 
        lblRegistro.setFont(new Font("Arial", 20));
        lblRegistro.setTextFill(Color.WHITE);
        
        lblApellidos.setFont(new Font("Arial", 20));
        lblApellidos.setTextFill(Color.WHITE);
        
        lblConfirmarContraseña.setFont(new Font("Arial", 20));
        lblConfirmarContraseña.setTextFill(Color.WHITE);
        
        lblContraseña.setFont(new Font("Arial", 20));
        lblContraseña.setTextFill(Color.WHITE);
        
        lblCorreo.setFont(new Font("Arial", 20));
        lblCorreo.setTextFill(Color.WHITE);
        
        lblNombres.setFont(new Font("Arial", 20));
        lblNombres.setTextFill(Color.WHITE);
        
        lblTituloVentana.setFont(new Font("Arial", 20));
        lblTituloVentana.setTextFill(Color.WHITE);
        
        lblUsername.setFont(new Font("Arial", 20));
        lblUsername.setTextFill(Color.WHITE);
        
        cajaV.getChildren().addAll(lblRegistro, imgRegistro, cuadriculaRegistro);
        this.setCenter(cajaV);
    }
    //GETTERS Y SETTERS
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

    public Label getLblRegistro() {
        return lblRegistro;
    }

    public void setLblRegistro(Label lblRegistro) {
        this.lblRegistro = lblRegistro;
    }

    public TextField getTxtUsername() {
        return txtUsername;
    }

    public void setTxtUsername(TextField txtUsername) {
        this.txtUsername = txtUsername;
    }

    public TextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(TextField txtNombre) {
        this.txtNombre = txtNombre;
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

    public VBox getCajaV() {
        return cajaV;
    }

    public void setCajaV(VBox cajaV) {
        this.cajaV = cajaV;
    }

    public GridPane getCuadriculaRegistro() {
        return cuadriculaRegistro;
    }

    public void setCuadriculaRegistro(GridPane cuadriculaRegistro) {
        this.cuadriculaRegistro = cuadriculaRegistro;
    }

    public ImageView getImgRegistro() {
        return imgRegistro;
    }

    public void setImgRegistro(ImageView imgRegistro) {
        this.imgRegistro = imgRegistro;
    }

    public Button getBtnCambiarALogin() {
        return btnCambiarALogin;
    }

    public void setBtnCambiarALogin(Button btnCambiarALogin) {
        this.btnCambiarALogin = btnCambiarALogin;
    }
    
}   
