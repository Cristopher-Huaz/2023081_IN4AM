package com.ch.proyecto.view;

import com.ch.proyecto.controller.UsuarioRegistroController;
import com.ch.proyecto.model.UsuarioRegistro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author almap
 */
public class VentanaOpciones extends BorderPane {

    public static VentanaOpciones instanciaVentanaOpcionesView;

    //Barra Ventana
    private HBox barraVentana;
    private Label lblTituloVentana;
    private Button btnCerrarVentana;

    //Botones de acciones (columna izquierda, como en tu boceto)
    private VBox cajaBotones;
    private Button btnAgregar;
    private Button btnEditar;
    private Button btnEliminar;
    private Button btnListar;
    private Button btnCancelar;

    //Formulario
    private GridPane form;
    private TextField txtUsername;
    private TextField txtNombres;
    private TextField txtApellidos;
    private TextField txtCorreo;
    private TextField txtClave;

    //Tabla
    private TableView<UsuarioRegistro> tblUsuarios;
    private TableColumn<UsuarioRegistro, String> colId;
    private TableColumn<UsuarioRegistro, String> colUsername;
    private TableColumn<UsuarioRegistro, String> colNombres;
    private TableColumn<UsuarioRegistro, String> colApellidos;
    private TableColumn<UsuarioRegistro, String> colCorreo;

    private ObservableList<UsuarioRegistro> listaObservableUsuarios;

    public VentanaOpciones() {
        construirBarraVentana();
        construirFormulario();
        construirTabla();
        construirBotones();
        cargarDatos();
        construirAcciones();

        this.setTop(barraVentana);
        this.setLeft(cajaBotones);
        this.setCenter(tblUsuarios);
        this.setBottom(form);
    }

    private void construirBarraVentana() {
        barraVentana = new HBox();
        btnCerrarVentana = new Button("X");
        lblTituloVentana = new Label("GESTION DE USUARIOS");
        barraVentana.getChildren().addAll(btnCerrarVentana, lblTituloVentana);
    }

    private void construirBotones() {
        cajaBotones = new VBox(15);
        btnAgregar = new Button("Agregar");
        btnEditar = new Button("Editar");
        btnEliminar = new Button("Eliminar");
        btnListar = new Button("Listar");
        btnCancelar = new Button("Cancelar");

        cajaBotones.getChildren().addAll(btnAgregar, btnEditar, btnEliminar, btnListar, btnCancelar);
    }

    private void construirFormulario() {
        form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);

        txtUsername = new TextField();
        txtNombres = new TextField();
        txtApellidos = new TextField();
        txtCorreo = new TextField();
        txtClave = new TextField();

        form.add(new Label("Username"), 0, 0);
        form.add(txtUsername, 1, 0);
        form.add(new Label("Nombres"), 0, 1);
        form.add(txtNombres, 1, 1);
        form.add(new Label("Apellidos"), 0, 2);
        form.add(txtApellidos, 1, 2);
        form.add(new Label("Correo"), 0, 3);
        form.add(txtCorreo, 1, 3);
        form.add(new Label("Clave"), 0, 4);
        form.add(txtClave, 1, 4);
    }

    private void construirTabla() {
        tblUsuarios = new TableView<>();

        colId = new TableColumn<>("Id");
        colUsername = new TableColumn<>("Username");
        colNombres = new TableColumn<>("Nombres");
        colApellidos = new TableColumn<>("Apellidos");
        colCorreo = new TableColumn<>("Correo");

        colId.setCellValueFactory(new PropertyValueFactory<>("idUser"));
        colUsername.setCellValueFactory(new PropertyValueFactory<>("nombreUsername"));
        colNombres.setCellValueFactory(new PropertyValueFactory<>("nombresUsuario"));
        colApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidosUsuario"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correoUsuario"));

        tblUsuarios.getColumns().addAll(colId, colUsername, colNombres, colApellidos, colCorreo);
    }

    public void cargarDatos() {
        UsuarioRegistroController controller = new UsuarioRegistroController();
        controller.readUsuarios(); // trae los usuarios desde la BD

        listaObservableUsuarios = FXCollections.observableArrayList(controller.getUsuarioRegistrosDB());
        tblUsuarios.setItems(listaObservableUsuarios);
    }

    public void construirAcciones() {
        //Al seleccionar una fila, llena el formulario con esos datos
        tblUsuarios.getSelectionModel().selectedItemProperty().addListener((observable, seleccionAnterior, seleccionNueva) -> {
            if (seleccionNueva != null) {
                txtUsername.setText(seleccionNueva.getNombreUsername());
                txtNombres.setText(seleccionNueva.getNombresUsuario());
                txtApellidos.setText(seleccionNueva.getApellidosUsuario());
                txtCorreo.setText(seleccionNueva.getCorreoUsuario());
            }
        });
    }

    //INSTANCIA (Singleton)
    public static VentanaOpciones getinstanciaVentanaOpcionesView() {
        if (instanciaVentanaOpcionesView == null)
            instanciaVentanaOpcionesView = new VentanaOpciones();
        return instanciaVentanaOpcionesView;
    }

    //GETTERS de botones y campos (para el controller)
    public Button getBtnCerrarVentana() {
        return btnCerrarVentana;
    }

    public Button getBtnAgregar() {
        return btnAgregar;
    }

    public Button getBtnEditar() {
        return btnEditar;
    }

    public Button getBtnEliminar() {
        return btnEliminar;
    }

    public Button getBtnListar() {
        return btnListar;
    }

    public Button getBtnCancelar() {
        return btnCancelar;
    }

    public TableView<UsuarioRegistro> getTblUsuarios() {
        return tblUsuarios;
    }

    public TextField getTxtUsername() {
        return txtUsername;
    }

    public TextField getTxtNombres() {
        return txtNombres;
    }

    public TextField getTxtApellidos() {
        return txtApellidos;
    }

    public TextField getTxtCorreo() {
        return txtCorreo;
    }

    public TextField getTxtClave() {
        return txtClave;
    }
}