/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;
import Clases.ClsVotante;
import Clases.ClsJdbc;
import Clases.ClsMensaje;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 *
 * @author Jirs bautista
 */
public class MdlVotante {

    ClsJdbc jdbc;

    public MdlVotante() {
        this.jdbc = new ClsJdbc();
        this.jdbc.CrearConexion();
    }

    public ClsMensaje eliminarvotante(String id) {

        ClsMensaje mensaje;

        try {
            String sql = "DELETE FROM tbl_votantes WHERE id_votante = ?";
            
            
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, id);

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {

                mensaje = new ClsMensaje(ClsMensaje.OK, "Has eliminado un votante exitosamente");
                return mensaje;
            }

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy ocurrió un error");
            return mensaje;

        } catch (Exception excepcion) {

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy ocurrió un error: " + excepcion.getMessage());
            return mensaje;
        }

    }
    
    

    public ClsMensaje agregarvotante(ClsVotante votante) {

        ClsMensaje mensaje;

        try {
            String sql = "INSERT INTO tbl_votantes VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, votante.getNumeroCedula());
            sentencia.setString(2, votante.getNombre());
            sentencia.setString(3, votante.getCorreo());
            sentencia.setString(4, votante.getTelefono());
            sentencia.setString(5, votante.getDireccion());
            sentencia.setString(6, votante.getCiudadOrigen());

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {

                mensaje = new ClsMensaje(ClsMensaje.OK, "Has creado un votante exitosamente");
                return mensaje;
            }

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy ocurrió un error");
            return mensaje;

        } catch (Exception excepcion) {

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy ocurrió un error: " + excepcion.getMessage());
            return mensaje;
        }

    }
    
    
    public ClsMensaje actualizarvotante(ClsVotante votante) {

        ClsMensaje mensaje;

        try {
            String sql = "UPDATE tbl_votantes SET nombre = ?, correo = ?, telefono = ?, " +
                    " direccion = ?, " +
                    " ciudad_origen = ? WHERE id_votante = ?"
                    ;
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
           
            sentencia.setString(1, votante.getNombre());
            sentencia.setString(2, votante.getCorreo());
            sentencia.setString(3, votante.getTelefono());
            sentencia.setString(4, votante.getDireccion());
            sentencia.setString(5, votante.getCiudadOrigen());
            sentencia.setString(6, votante.getNumeroCedula());

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {

                mensaje = new ClsMensaje(ClsMensaje.OK, "Has actualizado el votante exitosamente");
                return mensaje;
            }

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy ocurrió un error");
            return mensaje;

        } catch (Exception excepcion) {

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy ocurrió un error: " + excepcion.getMessage());
            return mensaje;
        }

    }

    public LinkedList<ClsVotante> Obtenervotante() {

        try {

            LinkedList<ClsVotante> lista = new LinkedList<>();

            String consulta = "SELECT * FROM tbl_votantes";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            ResultSet resultados = sentencia.executeQuery();

            while (resultados.next()) {

                String cedula = resultados.getString("id_votante");
                String nombre = resultados.getString("nombre");
                String correo = resultados.getString("correo");
                String telefono = resultados.getString("telefono");
                String direccion = resultados.getString("direccion");
                String ciudadOrigen = resultados.getString("ciudad_origen");

                ClsVotante votante = new ClsVotante(
                        cedula, nombre, correo, telefono, ciudadOrigen, direccion
                );
                lista.add(votante);
            }

            return lista;

        } catch (Exception e) {

            return null;
        }

    }

}