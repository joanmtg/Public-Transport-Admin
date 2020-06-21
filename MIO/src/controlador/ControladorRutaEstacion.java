/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.DaoRutaEstacion;
import java.util.ArrayList;
import logica.*;

/**
 *
 * @author Joan
 */
public class ControladorRutaEstacion {
    
    private DaoRutaEstacion daoRuEstacion = new DaoRutaEstacion();
            
    public int agregarEstacionesRuta(String codRuta, ArrayList<Estacion> estacionesRuta){
                            
        String sql_guardar = "INSERT INTO rutas_estaciones VALUES ";
        String insert = "";
        
        for (int i = 0; i < estacionesRuta.size(); i++) {
                        
            insert = "("+ estacionesRuta.get(i).getCodigo() + ", '" + codRuta;

            if(i == (estacionesRuta.size() - 1)){
                 insert+="');";
            }else{
                insert+="'),";
            }
            
            sql_guardar += insert;
        }

               
        
        int resultado = daoRuEstacion.añadirEstacionesRuta(sql_guardar);
        
        return resultado;
    
    }
    
    
    public int eliminarEstacionesRuta(String codRuta){
        
        int resultado = daoRuEstacion.eliminarEstacionesRuta(codRuta);
        
        return resultado;        
        
    }
    
    
}
