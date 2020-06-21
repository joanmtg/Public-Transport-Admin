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

public class DaoBus {
    
    FachadaBD fachada = new FachadaBD();
    
    //Joan
    
    public ArrayList<Bus> listaBuses(){
        
        ArrayList<Bus> buses = new ArrayList<>();
        
        String sql_select;
        sql_select="SELECT * FROM bus;";
                
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            String placa, tipo,codRuta;
            int capacidad = 0;
            Bus bus = null;
            
            while(tabla.next()){
                
                placa = tabla.getString(1);
                tipo = tabla.getString(2);
                capacidad = tabla.getInt(3);
                codRuta = tabla.getString(4);

                bus = new Bus(placa, capacidad, tipo, codRuta);
                buses.add(bus);
                
            }
            
           fachada.cerrarConexion(conn);
           return buses;
         }
         
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return buses;
        
    }       
    
    public int guardarModificarBus(Bus bus, String operacion){
        
        String sql_guardar = "INSERT INTO bus VALUES('"+ bus.getPlaca() + "', '" +bus.getTipo() + "', " + bus.getCapacidad()+ ", '" + bus.getCod_ruta() + "');";
                  
        if(operacion.equals("Modificacion")){
            sql_guardar = "UPDATE bus SET tipo='" + bus.getTipo() + "', capacidad=" + bus.getCapacidad()
                    + ", cod_ruta='" + bus.getCod_ruta() + "' WHERE placa='" + bus.getPlaca() +"';";
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
    
    
    public int existeBus(String placa){
        
        String sql_select;
        sql_select="SELECT count(*) FROM bus WHERE placa='" + placa +  "' ;";
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
    
    
    //Joan
        
    public ArrayList<Bus> busesConTurnosDisponibles(){
        
        ArrayList<Bus> buses = new ArrayList<>();
        
        String sql_select;
        sql_select="SELECT * FROM bus WHERE (SELECT COUNT(*) FROM asignaciones_conductores WHERE asignaciones_conductores.placa=bus.placa) <= 2;";
                
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            String placa, tipo,codRuta;
            int capacidad = 0;
            Bus bus = null;
            
            while(tabla.next()){
                
                placa = tabla.getString(1);
                tipo = tabla.getString(2);
                capacidad = tabla.getInt(3);
                codRuta = tabla.getString(4);

                bus = new Bus(placa, capacidad, tipo, codRuta);
                buses.add(bus);
                
            }
            
           fachada.cerrarConexion(conn);
           return buses;
         }
         
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return buses;
        
    }
    
    
       
    
    
    
}
