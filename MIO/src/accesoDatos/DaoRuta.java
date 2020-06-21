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

public class DaoRuta {
    
    FachadaBD fachada = new FachadaBD();
    
    /*
    Este método se encarga de obtener todos los códigos de las rutas registradas y colocarlas en un JComboBox dado
    */
    public ArrayList<String> obtenerCodigosRutas(){
        
        ArrayList<String> rutas = new ArrayList<>();
        String sql_select;
        sql_select="SELECT cod_ruta FROM ruta;";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                rutas.add(tabla.getString(1));
            }
           fachada.cerrarConexion(conn);
           return rutas;
         }
         
         catch(SQLException e){ e.printStackTrace(); }
         catch(Exception e){ System.out.println(e); }
        return rutas;
        
    }
            
    
    /*
    Este método se encarga de mostrar las rutas que pasan por UNA estación
    */
    public ArrayList<String> verRutasXEstacion(String estacion){
        ArrayList<String> rutas = new ArrayList<>();
        
        String sql_select;
        sql_select="SELECT cod_ruta, nombre FROM ruta NATURAL JOIN rutas_estaciones "
                + "WHERE cod_estacion = (SELECT cod_estacion FROM estacion "
                + "WHERE nombre = '" + estacion+"');";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                String info = tabla.getString(1)+"-"+tabla.getString(2);
                
                rutas.add(info); //Se agrega al array que se devolverá
            }
           fachada.cerrarConexion(conn);
           return rutas;
         }
         
         catch(SQLException e){ e.printStackTrace(); }
         catch(Exception e){ e.printStackTrace(); }
        return rutas;
    }
    
           
    /*
    Este método se encargará de mostrar las rutas que pasan por 2 estaciones
    */
    public ArrayList<Ruta> planearViaje(String estacion1, String estacion2){
        ArrayList<Ruta> rutas = new ArrayList<>();
        
        String sql_select;
        sql_select= "SELECT cod_ruta, nombre FROM ruta NATURAL JOIN rutas_estaciones" +
                    " WHERE cod_estacion = (SELECT cod_estacion FROM estacion WHERE nombre = '" +estacion1 +"')"+
                    "INTERSECT " +
                    "SELECT cod_ruta, nombre FROM ruta NATURAL JOIN rutas_estaciones\n" +
                    " WHERE cod_estacion = (SELECT cod_estacion FROM estacion WHERE nombre = '"+estacion2+"');";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                
                String codRuta = tabla.getString(1);
                String nombreRuta = tabla.getString(2);
                
                Ruta nuevaRuta = new Ruta(codRuta, nombreRuta, null);
                
                rutas.add(nuevaRuta); //Se agrega al array que se devolverá
            }
           fachada.cerrarConexion(conn);
           return rutas;
         }
         
         catch(SQLException e){ e.printStackTrace(); }
         catch(Exception e){ e.printStackTrace(); }
        return rutas;
    }
    
    
    //Joan
    
    public ArrayList<Ruta> obtenerRutas(){
        
        ArrayList<Ruta> rutas = new ArrayList<>();
        
        String sql_select;
        sql_select="SELECT * FROM ruta;";
        
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            String codigo, nombre, descripcion;
            Ruta ruta = null;            
            
            while(tabla.next()){
                codigo = tabla.getString(1);
                nombre = tabla.getString(2);
                descripcion = tabla.getString(3);
                
                ruta = new Ruta(codigo, nombre, descripcion);
                
                rutas.add(ruta);
            }
           fachada.cerrarConexion(conn);
           return rutas;
         }
         
         catch(SQLException e){ e.printStackTrace(); }
         catch(Exception e){ System.out.println(e); }
        return rutas;
        
        
    }
    
    public int existeRuta(String codRuta){
        
        String sql_select;
        sql_select="SELECT count(*) FROM ruta WHERE cod_ruta='" + codRuta +  "' ;";
        int cantidad = 0;
        
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                cantidad = Integer.parseInt(tabla.getString(1));
            }
            
            fachada.cerrarConexion(conn);
            return cantidad;
         }
         
         catch(SQLException e){ e.printStackTrace(); }
         catch(Exception e){ System.out.println(e); }
        return cantidad;
    }
    
    
    public ArrayList<Estacion> estacionesRuta(String codRuta){
       
        ArrayList<Estacion> estaciones = new ArrayList<>();
        
        String sql_select = "SELECT cod_estacion, nombre FROM estacion NATURAL JOIN rutas_estaciones WHERE cod_ruta='" + codRuta +"';";
        
        
        try{
            Connection conn = fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);                        
                        
            Estacion estacion = null;
            int codigoEstacion;
            String nombre;
            
            while (tabla.next()) {
                
                codigoEstacion = tabla.getInt(1);
                nombre = tabla.getString(2);
                
                estacion = new Estacion(codigoEstacion, nombre, "", "", "");
                
                estaciones.add(estacion);
            }
            
            fachada.cerrarConexion(conn);
            
            return estaciones;
            
        }
        catch(SQLException e){ e.printStackTrace(); }
        catch(Exception e){ System.out.println(e); }
        
        
        return estaciones;
    }
    
    public int registrarRuta(Ruta ruta){
        
        String sql_guardar = "INSERT INTO ruta VALUES ('" + ruta.getCodigo() + "', '" + ruta.getNombre() + "', '" + ruta.getDescripcion() + "');";
        
        int numFilas = 0;

        try{
            Connection conn = fachada.conectar();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(sql_guardar);
            
            fachada.cerrarConexion(conn);
            
            return numFilas;
        }
        catch(SQLException e){ e.printStackTrace(); }
        catch(Exception e){ System.out.println(e); }
        
        return numFilas;
        
    }
    
    public int modificarRuta(String codRuta, Ruta rutaNueva){
        
        String sql_guardar = "UPDATE ruta SET cod_ruta='" + rutaNueva.getCodigo() + "', nombre='" + rutaNueva.getNombre() + "', descripcion='" + rutaNueva.getDescripcion() + "' WHERE cod_ruta='" + codRuta + "';";
        
        int numFilas = 0;

        try{
            Connection conn = fachada.conectar();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(sql_guardar);
            
            fachada.cerrarConexion(conn);
            
            return numFilas;
        }
        catch(SQLException e){ e.printStackTrace(); }
        catch(Exception e){ System.out.println(e); }
        
        return numFilas;
        
    }    
    
}
