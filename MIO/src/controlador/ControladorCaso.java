/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.DaoCaso;
import java.util.*;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import logica.*;

/**
 *
 * @author Joan
 */
public class ControladorCaso {
    
    DaoCaso daoCaso = new DaoCaso();
    
        
    public void registrarCaso(String descripcion, String motivo, String fecha, int codEstacion, String idPasajero, String idEmpleado){
        
       int registro = daoCaso.registrarCaso(descripcion, motivo, fecha, codEstacion, idPasajero, idEmpleado);
       
       if(registro == -1){
           
           JOptionPane.showMessageDialog(null, "Error al ingresar el caso. Inténtelo de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
       }else{
           
           JOptionPane.showMessageDialog(null, "El caso se ha registrado exitosamente", "Registro exitoso", JOptionPane.PLAIN_MESSAGE);
       }
    }
    
    
    
    /*
    Este método contiene toda la lógica de modificar un caso
    */
    
    public Caso modificarCaso(JTable tablaQuejas, Estacion estacion, String idEmpleado){
        //tablaQuejas.getValueAt("int Fila", "int Columna");
        
        if (tablaQuejas.getSelectedRowCount() == 1) { //Fila seleccionada
            
            //Obtengo el numero de la fila seleccionada y toda la info relacionada al caso 
            int numFila = tablaQuejas.getSelectedRow();
            int numCaso = Integer.parseInt(tablaQuejas.getValueAt(numFila, 0).toString());
            String usuario = (String)tablaQuejas.getValueAt(numFila, 1);
            String motivo = (String)tablaQuejas.getValueAt(numFila, 2);
            String estado = (String)tablaQuejas.getValueAt(numFila, 3);
            
            //Se debe obtener la descripción, fecha e idPasajero.
            ArrayList<String> infoRestante = obtenerInfoRestante(numCaso);
            
            if(infoRestante.size()==0){
                //Si no se obtuvo la información del caso, se muesta el error y se devuelve nulo
                JOptionPane.showMessageDialog(null, "No hay info del caso seleccionado", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return null;
            }
            else{
                
                //Se obtienen los datos faltantes para crear un caso
                String desc = infoRestante.get(0);
                String fecha = infoRestante.get(1);
                String idPasajero = infoRestante.get(2);
                
                int codEstacion = estacion.getCodigo();
                
                
                //Creo el caso y lo retorno
                Caso unCaso = new Caso(numCaso, desc, motivo, fecha, estado, codEstacion, idPasajero, idEmpleado);
                
                return unCaso;
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Seleccione una fila", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        
        
    }
    
    
    /*
    Este método se encarga de obtener la info restante de un caso que no se encuentra en la tablaQuejas
    Obtiene: descripción, fecha, idPasajero de un numeroCaso dado
    */
    public ArrayList<String> obtenerInfoRestante(int numCaso){
        
        ArrayList<String> info = new ArrayList<>();
        
        info = daoCaso.obtenerInfoRestante(numCaso);
        
        
        
        return info;
    }
    
    
    
    /*
    Este método se encarga de llenar la tablaQuejas con la información de los casos que han ocurrido en cierta estación 
    */
    public void llenarTablaQuejas(int cod_estacion, JTable tablaQuejas){
        
        ArrayList<String> unCaso = daoCaso.obtenerInfoCaso(cod_estacion);

        DefaultTableModel modelo = (DefaultTableModel) tablaQuejas.getModel();

        // Eliminando el contenido de la tabla
        for (int i = 0; i < tablaQuejas.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
        
        // Ingresando el contenido a la tabla
        for (int i = 0; i < unCaso.size(); i+=4) {

            Object[] fila = new Object[5];

            fila[0] = unCaso.get(i);
            fila[1] = unCaso.get(i+1);
            fila[2] = unCaso.get(i+2);
            fila[3] = unCaso.get(i+3);

            modelo.addRow(fila);
        }

        //Sección 5
        tablaQuejas.setModel(modelo);
        
    }
    
    
    
    /*
    Este método se encarga de colocar las distintas medidas que se han tomado para un caso en la tabla dada
    */
    public void colocarMedidas(JTable tablaMedidas, int cod_caso){
        
        //Obtengo dicha información
        ArrayList<String> medidas = new ArrayList<>();
        medidas = daoCaso.obtenerMedidas(cod_caso);
        
        DefaultTableModel modelo = (DefaultTableModel) tablaMedidas.getModel();

        // Eliminando el contenido de la tabla
        for (int i = 0; i < tablaMedidas.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }

        // Ingresando el contenido a la tabla
        for (int i = 0; i < medidas.size(); i++) {

            Object[] fila = new Object[2];

            fila[0] = medidas.get(i);

            modelo.addRow(fila);
        }

        //Sección 5
        tablaMedidas.setModel(modelo);
        
        
    }
    
    /*
    Este método se encarga de añadir una medida a un caso y a su vez guardarla en la tabla 'medidas_casos' en la BD
    */
    public void agregarMedida(int cod_caso, JTable tablaMedidas){
        
        String medida = JOptionPane.showInputDialog(null, "Ingrese una medida");
        
        DefaultTableModel modelo = (DefaultTableModel) tablaMedidas.getModel();
        Object[] fila = new Object[2];

        fila[0] = medida;
        //Se coloca en la tabla
        modelo.addRow(fila);
        
        
        //Se agrega en la bd
        int filas = daoCaso.guardarMedida(cod_caso, medida);
        if(filas == -1){
            modelo.removeRow(modelo.getRowCount());
        }
        
    }
    
    /*
    Este método se encargará de cambiar el estado de un caso a 'Solucionado'
    */
    public boolean solucionarCaso(JTable tabla, int cod_caso){
        
        //Primero hay que verificar que al menos haya una medida para dicho caso
        int cantMedidas = tabla.getRowCount();
        if(cantMedidas > 0){
            
            //Se actualiza en BD
            int resultado = daoCaso.solucionarCaso(cod_caso);
            
            if(resultado != -1){ //En caso de que no hayan habido errores al momento de actualizar
                return true;
            }
            else{ //Error en la actualización
                return false; 
            }
            
        }
        else{ //No hay medidas 
            JOptionPane.showMessageDialog(null, "Debe existir al menos una medida para solucionar el caso", 
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        
    }
    
    
    
    // Nuevo : Jhonier
    
    public void informacionReporteCasos(JTable tabla, String nom_estacion, String fecha){
        
        ArrayList<String[]> informacion = daoCaso.informacionReporteCasos(nom_estacion, fecha);

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        for (int i = 0; i < tabla.getRowCount(); i++) {
           modelo.removeRow(i);
           i-=1;
       }
        
        for (int i = 0; i < informacion.size(); i++) {
            
            Object[] fila = new Object[4];
            
            fila[0] = informacion.get(i)[0];
            fila[1] = informacion.get(i)[1];
            fila[2] = informacion.get(i)[2];
            fila[3] = informacion.get(i)[3];
                               
            modelo.addRow(fila);
        }
        
        tabla.setModel(modelo);        
        
    }
    

    
    
    // Nuevo : Jhonier
    
    public void informacionQuejasComunes(JTable tabla){
        
        ArrayList<String[]> informacion = daoCaso.informacionQuejasComunes();

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        for (int i = 0; i < tabla.getRowCount(); i++) {
           modelo.removeRow(i);
           i-=1;
       }
        
        for (int i = 0; i < informacion.size(); i++) {
            
            Object[] fila = new Object[2];
            
            fila[0] = informacion.get(i)[0];
            fila[1] = informacion.get(i)[1];
                               
            modelo.addRow(fila);
        }
        
        tabla.setModel(modelo);        
        
    }
    
    public int ponerCasoEnProceso(int cod_caso){
        
        int resultado = daoCaso.ponerCasoEnProceso(cod_caso);
        
        return resultado;
        
    }
    
    
}
