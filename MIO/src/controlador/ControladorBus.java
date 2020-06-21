/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.DaoBus;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import logica.*;

/**
 *
 * @author Joan
 */
public class ControladorBus {
    
    DaoBus daoBus = new DaoBus();
    
    //Joan
    
    public ArrayList<Bus> obtenerBuses(){
             
        ArrayList<Bus> buses = daoBus.listaBuses();
        
        return buses;
    }    
    
    public int guardarModificarBus(Bus bus, String operacion){
        
        int resultado = daoBus.guardarModificarBus(bus, operacion);
        
        return resultado;
    }
    
    
    public boolean existeBus(String placa){
        
        boolean existe = false;
        int cantidad = daoBus.existeBus(placa);
        
        if(cantidad == 1){
            existe = true;
        }
        
        return existe;
    }
    
    //Joan
    
    public ArrayList<Bus> busesDisponibles(){
        
        ArrayList<Bus> busesDisponibles = daoBus.busesConTurnosDisponibles();
        
        return busesDisponibles;
        
    }
    
    
}
