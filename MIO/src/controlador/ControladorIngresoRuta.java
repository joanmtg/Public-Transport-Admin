/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.DaoIngresoRuta;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import logica.*;

/**
 *
 * @author Joan
 */
public class ControladorIngresoRuta {
    
    DaoIngresoRuta daoIngRuta;

    public ControladorIngresoRuta() {
        this.daoIngRuta = new DaoIngresoRuta();
    }
        
    public void registrarIngresoRuta(String pin, String ruta){
        
        IngresoRuta ingreso = new IngresoRuta(pin, ruta, null);
        
        daoIngRuta.registrarIngresoRuta(ingreso);
    }
    
    
    // Nuevo : Jhonier
    
    public void informacionPasajerosPorRutas(JTable tabla, String fecha){
        
        ArrayList<String[]> informacion = daoIngRuta.pasajerosPorRuta(fecha);

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        for (int i = 0; i < tabla.getRowCount(); i++) {
           modelo.removeRow(i);
           i-=1;
       }
        
        for (int i = 0; i < informacion.size(); i++) {
            
            Object[] fila = new Object[3];
            
            fila[0] = informacion.get(i)[0];
            fila[1] = informacion.get(i)[1];
            fila[2] = informacion.get(i)[2];
                               
            modelo.addRow(fila);
        }
        
        tabla.setModel(modelo);        
        
    }
}
