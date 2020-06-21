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

public class DaoAsignacionConductor {
    
    private FachadaBD fachada = new FachadaBD();        
    
    public ArrayList<String> obtenerTurnosConductor(String codConductor){
        
        ArrayList<String> turnos = new ArrayList<>();
        
        String sql_select = "SELECT turno FROM asignaciones_conductores " +
                            "WHERE id_empleado='"+ codConductor + "';" ;
                            
        
        try{
            Connection conn = fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
                           
            String turno;
            
            while(tabla.next()){
                
                turno = tabla.getString(1);            
                turnos.add(turno);
                
            }
            
            fachada.cerrarConexion(conn);
            
            return turnos;
            
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
                
        return turnos;
                
    }
    
    public int guardarAsignaciones(String sql_guardar){
        
        int numFilas = 0;
                
        try{
            Connection conn = fachada.conectar();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(sql_guardar);
            
            fachada.cerrarConexion(conn);
            
            return numFilas;
            
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }catch (Exception ex) {
            System.out.println(ex);
        }
        
        
        return numFilas;
    }
    
    public int eliminarAsignacionesConductor(String codConductor){
        
        int numFilas = 0;
        String sql_borrar = "DELETE FROM asignaciones_conductores WHERE id_empleado = '" + codConductor + "';";
                
        try{
            Connection conn = fachada.conectar();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(sql_borrar);
            
            fachada.cerrarConexion(conn);
            
            return numFilas;
            
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }catch (Exception ex) {
            System.out.println(ex);
        }
        
        
        return numFilas;
    }
    
    
    // Jhonier : Nuevo
    public ArrayList<String[]> obtenerBusesConductores(){
       
        ArrayList<String[]> informacion = new ArrayList<>();
        String placa, tipo, capacidad, nombre_ruta, nombre_conductor;
        String sql_select;
        sql_select = " SELECT placa, tipo, capacidad, nombre_ruta, nombre nombre_conductor "
                   + " FROM asignaciones_conductores NATURAL JOIN bus NATURAL JOIN "
                   + " ruta AS ruta(cod_ruta, nombre_ruta,descripcion) "
                   + " NATURAL JOIN empleado;";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                placa = tabla.getString(1);
                tipo = tabla.getString(2);
                capacidad = tabla.getString(3);
                nombre_ruta = tabla.getString(4);
                nombre_conductor = tabla.getString(5);
                
                String[] inf = new String[5];
                inf[0] = placa;
                inf[1] = tipo;
                inf[2] = capacidad;
                inf[3] = nombre_ruta;
                inf[4] = nombre_conductor;
            
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
    public String obtenerBusAsignado(String codConductor){
        
        String placa = "";
        String sql;
        
        sql = "SELECT DISTINCT placa FROM asignaciones_conductores WHERE id_empleado = '" + codConductor + "';";
        
        try{
            Connection conn = fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql);        
            
            while(tabla.next()){
                
                placa = tabla.getString(1);               
            }
            
            fachada.cerrarConexion(conn);
            
            return placa;
            
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
                
        return placa;        
    }
    
    
    //Joan
    
    public ArrayList<String> turnosDisponiblesBus(String placa){
        
        ArrayList<String> turnosDisponibles = new ArrayList<>();
        
        String sql_select = "SELECT DISTINCT turno FROM asignaciones_conductores EXCEPT SELECT turno FROM asignaciones_conductores WHERE placa='"+ placa + "';";
        
        try{
            Connection conn = fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);        
            
            String turno = "";
            
            while(tabla.next()){
                
                turno = tabla.getString(1);               
                turnosDisponibles.add(turno);
            }
            
            fachada.cerrarConexion(conn);
            
            return turnosDisponibles;
            
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
                
        return turnosDisponibles;         
    }
    
    
    
    
    
}


