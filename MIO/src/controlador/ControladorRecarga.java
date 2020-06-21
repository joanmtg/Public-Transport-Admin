/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.*;
import javax.swing.JOptionPane;
import logica.*;

/**
 *
 * @author Joan
 */
public class ControladorRecarga {
    
    DaoRecarga recarga = new DaoRecarga();
    ControladorTarjeta tarjeta = new ControladorTarjeta();
    
    public void registrarRecarga(String pinTarjeta, int codEstacion, int numPasajes){
        
        boolean sumar = tarjeta.sumarPasajes(pinTarjeta, numPasajes);
        
        if(sumar == true){        
        
            int recargar = recarga.registrarRecarga(pinTarjeta, codEstacion, numPasajes);
        
            if(recargar == -1){
            
                JOptionPane.showMessageDialog(null, "Ocurrió un error y no se pudo registrar la recarga", "Error", JOptionPane.ERROR_MESSAGE);            
            }else{
            
                JOptionPane.showMessageDialog(null, "La recarga se ha realizado con éxito", "Recarga exitosa", JOptionPane.PLAIN_MESSAGE);            
            }        
        }else{
            
            JOptionPane.showMessageDialog(null, "Ocurrió un error y no se pudo registrar la recarga", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
