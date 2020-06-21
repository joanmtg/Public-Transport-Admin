/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.DaoEstacion;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import logica.*;

/**
 *
 * @author Joan
 */
public class ControladorEstacion {
    
    DaoEstacion daoEstacion = new DaoEstacion();
    
       
    /*
    Este método se encarga de obtener los nombres de la estaciones registradas en la BD
    Dichas estaciones las ubica en los dos JComboBox dados
    */
    public void obtenerEstaciones(JComboBox combo1, JComboBox combo2){
        //Primero se borra todo lo que contengan los combos
        combo1.removeAllItems();
        combo1.addItem("Seleccione");
        
        if(combo2 != null){
            combo2.removeAllItems();
            combo2.addItem("Seleccione");
        }
        
        
        //Array que contiene los nombres de las estaciones
        ArrayList<String> estaciones = daoEstacion.obtenerNombresEstaciones();
        
        if(estaciones != null){
            //Se ubican las estaciones en el combo
            for (int i = 0; i < estaciones.size(); i++) {
                combo1.addItem(estaciones.get(i));
                
                if(combo2 != null) combo2.addItem(estaciones.get(i));
            }
        
        }
        else{
            JOptionPane.showMessageDialog(null, "No hay estaciones para mostrar", "Error", JOptionPane.WARNING_MESSAGE);
        }
        
        
    }
    
    //Joan
    
    
    public ArrayList<Estacion> listaEstaciones(){
        
        ArrayList<Estacion> estaciones = daoEstacion.listaEstaciones();
        
        return estaciones;
    }
    
    //Joan
    
    public String directorEstacion(int codEstacion){
        
        String director = daoEstacion.codigoDirectorEstacion(codEstacion);
        
        return director;
        
    }
    
    //Joan
    
    public int guardarModificarEstacion(Estacion estacion, String operacion){
        
        int resultado = daoEstacion.guardarModificarEstacion(estacion, operacion);
        
        return resultado;
    }
    
    /*
    Este método se encarga de obtener la estación en la cual trabaja el empleado recien loggeado (Director de estación)
    */
    public Estacion obtenerEstacion(String cod_director){
        
        Estacion unaEstacion = daoEstacion.obtenerInfoEstacion(cod_director);
        
        if(unaEstacion == null){
            JOptionPane.showMessageDialog(null, "Error al obtener la estación del director "+ cod_director, "Error", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        else{
            return unaEstacion;
        }
        
    }
    
    //Juan Pablo's New Method
    public void obtenerEstaciones(JComboBox combo){
        //Primero se borra todo lo que contengan los combos
        combo.removeAllItems();
        combo.addItem("Seleccione");
       
        
        //Array que contiene los nombres de las estaciones
        ArrayList<String> estaciones = daoEstacion.obtenerNombresEstaciones();
        
        if(estaciones != null){
            //Se ubican las estaciones en el combo
            for (int i = 0; i < estaciones.size(); i++) {
                combo.addItem(estaciones.get(i));
            }
        
        }
        else{
            JOptionPane.showMessageDialog(null, "No hay estaciones para mostrar", "Error", JOptionPane.WARNING_MESSAGE);
        }
        
        
    }
    
    
    
}
