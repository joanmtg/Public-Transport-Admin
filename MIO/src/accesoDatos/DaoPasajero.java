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
import java.util.*;
import javax.swing.JComboBox;
import logica.*;

public class DaoPasajero {
    FachadaBD fachada;

    public DaoPasajero() {
        fachada = new FachadaBD();
    }
    
       
         
    /*
    Este metodo se encarga de buscar si la está personalizada
    */
    public int validarPinTarjetaPersonal(String pin){
        
        String sql_select;
        sql_select="SELECT count(*) FROM pasajero WHERE pin='" + pin +  "' ;";
        int cantidad = 0; //Por defecto, colocamos que no existe la tarjeta como personalizada
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
    
    /*
    Este metodo registra un pasajero nuevo
    */
    public int guardarPasajero(Pasajero unPasajero){
        
        String sql_guardar;
                 
        sql_guardar = "INSERT INTO pasajero(id_pasajero,nombre,direccion,telefono,fecha_nac,pin)"
                    + " VALUES ('" + unPasajero.getId()+ "', '" + unPasajero.getNombre() +  "',"
                    +           " '" + unPasajero.getDireccion()+ "', '" + unPasajero.getTelefono()+"',"
                    +           " '" + unPasajero.getFechaNacimiento()+"','" + unPasajero.getPinTarjeta()+"' );";
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
    
    
    /*
    Este metodo modifica los datos de un pasajero existente
    */
    public int modificarPasajero(Pasajero unPasajero){
        String sql_guardar;
                 
        sql_guardar = "UPDATE pasajero "
                    + " SET  nombre = '" + unPasajero.getNombre() +  "',"
                    + "direccion = '" + unPasajero.getDireccion()+ "', telefono = '" + unPasajero.getTelefono()+"',"
                    + "fecha_nac = '" + unPasajero.getFechaNacimiento()+"', pin = '" + unPasajero.getPinTarjeta()+"'"
                    + "WHERE id_pasajero = '"+unPasajero.getId()+"';";
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
    
    
    //Verifica si algún pasajero dado su id existe.
    public int verificarExistenciaPasajero(String id){
        
        String sql_select;
        sql_select="SELECT count(*) FROM pasajero WHERE id_pasajero='" + id +  "' ;";
        int cantidad = 0; //Por defecto, colocamos que no existe la
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
    
    
    /*
    Este metodo se usa para obtener toda la información necesaria de un pasajero
    */
    public Pasajero obtenerPasajero(String pin){
        Pasajero unPasajero = null;
        String id, nombre, dir, tel, fecha;
        String sql_select;
        sql_select="SELECT * FROM pasajero WHERE pin='" + pin +  "' ;";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                id = tabla.getString(1);
                nombre = tabla.getString(2);
                dir = tabla.getString(3);
                tel = tabla.getString(4);
                fecha = tabla.getString(5);
                
                unPasajero = new Pasajero(id, nombre, dir, tel, fecha, pin);
            }
           fachada.cerrarConexion(conn);
           return unPasajero;
         }
         
         catch(SQLException e){ e.printStackTrace(); }
         catch(Exception e){ System.out.println(e); }
        return unPasajero;
        
    }      
    
    
    /*
    Nuevo : Jhonier
    */
    public ArrayList<Pasajero> obtenerPasajerosTodos(){
        ArrayList<Pasajero> pasajeros = new ArrayList<>();
        String id, nombre, dir, tel, fecha, pin;
        String sql_select;
        sql_select="SELECT * FROM pasajero;";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                id = tabla.getString(1);
                nombre = tabla.getString(2);
                dir = tabla.getString(3);
                tel = tabla.getString(4);
                fecha = tabla.getString(5);
                pin = tabla.getString(6);
                
                Pasajero nuevoPasajero = new Pasajero(id, nombre, dir, tel, fecha, pin);
                pasajeros.add(nuevoPasajero);
            }
           fachada.cerrarConexion(conn);
           return pasajeros;
         }
         
         catch(SQLException e){ e.printStackTrace(); }
         catch(Exception e){ System.out.println(e); }
        return pasajeros;
        
    }  
    
    
    // Nuevo : Jhonier
    
    public ArrayList<Ruta> obtenerRutasPasajero(String id_pasajero){
        ArrayList<Ruta> rutas = new ArrayList<>();
        String cod_ruta, nombre_ruta;
        String sql_select;
        sql_select = "SELECT cod_ruta, nombre_ruta FROM pasajero NATURAL JOIN ingresos_rutas "
                   + "NATURAL JOIN ruta ruta(cod_ruta, nombre_ruta, descripcion) "
                   + "WHERE id_pasajero='" + id_pasajero +  "' ;";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                cod_ruta = tabla.getString(1);
                nombre_ruta = tabla.getString(2);
                
                Ruta rutaPasajero = new Ruta(cod_ruta, nombre_ruta, "");
                rutas.add(rutaPasajero);
            }
           fachada.cerrarConexion(conn);
           return rutas;
         }
         
         catch(SQLException e){ e.printStackTrace(); }
         catch(Exception e){ System.out.println(e); }
        return rutas;
        
    }    
}
