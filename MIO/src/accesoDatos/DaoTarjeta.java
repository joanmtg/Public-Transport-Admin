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

public class DaoTarjeta {
    
    FachadaBD fachada;

    public DaoTarjeta() {
        fachada = new FachadaBD();
    }
    
        
    /*
    Este metodo se encarga de buscar si el pin de la tarjeta ingresado even exist. En caso de que exista se procede al paso 2
    */
    public int validarExistenciaPin(String pin){
        
        String sql_select;
        sql_select="SELECT count(*) FROM tarjeta WHERE pin='" + pin +  "' ;";
        int cantidad = 0; //Por defecto, colocamos que no existe la tarjeta
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
    Este metodo se encarga de obtener la cantidad de pasajes que tiene una tarjeta
    */
    public int obtenerSaldo(String pin){
        int pasajes = -5; //En caso de error y no entre al while
        String sql_select;
        sql_select="SELECT pasajes FROM tarjeta WHERE pin='" + pin +  "' ;";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                pasajes = Integer.parseInt(tabla.getString(1));
            }
           fachada.cerrarConexion(conn);
           return pasajes;
         }
         
         catch(SQLException e){ e.printStackTrace(); }
         catch(Exception e){ System.out.println(e); }
        return pasajes;
    }
    
    /*
    Este método obtiene el estado de una tarjeta, dado su PIN
    */
    
    public String estadoTarjeta(String pin){
        
        String estado = "";
        String sql_select;
        sql_select="SELECT estado FROM tarjeta WHERE pin='" + pin +  "' ;";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                estado = tabla.getString(1);
            }
           fachada.cerrarConexion(conn);
           return estado;
         }
         
         catch(SQLException e){ e.printStackTrace(); }
         catch(Exception e){ System.out.println(e); }
        return estado;
        
    
    }
    
           
    /*
    Este metodo se encarga de restar un pasaje a una tarjeta
    */
    
    public int restarPasaje(String pin, int cantidad_actual){
        
        String sql_guardar;
                 
        sql_guardar = "UPDATE tarjeta set pasajes = "+ (cantidad_actual - 1) +" WHERE pin = '"+pin+"';";
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
    
    public ArrayList<String[]> ventasTarjetas(String fecha){
        
        ArrayList<String[]> informacion = new ArrayList<>();
        String cod_est = "", nombre_est = "", numVentas = "";
        String sql_select;
        sql_select = "SELECT cod_estacion, nombre, numVentas FROM estacion NATURAL JOIN "
                   + "(SELECT cod_estacion, Count(*) numVentas FROM tarjeta "
                   + "WHERE fecha_adq ='"+fecha+"' GROUP BY cod_estacion) AS ventasEstaciones";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                cod_est = tabla.getString(1);
                nombre_est = tabla.getString(2);
                numVentas = tabla.getString(3);
                
                String[] inf = new String[3];
                inf[0] = cod_est;
                inf[1] = nombre_est;
                inf[2] = numVentas;
                
                informacion.add(inf);
            }
           fachada.cerrarConexion(conn);
           return informacion;
         }
         
         catch(SQLException e){ e.printStackTrace(); }
         catch(Exception e){ System.out.println(e); }
        return informacion;
        
    
    }
    
    
    //Juan Pablo's New Method 
    public int sumarPasaje(String pin, int cantidad_actual, int numPasajes){        
        
        String sql_guardar;
        
        sql_guardar = "UPDATE tarjeta set pasajes = "+ (cantidad_actual + numPasajes) + " WHERE pin = '"+ pin + "';";
       
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
    
    //Juan Pablo's New Method
    public int modfEstadoTarjeta(String pin, String estado){
        
        String sql_guardar;
        
        sql_guardar = "UPDATE tarjeta set estado = '" + estado + "' WHERE pin = '" + pin + "';";
        
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
    
    
    //Juan Pablo's New Method
    public int obtenerMaxPinTarjeta(){
        
        int pin = 0;
        String sql;
        
        sql = "SELECT MAX(pin) FROM tarjeta;";
        
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql);
            
            while(tabla.next()){
                pin = Integer.parseInt(tabla.getString(1));
            }
           fachada.cerrarConexion(conn);
           return pin;
         }
         
         catch(SQLException e){ e.printStackTrace(); }
         catch(Exception e){ System.out.println(e); }
        return pin;
        
    }
    
    //Juan Pablo's New Method
    public int registrarTarjeta(int codEstacion, String fecha){
        
        String sql_guardar;
        
        sql_guardar = "INSERT INTO tarjeta(pasajes, estado, fecha_adq, cod_estacion) VALUES (1, 'Activa', '" + fecha +"', "+ codEstacion +");";
        
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
    
    //THIS PIECE OF METHOD
    public boolean tarjetaEliminada(String pin){
        
        String sql;
        boolean eliminada = true;
        
        sql = "SELECT eliminada FROM tarjeta WHERE pin = '" + pin + "';";
        
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql);
            
            while(tabla.next()){
                eliminada = tabla.getBoolean(1);
            }
           fachada.cerrarConexion(conn);
           return eliminada;
         }
         
         catch(SQLException e){ e.printStackTrace(); }
         catch(Exception e){ System.out.println(e); }
        return eliminada;
        
    }
    
    
    //THIS PIECE OF METHOD
    public int eliminarTarjeta(String pin){
        
        String sql_guardar;
        
        sql_guardar =  "UPDATE tarjeta SET eliminada = true WHERE pin = '"+ pin + "';";
        
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
    
    
}
