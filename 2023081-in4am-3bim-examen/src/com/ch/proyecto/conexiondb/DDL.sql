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
call sp_create_User("Xenial","Cris","Huaz", "chuaz2023", "123");
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