/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

/**
 *
 * @author Joan
 */
import java.sql.*;

public class FachadaBD {

    String url, usuario, password;
    Connection conexion;

    FachadaBD() {
        url = "jdbc:postgresql://localhost:5432/miobd";
        usuario = "wayne";
        password = "arkham";
    }

    public Connection conectar() {
        try {
            // Se carga el driver
            Class.forName("org.postgresql.Driver");
            //System.out.println( "Driver Cargado" );
        } catch (Exception e) {
            System.out.println("No fue posible cargar el driver.");
        }

        try {
            //Crear el objeto de conexion a la base de datos
            conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexion Exitosa");
            return conexion;
            //Crear objeto Statement para realizar queries a la base de datos
        } catch (Exception e) {
            System.out.println("No fue posible accerder a la Base de Datos.");
            e.printStackTrace();
            return null;
        }

    }//end connectar

    public void cerrarConexion(Connection c) {
        try {
            c.close();
        } catch (Exception e) {
            System.out.println("No se pudo cerrar la conexión.");
        }
    }
}//end class
