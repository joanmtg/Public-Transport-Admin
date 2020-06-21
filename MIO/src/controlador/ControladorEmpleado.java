/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.DaoEmpleado;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import logica.*;

/**
 *
 * @author Joan
 */
public class ControladorEmpleado {
    
    DaoEmpleado daoEmpleado = new DaoEmpleado();
    
    
    public Empleado verificarLogin(String idEmpleado, String password, JLabel labelInfEmp)
    {
        Empleado nuevoEmpleado = null;
        int verificarLogin = daoEmpleado.buscarLogin(idEmpleado);
        
        if(verificarLogin > 0)
        {
            Empleado empleado = daoEmpleado.obtenerEmpleado(idEmpleado);
            
            String passwordEmp = empleado.getPassword();
            
            if(password.equals(passwordEmp))
            {
                nuevoEmpleado = empleado;
                return nuevoEmpleado;
            }
            else
            {
                labelInfEmp.setText("Contraseña incorrecta");
            }
        }
        else
        {
            labelInfEmp.setText("El usuario no está registrado");
        }
        
        return nuevoEmpleado;
    }
    
    //Joan
    
    
    public ArrayList<Empleado> obtenerConductores(String tipo){
        
        ArrayList<Empleado> conductores;
        
        if(tipo.equals("Asignados")){            
            conductores = daoEmpleado.obtenerConductoresAsignados();            
        }
        else{
            conductores = daoEmpleado.obtenerConductoresSinAsignar();
        }        
        
        return conductores;        
    }
    
    //Joan
    
    public ArrayList<Empleado> obtenerDirectoresEstacionDisponibles(){
        
        ArrayList<Empleado> directores = daoEmpleado.obtenerDirectoresEstacionDisponibles();
        
        return directores;
                        
    }
    
    /*
    Este método se encarga de actualizar los datos de un empleado
    Se actualizan teléfono, dirección y/o contraseña
    Se recibe el id del empleado a actualizar
    */
    public void actualizarDatos(String idEmpleado, String tel, String dir, String pwd){
        
        int resultado = daoEmpleado.actualizarDatos(idEmpleado, tel, dir, pwd);
        
        if(resultado != -1){
            JOptionPane.showMessageDialog(null,"Se actualizaron los datos correctamente" , 
                    "Update successful", JOptionPane.PLAIN_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Ocurrió un error al momento de actualizar los datos. Intente nuevamente", 
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    // Nuevo : Jhonier
    
    public void informacionEmpleados(JTable tabla, String condicion) {
        ArrayList<Empleado> empleados = daoEmpleado.obtenerLosEmpleados(condicion);

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        for (int i = 0; i < tabla.getRowCount(); i++) {
           modelo.removeRow(i);
           i-=1;
       }
        
        for (int i = 0; i < empleados.size(); i++) {
            
            Object[] fila = new Object[7];
            
            fila[0] = empleados.get(i).getId();
            fila[1] = empleados.get(i).getNombre();
            fila[2] = empleados.get(i).getDireccion();
            fila[3] = empleados.get(i).getTelefono();
            fila[4] = empleados.get(i).getSalario();
            fila[5] = empleados.get(i).getCargo();
            fila[6] = empleados.get(i).getEstado();
                               
            modelo.addRow(fila);
        }
        
        tabla.setModel(modelo);

    }
    
    
    // Nuevo : Jhonier
    
    public void registrarEmpleado(String identificacion, String nombre, String direccion, String telefono,
                                  String fechaNacimiento, String cargo, String estado, double salario,
                                  String password){
        
        Empleado nuevoEmpleado = new Empleado(identificacion, nombre, direccion, telefono, fechaNacimiento, salario, cargo, estado, password);
    
        int verificar = daoEmpleado.registrarEmpleado(nuevoEmpleado);
        
        if(verificar != -1){
            JOptionPane.showMessageDialog(null, "El empleado fue registrado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Ocurrió un error durante el registro del empleado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    //Nuevo : Jhonier
    
    public void modificarEmpleado(String identificacion, String nombre, String direccion, String telefono,
                                  String fechaNacimiento, String cargo, String estado, double salario,
                                  String password){
        
        Empleado empleadoModf = new Empleado(identificacion, nombre, direccion, telefono, fechaNacimiento, salario, cargo, estado, password);
        int verificar = daoEmpleado.modificarEmpleado(empleadoModf);
        
        if(verificar != -1){
            JOptionPane.showMessageDialog(null, "El empleado se modificó correctamente","Confirmación",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Ocurrió un error al modificar el empleado", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }


    //Nuevo : Jhonier
    
    public Empleado obtenerEmpleado(String identificacion){
        
        Empleado nuevoEmpleado = daoEmpleado.obtenerEmpleado(identificacion);
        
        return nuevoEmpleado;
    }
    
}
