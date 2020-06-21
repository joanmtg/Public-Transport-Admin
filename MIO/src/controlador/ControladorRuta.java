/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.DaoRuta;
import accesoDatos.DaoTarjeta;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import logica.*;

/**
 *
 * @author Joan
 */
public class ControladorRuta {
    
    DaoRuta daoRuta = new DaoRuta();
        
    /*
    Este método se encarga de obtener los códigos de las rutas registradas en la BD
    Dichas rutas las ubica en el comboBox dado
    */
    public void obtenerCodRutas(JComboBox combo){
        //Primero se borra todo lo que contenga el combo
        combo.removeAllItems();
        combo.addItem("Seleccione");
        
        //Array que contiene los codigos de las rutas
        ArrayList<String> rutas = daoRuta.obtenerCodigosRutas();
        
        if(rutas != null){
            //Se ubican las rutas en el combo
            for (int i = 0; i < rutas.size(); i++) {
                combo.addItem(rutas.get(i));
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "No hay rutas para mostrar", "Error", JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    
    /*
    Este método se encarga de mostrar las rutas que paran en UNA estación 
    */
    public void verRutasXEstacion(String estacion, JTable tabla){
        
        ArrayList<String> rutas = daoRuta.verRutasXEstacion(estacion);
        System.err.println(rutas.size());
        
        if(rutas.size() != 0){//Si el array no es de tamaño 0 pues entonces si hay rutas que pasan por dicha estación
            
            DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
            
            // Eliminando el contenido anterior de la tabla
            for(int i=0; i<tabla.getRowCount(); i++){
                modelo.removeRow(i);
                i-=1;
            }
            
            // Se ingresa el contenido de las rutas (codigo,nombre) a la tabla
            for(int i=0; i < rutas.size(); i++){
                //Se utiliza StringTokenizer para poder separar el codigo del nombre de la ruta de cada String
                StringTokenizer st = new StringTokenizer(rutas.get(i), "-");
                while(st.hasMoreTokens()){
                    Object [] fila = new Object[2]; //serán 2 columnas las que se van a mostrar
                    fila[0]=st.nextToken(); 
                    fila[1]=st.nextToken(); 

                    //Se coloca en la tabla
                    modelo.addRow(fila); 
                }
                
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null, "No hay rutas que transiten por esta estación", "Error", JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    //Pasar a controladorRutaEstacion
    
    /*
    Este método se encargará de mostrar las rutas que pasan por 2 estaciones.
    */
    public void planearViaje(String estacion1, String estacion2, JTable tabla){
        
        ArrayList<Ruta> rutas = daoRuta.planearViaje(estacion1, estacion2);
        System.err.println(rutas.size());
        
        if(rutas.size() != 0){//Si el array no es de tamaño 0 pues entonces si hay rutas que pasan por dicha estación
            
            DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
            
            // Eliminando el contenido anterior de la tabla
            for(int i=0; i<tabla.getRowCount(); i++){
                modelo.removeRow(i);
                i-=1;
            }
            
            // Se ingresa el contenido de las rutas (codigo,nombre) a la tabla
            for(int i=0; i < rutas.size(); i++){
                
                Ruta ruta = rutas.get(i);
                
                Object [] fila = new Object[2]; //serán 2 columnas las que se van a mostrar
                fila[0]=ruta.getCodigo(); 
                fila[1]=ruta.getNombre(); 

                //Se coloca en la tabla
                modelo.addRow(fila);                 
                
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null, "No hay rutas que transiten por esta estación", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    //Joan
    
    public ArrayList<Ruta> obtenerRutas(){
        
        ArrayList<Ruta> rutas = daoRuta.obtenerRutas();
        
        return rutas;
    }
    
    public ArrayList<Estacion> estacionesRuta(String codRuta){
        
        ArrayList<Estacion> estaciones = daoRuta.estacionesRuta(codRuta);
        
        return estaciones;
        
    }
    
    public boolean existeRuta(String codRuta){
        
        boolean existe = false;
        int cantidad = daoRuta.existeRuta(codRuta);
        
        if(cantidad == 1){
            existe = true;
        }
        
        return existe;
    }
    
    
    public int registrarRuta(Ruta ruta){
        
        int resultado = daoRuta.registrarRuta(ruta);
        
        return resultado;
    }
    
    public int modificarRuta(String codRuta, Ruta rutaModificar){
        
        int resultado = daoRuta.modificarRuta(codRuta, rutaModificar);
        
        return resultado;
        
    }
    
    
    
}
