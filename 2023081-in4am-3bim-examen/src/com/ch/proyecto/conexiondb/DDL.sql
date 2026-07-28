drop DATABASE if EXISTS inicioSesion_bim3_in4am;
CREATE DATABASE inicioSesion_bim3_in4am;
use inicioSesion_bim3_in4am;

create table Usuario(
    idUser varchar(70) PRIMARY KEY, 
    username varchar(20) UNIQUE,
    nombres varchar(20),
    apellidos varchar(40),
    correo varchar(50) UNIQUE,
    clave VARCHAR(10)
);

create table contactos (
    id_contacto varchar(70)  PRIMARY KEY,
    nombres VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    numero int NOT NULL,
    idUser VARCHAR(70),
    FOREIGN KEY (idUSer) REFERENCES Usuario(idUser)
);
-- CRUDS CREATE, READ, LOGIN
-- CREATE
//
delimiter //
    create procedure sp_create_User(in username_p varchar(20), 
                                    in nombres_p varchar(20), 
                                    in apellidos_p varchar(40), 
                                    in correo_p varchar(50), 
                                    in clave_p varchar(10))
    BEGIN
    insert into Usuario(idUser,username, nombres, apellidos, correo, clave)
        values(UUID(), username_p, nombres_p, apellidos_p, correo_p, clave_p);
    end//
delimiter ;
call sp_create_User("0","Cris","Huaz", "chuaz2023", "123");
call sp_create_User("Marron","Cris","Huaz", "marron@", "1");
--READ
delimiter //
    create procedure sp_read_user()
    BEGIN
    select * from Usuario;
    end//
delimiter ;
call sp_read_user;
-- LOGIN 
delimiter //
    create procedure sp_login_user(in username_p varchar(20), in clave_p varchar(10))
        BEGIN
            SELECT * from usuario where username = username_p and clave = clave_p;

        END //
delimiter ;
call sp_login_user("Xenial", "1");






-- Crear
DELIMITER //
CREATE PROCEDURE sp_agregar_contacto(
    IN nombres_p VARCHAR(50),
    IN apellidos_p VARCHAR(50),
    IN numero_p VARCHAR(20),
    in idUSerf_p VARCHAR(70)
)
BEGIN
    INSERT INTO contactos (id_contacto, nombres, apellidos, numero, idUser)
    VALUES (UUID(), nombres_p, apellidos_p, numero_p, idUserf_p);
END //
DELIMITER ;
--call sp_agregar_contacto("Juanito", "Perez", 3671, "478b1ba3-8aa5-11f1-990b-502e91b19673");


-- ELIMINAR 
DELIMITER //
CREATE PROCEDURE sp_eliminar_contacto(
    IN contactoID_p varchar(70),
    IN idUSer_p varchar(70)
)
BEGIN
    DELETE FROM contactos 
    WHERE id_Contacto = contactoID_p AND idUSer = idUSer_p;
END //
DELIMITER ;

-- read
DELIMITER //
CREATE PROCEDURE sp_listar_contactos(
    IN p_username VARCHAR(50)
)
BEGIN
    SELECT 
        c.id, 
        c.nombres, 
        c.apellidos, 
        c.numero, 
        c.usuario_id 
    FROM contactos c
    INNER JOIN usuarios u ON c.usuario_id = u.id
    WHERE u.usuario = p_username;
END //
DELIMITER ;

/*
private static View2 instanciaView2;
    private Button btnIrVentana1;
    private TableView <Usuario> tblUser;
    private TableColumn<Usuario, String> colNombre;
    private TableColumn<Usuario, String> colApellido;
    private GridPane form;
    private TextField txtNombre;
    private TextField txtApellido;
    private ArrayList <Usuario> listaUsuarios = new ArrayList<>();
    private ObservableList <Usuario> listaObservableUsuarios;

    private View2 (){
        cargarDatos();
        construirTabla();
        form = new GridPane(15, 20);
        form.add(new Label("Ingrese nombres"), 0, 0);
        form.add(txtNombre=new TextField(), 1, 0);
        form.add(new Label("Ingrese apellidos"),0, 1);
        form.add(txtApellido=new TextField(), 1, 1);
        tblUser = new TableView<>();
        tblUser.setItems(listaObservableUsuarios);
        colNombre = new TableColumn<>("Nombres");
        colApellido = new TableColumn<>("Apellidos");
        colNombre.setCellValueFactory(
                new PropertyValueFactory<>("nombre")
        );
        colApellido.setCellValueFactory(
                new PropertyValueFactory<>("apellido")
        );
        tblUser.getColumns().addAll(colNombre, colApellido);
        construirAcciones();
        this.getChildren().addAll(
                new Label("TEXTO DE ETIQUETA VENTANA 1"),
                btnIrVentana1=new Button("CLICK PARA IR A VENTANA 1"),
                form,
                tblUser
        );
    }


    public void cargarDatos(){
        listaUsuarios.add(new Usuario("Kenneth", "Velasquez"));
        listaUsuarios.add(new Usuario("Bryan", "Rodriguez"));
    }

    public void construirAcciones(){
        this.tblUser.setOnMouseClicked((evento) -> {
            seleccionarE();
        });
        this.tblUser.getSelectionModel().selectedItemProperty().addListener((ov, t, t1) -> {
            txtNombre.setText(t1.getNombre());
            txtApellido.setText(t1.getApellido());
        });
    }


    public void seleccionarE(){
        Usuario user = tblUser.getSelectionModel().getSelectedItem();
        System.out.println(user.getNombre());
        System.out.println(user.getApellido());
    }


    public void construirTabla(){
        listaObservableUsuarios = FXCollections.observableArrayList(listaUsuarios);
    }


    public static View2 getInstanciaView2() {
        if( instanciaView2 == null )
            instanciaView2 = new View2();
        return instanciaView2;
    }
 
    public Button getBtnIrVentana1() {
        return btnIrVentana1;
    }
 
    public void setBtnIrVentana1(Button btnIrVentana1) {
        this.btnIrVentana1 = btnIrVentana1;
    }










*/