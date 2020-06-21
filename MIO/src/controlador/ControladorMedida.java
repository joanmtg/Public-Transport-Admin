/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import logica.*;
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
public class ControladorMedida {
    
    DaoMedida daom = new DaoMedida();
    
    
    /*
    Este método se encarga de traer la información de un caso
    */
    public void obtenerInfoCaso(String caso, JLabel lNumero, JLabel lMotivo, JLabel lEstado, JTextArea taDesc, JTable tabla){
        
        //Se busca primero que el caso exista
        int cantidad = daom.validarExisteCaso(caso);
        if(cantidad == 0){//No existe el caso
            
            JOptionPane.showMessageDialog(null, "El caso con código "+caso+" no existe", "Error", JOptionPane.WARNING_MESSAGE);
            
        }
        else{
            //Se obtiene la descripción y el motivo
            ArrayList<String> infoCaso = new ArrayList<>();
            infoCaso = daom.obtenerMotDesCaso(caso);
            
            //Se obtienen la(s) medida(s) que tomadas para dicho caso
            ArrayList<String> medidas = new ArrayList<>();
            medidas = daom.obtenerMedidasCaso(caso);
            
            //Se ubica la información en los diferentes componentes
            lNumero.setText("Número: "+ caso);
            lMotivo.setText("Motivo: "+ infoCaso.get(1)); //motivo
            lEstado.setText("Estado: "+ infoCaso.get(2));
            taDesc.setText(infoCaso.get(0));
            //Se ubican las medidas en la tabla
            DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
            
            // Eliminando el contenido anterior de la tabla
            for(int i=0; i<tabla.getRowCount(); i++){
                modelo.removeRow(i);
                i-=1;
            }
            
            // Se ingresa el contenido de las medidas  a la tabla
            for(int i=0; i < medidas.size(); i++){
                
                Object [] fila = new Object[1]; //será 1 columna la que se va a mostrar
                fila[0]=medidas.get(i);
                 
                //Se coloca en la tabla
                modelo.addRow(fila); 
                
            }
            
        }
        
    }
    
    
    
}
