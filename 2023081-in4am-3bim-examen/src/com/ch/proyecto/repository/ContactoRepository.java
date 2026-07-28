package com.ch.proyecto.repository;

import com.ch.proyecto.conexiondb.ConexionDatabase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author almap
 */
public class ContactoRepository {

    // 1. CREAR CONTACTO
    public void agregarContacto(String nombres, String apellidos, String numero, String idUser) {
        try {
            PreparedStatement prepararLlamada = ConexionDatabase
                    .getInstanciaConexionDatabase()
                    .getInstanciaConnection()
                    .prepareCall("{call sp_agregar_contacto(?, ?, ?, ?)}");
                    
            prepararLlamada.setString(1, nombres);
            prepararLlamada.setString(2, apellidos);
            prepararLlamada.setString(3, numero);
            prepararLlamada.setString(4, idUser);

            prepararLlamada.execute();
            
        } catch (SQLException errorSQL) {
            JOptionPane.showMessageDialog(null, "Error al guardar el Contacto");
            errorSQL.printStackTrace();
        } catch (Exception errorPadre) {
            JOptionPane.showMessageDialog(null, "Error Padre");
            errorPadre.printStackTrace();
        }
    }

    // 2. ELIMINAR CONTACTO
    public void eliminarContacto(String contactoId, String idUser) {
        try {
            PreparedStatement prepararLlamada = ConexionDatabase
                    .getInstanciaConexionDatabase()
                    .getInstanciaConnection()
                    .prepareCall("{call sp_eliminar_contacto(?, ?)}");

            prepararLlamada.setString(1, contactoId);
            prepararLlamada.setString(2, idUser);

            prepararLlamada.execute();

        } catch (SQLException errorSQL) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el Contacto");
            errorSQL.printStackTrace();
        } catch (Exception errorPadre) {
            JOptionPane.showMessageDialog(null, "Error Padre");
            errorPadre.printStackTrace();
        }
    }

    // 3. LISTAR CONTACTOS
    public ResultSet listarContactos(String username) {
        ResultSet resultado = null;
        try {
            PreparedStatement prepararLlamada = ConexionDatabase
                    .getInstanciaConexionDatabase()
                    .getInstanciaConnection()
                    .prepareCall("{call sp_listar_contactos(?)}");

            prepararLlamada.setString(1, username);

            resultado = prepararLlamada.executeQuery();

        } catch (SQLException errorSQL) {
            JOptionPane.showMessageDialog(null, "Error al listar los Contactos");
            errorSQL.printStackTrace();
        } catch (Exception errorPadre) {
            JOptionPane.showMessageDialog(null, "Error Padre");
            errorPadre.printStackTrace();
        }
        return resultado;
    }
}