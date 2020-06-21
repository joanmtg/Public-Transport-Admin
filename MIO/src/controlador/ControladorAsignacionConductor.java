/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import logica.*;
import accesoDatos.DaoAsignacionConductor;
import accesoDatos.DaoPasajero;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
        
/**
 *
 * @author Joan
 */
public class ControladorAsignacionConductor {
    
    DaoAsignacionConductor daoTurno = new DaoAsignacionConductor();
        
    
    public ArrayList<String> obtenerTurnosConductor(String codConductor){
        
        ArrayList<String> turnos = daoTurno.obtenerTurnosConductor(codConductor);
        
        return turnos;
                
    }
    
    public int guardaTurnosConductor(ArrayList<AsignacionConductor> asignaciones){
        
        String codConductor = asignaciones.get(0).getIdConductor();
        
        daoTurno.eliminarAsignacionesConductor(codConductor);
        
        String sql_guardar = "INSERT INTO asignaciones_conductores VALUES";
        String insert = "";
        
        for (int i = 0; i < asignaciones.size(); i++) {
            
            AsignacionConductor asignacion = asignaciones.get(i);
            
            insert = "('" + asignacion.getIdConductor() + "', '" + asignacion.getPlaca() + "', '" + asignacion.getTurno();
                
            if(i == asignaciones.size() - 1){
                insert+="');";
            }
            else{
                insert+="'),";
            }           
            
            sql_guardar += insert;
        }        
                
        System.out.println(sql_guardar);
        
        int numFilas = daoTurno.guardarAsignaciones(sql_guardar);
        
        return numFilas;
    }
    
    
    // Nuevo : Jhonier
    public void informacionBusesConductores(JTable tabla){
        
        ArrayList<String[]> informacion = daoTurno.obtenerBusesConductores();

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        for (int i = 0; i < tabla.getRowCount(); i++) {
           modelo.removeRow(i);
           i-=1;
       }
        
        for (int i = 0; i < informacion.size(); i++) {
            
            Object[] fila = new Object[5];
            
            fila[0] = informacion.get(i)[0];
            fila[1] = informacion.get(i)[1];
            fila[2] = informacion.get(i)[2];
            fila[3] = informacion.get(i)[3];
            fila[4] = informacion.get(i)[4];
                               
            modelo.addRow(fila);
        }
        
        tabla.setModel(modelo);        
        
    }
    
    //Juan Pablo's New Method
    public String obtenerBusAsignado(String codConductor){
        
        String placaBus;          
        placaBus = daoTurno.obtenerBusAsignado(codConductor);
        
        return placaBus;
    }
    
    
    //Joan
    
    public ArrayList<String> turnosDisponiblesBus(String placa){
        
        ArrayList<String> turnos = daoTurno.turnosDisponiblesBus(placa);
        
        return turnos;
    }
    
}