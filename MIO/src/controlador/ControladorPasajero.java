/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import logica.*;

/**
 *
 * @author Joan
 */
public class ControladorPasajero {
    
    DaoPasajero daop = new DaoPasajero();
    
    /*
    Este metodo se encarga de guardar la información del pasajero 
    if cant==0, se usa para modificarDatos
    if cant == daop.verificarExistenciaPasajero(..) se usa para personalizarTarjeta
    */
    public boolean guardarPasajero(Pasajero unPasajero){
        
        //se usa para verificar de que este pasajero no tenga already una tarjeta personalizada
        int cant = daop.verificarExistenciaPasajero(unPasajero.getId());
        
        if(cant == 0){
            int guardar = daop.guardarPasajero(unPasajero);
            if(guardar != -1){
                JOptionPane.showMessageDialog(null, "El pasajero se registró correctamente", "Registro exitoso", JOptionPane.PLAIN_MESSAGE);
                return true;
            }
            else{
                return false;
            }
        }
        else if(cant == 1){
            JOptionPane.showMessageDialog(null, "El usuario con identificación "+ unPasajero.getId() + " ya posee una tarjeta personalizada", 
                    "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        else{
            JOptionPane.showMessageDialog(null, "Error al guardar pasajero. Intentelo nuevamente", 
                    "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
    }
    
    /*
    Este metodo, dado un id de un pasajero, me devuelve la información del mismo
    
    */
    public Pasajero obtenerPasajero(String pin){
        Pasajero unPasajero = daop.obtenerPasajero(pin);
        
        
        if(unPasajero != null){
            return unPasajero;
        }
        else{
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error. Intentelo nuevamente ", "Error", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        
        
    }
    
    
    /*
    Este metodo se usa para modificar los datos de un pasajero
    */
    public boolean modificarPasajero(Pasajero unPasajero){
        
        int filas = daop.modificarPasajero(unPasajero);
        if(filas != -1){
            JOptionPane.showMessageDialog(null, "El pasajero se modificó correctamente", "Registro exitoso", JOptionPane.PLAIN_MESSAGE);
            return true;
        }
        else{
            return false;
        }
        
    }
       
    
    // Nuevo : Jhonier
    public void informacionPasajerosTodos(JTable tabla){
        
        ArrayList<Pasajero> pasajeros = daop.obtenerPasajerosTodos();

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        for (int i = 0; i < tabla.getRowCount(); i++) {
           modelo.removeRow(i);
           i-=1;
       }
        
        for (int i = 0; i < pasajeros.size(); i++) {
            
            Object[] fila = new Object[5];
            
            fila[0] = pasajeros.get(i).getId();
            fila[1] = pasajeros.get(i).getNombre();
            fila[2] = pasajeros.get(i).getDireccion();
            fila[3] = pasajeros.get(i).getTelefono();
            fila[4] = pasajeros.get(i).getPinTarjeta();
                               
            modelo.addRow(fila);
        }
        
        tabla.setModel(modelo);
    }
    
    
    // Nuevo : Jhonier
    
    public void informacionRutasPasajeros(JTable tabla, String id_pasajero){
        
        ArrayList<Ruta> rutas = daop.obtenerRutasPasajero(id_pasajero);

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        for (int i = 0; i < tabla.getRowCount(); i++) {
           modelo.removeRow(i);
           i-=1;
       }
        
        for (int i = 0; i < rutas.size(); i++) {
            
            Object[] fila = new Object[2];
            
            fila[0] = rutas.get(i).getCodigo();
            fila[1] = rutas.get(i).getNombre();
                               
            modelo.addRow(fila);
        }
        
        tabla.setModel(modelo);
    }
    
    
    //Juan Pablo's New Method
    public boolean verificarPasajero(String id){
        
        int pasajero = daop.verificarExistenciaPasajero(id);
        
        if(pasajero == 0){
            
            return false;
            
        }else{
            
            return true;
        }
        
    }
    
}
