/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import logica.*;

/**
 *
 * @author Joan
 */
public class ControladorTarjeta {
    
    DaoTarjeta daoTarjeta = new DaoTarjeta();
    DaoPasajero daoPasajero = new DaoPasajero();
    ControladorIngresoRuta ingresoRuta = new ControladorIngresoRuta();
            
           
    /*
    Este metodo se encarga de obtener la cantidad de pasajes tiene actualmente una tarjeta
    */
    public int obtenerSaldo(String pin){
        int pasajes = daoTarjeta.obtenerSaldo(pin);
        if(pasajes != -5){ //Si es != -5 no hubo problema al obtener la información de las tablas
            return pasajes;
        }
        else{ //Si devuelve -5 es porque algo pasó en SQL
            JOptionPane.showMessageDialog(null, "Error al obtener el saldo de la tarjeta. Intentelo nuevamente", "Error", JOptionPane.WARNING_MESSAGE);
            return pasajes;
        }
        
    }
    
    
    /*
    Se usa para modificar los datos de un pasajero
    Método que valida si una tarjeta está en la Bd y si pertenece a algún usuario already
    En caso de que pertenezca a alguien (cant == 1) -> Error
    Si no pertenece a nadie (cant == 0) -> Se devuelve true para que se habiliten los tf y se llene la información correspondiente
    Si cant == -1 ocurrió un error interno -> Llórela
    */
    
