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
import logica.*;

public class DaoMedida {
    
    FachadaBD fachada;

    public DaoMedida() {
        fachada = new FachadaBD();
    }
    
    
    
    /*
    Este método me indica si un caso even exists
    0 -> No existe
    1 -> It does
    */
    public int validarExisteCaso(String caso){
        
        String sql_select;
        sql_select="SELECT count(*) FROM caso WHERE cod_caso=" + caso +  " ;";
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
    Este método se encarga de retornar el numero del caso, el motivo y la descripción del mismo
    */
    public ArrayList<String> obtenerMotDesCaso(String caso){
        
        String sql_select;
        sql_select="SELECT descripcion, motivo, estado FROM caso WHERE cod_caso=" + caso +  " ;";
        ArrayList<String> info = new ArrayList<>();
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                String desc = tabla.getString(1); //Indice 0
                String motivo = tabla.getString(2);//Indice 1
                String estado = tabla.getString(3);
                info.add(desc);
                info.add(motivo);
                info.add(estado);
                
                
            }
           fachada.cerrarConexion(conn);
           return info;
         }
         
         catch(SQLException e){ e.printStackTrace(); }
         catch(Exception e){ System.out.println(e); }
        return info;
        
    }
    
    
    /*
    Este método se encarga de obtener las medidas que se han tomado en un caso
    */
    public ArrayList<String> obtenerMedidasCaso(String caso){
        
        String sql_select;
        sql_select="SELECT medida FROM medidas_casos WHERE cod_caso=" + caso +  " ;";
        ArrayList<String> medidas = new ArrayList<>();
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                String medida = tabla.getString(1);
                medidas.add(medida);
                
            }
           fachada.cerrarConexion(conn);
           return medidas;
         }
         
         catch(SQLException e){ e.printStackTrace(); }
         catch(Exception e){ System.out.println(e); }
        return medidas;
        
    }
    
    
}
