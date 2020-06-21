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
import jdk.nashorn.internal.runtime.regexp.joni.EncodingHelper;
import logica.*;

public class DaoEstacion {
    
    FachadaBD fachada = new FachadaBD();
            
    /*
    Éste método se encarga de obtener las estaciones registradas en el sistema
    */
    public ArrayList<String> obtenerNombresEstaciones(){
        ArrayList<String> estaciones = new ArrayList<>();
        String sql_select;
        sql_select="SELECT nombre FROM estacion;";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                estaciones.add(tabla.getString(1));
            }
           fachada.cerrarConexion(conn);
           return estaciones;
         }
         
         catch(SQLException e){ e.printStackTrace(); }
         catch(Exception e){ System.out.println(e); }
        return estaciones;
    }
    
    //Joan
    
    public ArrayList<Estacion> listaEstaciones(){
        
        ArrayList<Estacion> estaciones = new ArrayList<>();
        
        String sql_select;
        sql_select="SELECT cod_estacion, estacion.nombre, ubicacion, estacion.telefono, empleado.nombre "
                + "FROM estacion, empleado WHERE estacion.id_director=empleado.id_empleado ORDER BY(cod_estacion);";
                
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            int codEstacion = 0;
            String nombre, ubicacion, telefono, director;
            
            Estacion estacion = null;
            
            while(tabla.next()){
                
                codEstacion = tabla.getInt(1);
                nombre = tabla.getString(2);
                ubicacion = tabla.getString(3);
                telefono = tabla.getString(4);
                director = tabla.getString(5);

                estacion = new Estacion(codEstacion, nombre, ubicacion, telefono, director);
                estaciones.add(estacion);
                
            }
            
           fachada.cerrarConexion(conn);
           return estaciones;
         }
         
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return estaciones;
        
    }
    
    //Joan
          
    public String codigoDirectorEstacion(int codEstacion){
        
        String codDirector = "";
        String sql_select = "SELECT id_director FROM estacion WHERE cod_estacion =" + codEstacion + ";";
        
        try{
            Connection conn = fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                codDirector = tabla.getString(1);
            }
            
            fachada.cerrarConexion(conn);
            
            return codDirector;
            
        }
                
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        
        return codDirector;
    }
    
    public int guardarModificarEstacion(Estacion estacion, String operacion){
               
        String sql_guardar = "INSERT INTO estacion (nombre, ubicacion, telefono, id_director) VALUES ('"
                + estacion.getNombre() + "', '" + estacion.getUbicacion() + "', '" + estacion.getTelefono()
                + "', '" + estacion.getDirector() + "');";
        
        if(operacion.equals("Modificacion")){
            sql_guardar = "UPDATE estacion SET nombre='" + estacion.getNombre() + "', ubicacion='" 
                    + estacion.getUbicacion() + "', telefono='" + estacion.getTelefono() + "', id_director='" 
                    + estacion.getDirector() + "' WHERE cod_estacion=" +estacion.getCodigo() + ";";
        }
        
                    
        try{
            Connection conn = fachada.conectar();
            Statement sentencia = conn.createStatement();
            int numFilas = sentencia.executeUpdate(sql_guardar);
            
            fachada.cerrarConexion(conn);
            return numFilas;
            
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }               
        
        return -1;
    }
    
    public Estacion obtenerInfoEstacion(String cod_director){
        
        
        String sql_select = "SELECT * FROM estacion WHERE id_director ='" + cod_director + "';";
        
        try{
            Connection conn = fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                int id = Integer.parseInt(tabla.getString(1));
                String nombre = tabla.getString(2);
                String ubicacion = tabla.getString(3);
                String telefono = tabla.getString(4);
                String id_director  = tabla.getString(5);
                
                Estacion miEstacion = new Estacion(id, nombre, ubicacion, telefono, id_director);
                return miEstacion;
            }
            
            fachada.cerrarConexion(conn);
            
            
            
        }
                
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        
        return null;
    }
    
    
    
    
    
    
}
