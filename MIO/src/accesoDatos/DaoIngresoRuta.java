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
import java.util.ArrayList;
import logica.*;

public class DaoIngresoRuta {
    
    FachadaBD fachada;

    public DaoIngresoRuta() {
        fachada = new FachadaBD();
    }
    
    /*
    Este método se encarga de hacer el registro del ingreso en la tabla ingresos_rutas
    */
    public int registrarIngresoRuta(IngresoRuta ingreso){
        
        String sql_guardar;
                 
        sql_guardar = "INSERT INTO ingresos_rutas VALUES "
                + "('"+ingreso.getPinTarjeta()+"', '"+ingreso.getRuta()+"', now() );";
        try{
            Connection conexion= fachada.conectar();
            Statement sentencia = conexion.createStatement();
            int numFilas = sentencia.executeUpdate(sql_guardar);
            conexion.close();
            return numFilas;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return -1;
        
    }
    
    
    // Nuevo : Jhonier
    
    public ArrayList<String[]> pasajerosPorRuta(String fecha){
        
        ArrayList<String[]> informacion = new ArrayList<>();
        String sql_select;
        sql_select = "SELECT cod_ruta, nombre, cantPasajeros FROM Ruta NATURAL JOIN "
                   + "(SELECT cod_ruta, Count(*) cantPasajeros FROM ingresos_rutas"
                   + " WHERE fecha_hora::date ='"+fecha+"' GROUP BY cod_ruta) AS rutasPasajeros;";
        
        String cod_ruta = "", nombre_ruta = "", numPasajeros = "";
        
        try{
           Connection conn= fachada.conectar();
           Statement sentencia = conn.createStatement();
           ResultSet tabla = sentencia.executeQuery(sql_select);

           while(tabla.next()){

               cod_ruta = tabla.getString(1);
               nombre_ruta = tabla.getString(2);
               numPasajeros = tabla.getString(3);
               
               String[] inf = new String[3];
               inf[0] = cod_ruta;
               inf[1] = nombre_ruta;
               inf[2] = numPasajeros;
               
               informacion.add(inf);
           }

          fachada.cerrarConexion(conn);
        }

        catch(SQLException e){ e.printStackTrace(); }
        catch(Exception e){ System.out.println(e); }

        return informacion;        
    }
    
}