    public boolean validarPinTarjeta(String pin, String proceso){
        
        int cantExisteTarjeta = daoTarjeta.validarExistenciaPin(pin); //Devuelve si la tarjeta existe (tabla tarjeta)
        if(cantExisteTarjeta == -1){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error. Ingrese información válida", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
            
        }
        else if(cantExisteTarjeta == 0){
            //Si la cantidad es 0 quiere decir que la tarjeta no existe
            JOptionPane.showMessageDialog(null, "La tarjeta con pin "+ pin+" no existe.", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        else{
            //La tarjeta existe. Se procede a buscar si ya la tiene personalizada algún usuario
            int cantidad = daoPasajero.validarPinTarjetaPersonal(pin); //Devuelve 1 si la tarjeta la tiene personalizada alguien (tabla pasajero)
            
            if(cantidad == -1){ //Error interno de SQL
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error. Ingrese información válida", "Error", JOptionPane.WARNING_MESSAGE);
                return false;
            }
            else if(cantidad == 0){ //Nadie la ha personalizado
                
                if(proceso.equals("Personalización")){
                    return true;
                }
                else{ //proceso="Modificacion"
                    JOptionPane.showMessageDialog(null, "No existe algún usuario registrado con la tarjeta "+ pin, "Error", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
                
            }
            else{ //El count > 0, entonces, alguien la tiene
                
                if(proceso.equals("Personalización")){
                    JOptionPane.showMessageDialog(null, "Ya existe un usuario registrado con la tarjeta "+ pin, "Error", JOptionPane.WARNING_MESSAGE);
                    return false;

                }else{ //proceso=Modificacion
                    return true;
                }
                
            }
            
            
        }
        
    }
    
           
    /*
    Este método se encarga de hacer la simulación cuando un pasajero ingresa a una ruta 
    */
    public boolean ingresarARuta(String pin, String ruta){
        //Primero se valida que la tarjeta al menos exista
        int cantidad = daoTarjeta.validarExistenciaPin(pin);
        if(cantidad==0){ //No existe la tarjeta
            JOptionPane.showMessageDialog(null, "No existe la tarjeta con pin "+pin, "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        else if(cantidad == -1){//Error interno
            JOptionPane.showMessageDialog(null, "Error al ingresar a la ruta. Intentelo nuevamente", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        else{
            
            String estado = daoTarjeta.estadoTarjeta(pin);
            
            if(estado.equals("Bloqueada")){
                JOptionPane.showMessageDialog(null, "La tarjeta con pin " + pin + " se encuentra bloqueada", "Error", JOptionPane.WARNING_MESSAGE);
                return false;
            }
            
            else{//So far so good
                //Obtenemos la cantidad de pasajes para ver si se puede descontar o no
                int pasajes = daoTarjeta.obtenerSaldo(pin);

                //Obtenemos el tipo de tarjeta. Personalizada o normal
                String tipo = "";
                
                int cant = daoPasajero.validarPinTarjetaPersonal(pin);
                
                if (cant == 0) {
                    tipo = "Normal";
                } else {
                    tipo = "Personalizada";
                }

                if (tipo.equals("Normal")) {
                    if (pasajes > 0) {//Se descuenta y se llena el registro
                        daoTarjeta.restarPasaje(pin, pasajes);
                        ingresoRuta.registrarIngresoRuta(pin, ruta);
                        JOptionPane.showMessageDialog(null, "Ingresó");
                        return true;
                    } 
                    else { 
                        //pasajes=0
                        JOptionPane.showMessageDialog(null, "Saldo insuficiente. Saldo: " + pasajes + " pasajes", "Error", JOptionPane.WARNING_MESSAGE);
                        return false;
                    }
                }
                else //En caso de que la tarjeta sea personalizada
                if (pasajes > -3) {//Se descuenta y se llena el registro
                    daoTarjeta.restarPasaje(pin, pasajes);
                    ingresoRuta.registrarIngresoRuta(pin, ruta);
                    JOptionPane.showMessageDialog(null, "Ingresó");
                    return true;
                } 
                else {//pasajes = -3
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente. Saldo: " + pasajes + " pasajes", "Error", JOptionPane.WARNING_MESSAGE);
                    return false;
                }

            }


        }
        
    }
    
    
    
    
    // Nuevo : Jhonier
    
    public void informacionVentasTarjetas(JTable tabla, String fecha){
        
        ArrayList<String[]> informacion = daoTarjeta.ventasTarjetas(fecha);

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
    
       
    //Juan Pablo's New Method
    public boolean sumarPasajes(String pin, int numPasajes){
        
        int cantidad = daoTarjeta.validarExistenciaPin(pin);
        boolean eliminada = daoTarjeta.tarjetaEliminada(pin);
        
        
        if(cantidad == 0){ //No existe la tarjeta
            
            JOptionPane.showMessageDialog(null, "No existe la tarjeta con pin "+pin, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(cantidad == -1){//Error interno
            
            JOptionPane.showMessageDialog(null, "Ocurrió un error. Inténtelo nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            
            if(eliminada == false){
            
                String estado = daoTarjeta.estadoTarjeta(pin);
            
                if(estado.equals("Bloqueada")){
                    JOptionPane.showMessageDialog(null, "La tarjeta con pin " + pin + " se encuentra bloqueada", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            
                else{
                                
                    int pasajes = daoTarjeta.obtenerSaldo(pin);
                
                    int sumar = daoTarjeta.sumarPasaje(pin, pasajes, numPasajes);
                
                    if(sumar == -1){
                                        
                        JOptionPane.showMessageDialog(null, "Error al recargar. Inténtelo nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
                        return false;
                    
                    }else{
                    
                        return true;
                    }              

                }

            }else {
                
                JOptionPane.showMessageDialog(null, "La tarjeta con pin "+pin + " se encuentra eliminada", "Error", JOptionPane.ERROR_MESSAGE);             
                return false;
            }
        
        }
        
    }
    
    //Juan Pablo's New Method
    public String estadoTarjeta(String pin){
                
        String estado = "";                      
        estado = daoTarjeta.estadoTarjeta(pin);
               
        return estado;       
    }
    
    //Juan Pablo's New Method
    public boolean modfEstadoTarjeta(String pin, String estado){
        
        int modificar = daoTarjeta.modfEstadoTarjeta(pin, estado);
        
        if(modificar == -1){           
            
            return false;
            
        }else{        
            
            return true;
        }              
    }
    
    //Juan Pablo's New Method
    public boolean validarPIN(String pin){
        
        int validar = daoTarjeta.validarExistenciaPin(pin);
        
        if(validar == 0){
            
            return false;
            
        }else{
            
            return true;
        }
        
    }
    
    
    //Juan Pablo's New Method
    public int obtenerMaxPin(){
        
        int pin = daoTarjeta.obtenerMaxPinTarjeta();
        
        return pin;        
    }
    
    //Juan Pablo's New Method
    public void registrarTarjeta(int codEstacion, String fecha){
        
        int registro = daoTarjeta.registrarTarjeta(codEstacion, fecha);
        
        if(registro == -1){
            
            JOptionPane.showMessageDialog(null, "Error al registrar la tarjeta. Inténtelo de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
            
        }else{
            
            JOptionPane.showMessageDialog(null, "La tarjeta ha sido registrada exitosamente", "Registro exitoso", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    
    //THIS PIECE OF METHOD
    public boolean tarjetaEliminada(String pin){
        
        boolean eliminada = daoTarjeta.tarjetaEliminada(pin);
        
        
        return eliminada;        
        
    }
    
    
    //THIS PIECE OF METHOD
    public void eliminarTarjeta(String pin){
        
        int eliminar = daoTarjeta.eliminarTarjeta(pin);
        boolean exito = true;
        
        if(eliminar == -1){
            
            JOptionPane.showMessageDialog(null, "Ocurrió un error. Inténtelo de nuevo", "Error", JOptionPane.ERROR_MESSAGE);            
            
        }else{
            
            JOptionPane.showMessageDialog(null, "La tarjeta fue eliminada con éxito", "Borrado exitoso", JOptionPane.PLAIN_MESSAGE);
           
        }
        
    }
    
}
