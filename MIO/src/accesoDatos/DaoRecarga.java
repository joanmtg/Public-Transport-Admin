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

public class DaoRecarga {
    
    FachadaBD fachada = new FachadaBD();
    
    public int registrarRecarga(String pinTarjeta, int codEstacion, int numPasajes){
        
        String sql = "INSERT INTO recargas_tarjetas VALUES ('"+ pinTarjeta + "', " + codEstacion + ", " + numPasajes +", now());";
        
        try{
            Connection conexion= fachada.conectar();
            Statement sentencia = conexion.createStatement();
            int numFilas = sentencia.executeUpdate(sql);
            conexion.close();
            return numFilas;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return -1;       
        
    }
            
    
}