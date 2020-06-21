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
import logica.*;

public class DaoRutaEstacion {
    
    private FachadaBD fachada = new FachadaBD();
    
    public int añadirEstacionesRuta(String sql_guardar){
        
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
    
    
    
    public int eliminarEstacionesRuta(String codRuta){
        
        int numFilas = 0;
        String sql_borrar = "DELETE FROM rutas_estaciones WHERE cod_ruta = '" + codRuta + "';";
                
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
    
    
    
    
}
