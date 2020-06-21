/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

/**
 *
 * @author Joan
 */

import java.sql.*;
import java.util.ArrayList;
import logica.*;

public class DaoEmpleado {
    
    FachadaBD fachada = new FachadaBD();
    
    
    public int buscarLogin(String idEmpleado){
        
        String sql_select;
        sql_select="SELECT count(*) FROM empleado WHERE id_empleado='" + idEmpleado +  "' AND estado='Activo';";
        int cantidad = 0; 
        
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                cantidad = Integer.parseInt(tabla.getString(1));
            }
            
           fachada.cerrarConexion(conn);
           return cantidad;
         }
         
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return cantidad;
        
    }   
    
    public Empleado obtenerEmpleado(String idEmpleado){
        
        String sql_select;
        sql_select="SELECT * FROM empleado WHERE id_empleado='" + idEmpleado +  "' ;";
        
        Empleado empleado = null;
        
        String id_empleado = "", nombre = "",
               direccion = "", telefono = "",
               fecha_nac = "", cargo = "",
               estado = "", password = "";
        double salario = 0;
        
        try{
           Connection conn= fachada.conectar();
           Statement sentencia = conn.createStatement();
           ResultSet tabla = sentencia.executeQuery(sql_select);

           while(tabla.next()){

               id_empleado = tabla.getString(1);
               nombre = tabla.getString(2);
               direccion = tabla.getString(3);
               telefono = tabla.getString(4);
               fecha_nac = tabla.getString(5);
               cargo = tabla.getString(6);
               salario = tabla.getDouble(7);
               estado = tabla.getString(8);
               password = tabla.getString(9);

               empleado = new Empleado(id_empleado, nombre, direccion, telefono, fecha_nac, salario, cargo, estado, password);

           }

          fachada.cerrarConexion(conn);
        }

        catch(SQLException e){ e.printStackTrace(); }
        catch(Exception e){ System.out.println(e); }

        return empleado;        
    }
    
    
    //Joan
    
    public ArrayList<Empleado> obtenerConductoresAsignados(){
        
        ArrayList<Empleado> conductores = new ArrayList<>();
        String sql_select = "SELECT DISTINCT id_empleado, nombre, placa FROM empleado NATURAL JOIN asignaciones_conductores;";
        
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            String idEmpleado, nombre, placa;
            Empleado empleado = null;
                        
            while(tabla.next()){
                
                idEmpleado = tabla.getString(1);
                nombre = tabla.getString(2);
                placa = tabla.getString(3);        
                
                empleado = new Empleado(idEmpleado, nombre, "","","",0, "", "", "");
                empleado.setPlacaBus(placa);
                
                conductores.add(empleado);
            }
            
            return conductores;
            
        }
        catch(SQLException e){ e.printStackTrace(); }
        catch(Exception e){ System.out.println(e); }
        
        return conductores;
        
    }
    
    //Joan
    
    public ArrayList<Empleado> obtenerConductoresSinAsignar(){
        
        ArrayList<Empleado> conductores = new ArrayList<>();
        String sql_select = "SELECT id_empleado, nombre FROM empleado WHERE cargo='Conductor'"
                + "EXCEPT SELECT DISTINCT id_empleado, nombre FROM empleado NATURAL JOIN asignaciones_conductores;";
        
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            String idEmpleado, nombre, placa;
            Empleado empleado = null;
                        
            while(tabla.next()){
                
                idEmpleado = tabla.getString(1);
                nombre = tabla.getString(2);                      
                
                empleado = new Empleado(idEmpleado, nombre, "","","",0, "", "", "");
                                
                conductores.add(empleado);
            }
            
            return conductores;
            
        }
        catch(SQLException e){ e.printStackTrace(); }
        catch(Exception e){ System.out.println(e); }
        
        return conductores;
        
    }
    
    //Joan
    
    public ArrayList<Empleado> obtenerDirectoresEstacionDisponibles(){
        
        ArrayList<Empleado> directores = new ArrayList<>();
        String sql_select = "SELECT id_empleado, nombre FROM empleado WHERE cargo='Director de Estacion'"
                + " EXCEPT "
                + "SELECT id_empleado, empleado.nombre FROM empleado, estacion WHERE empleado.id_empleado=estacion.id_director;";
        
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            String idEmpleado, nombre, placa;
            Empleado empleado = null;
                        
            while(tabla.next()){
                
                idEmpleado = tabla.getString(1);
                nombre = tabla.getString(2);                      
                
                empleado = new Empleado(idEmpleado, nombre, "","","",0, "", "", "");
                                
                directores.add(empleado);
            }
            
            return directores;
            
        }
        catch(SQLException e){ e.printStackTrace(); }
        catch(Exception e){ System.out.println(e); }
        
        return directores;
        
    }
    
    
    /*
    Este método se encarga de actualizar los datos de un empleado
    Se actualizan teléfono, dirección y/o contraseña
    Se recibe el id del empleado a actualizar
    */
    public int actualizarDatos(String idEmpleado, String tel, String dir, String pwd){
        String sql = "UPDATE empleado SET telefono = '"+tel+"', direccion='"+dir+"', "
                + "password='"+pwd+"' WHERE id_empleado='"+idEmpleado+"';";
        try{
            Connection conexion= fachada.conectar();
            Statement sentencia = conexion.createStatement();
            int numFilas = sentencia.executeUpdate(sql);
            conexion.close();
            return numFilas;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return -1;
    }
    
    
    
    // Nuevo : Jhonier
    
    public ArrayList<Empleado> obtenerLosEmpleados(String condicion){
        
        String sql_select;
        sql_select="SELECT * FROM empleado "+condicion+" ORDER BY id_empleado;";
        
        ArrayList<Empleado> empleados = new ArrayList<>();
        String id_empleado = "", nombre = "",
               direccion = "", telefono = "",
               fecha_nac = "", cargo = "",
               estado = "", password = "";
        double salario = 0;
        
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                
                id_empleado = tabla.getString(1);
                nombre = tabla.getString(2);
                direccion = tabla.getString(3);
                telefono = tabla.getString(4);
                fecha_nac = tabla.getString(5);
                cargo = tabla.getString(6);
                salario = tabla.getDouble(7);
                estado = tabla.getString(8);
                password = tabla.getString(9);
                
                Empleado nuevoEmpleado = new Empleado(id_empleado, nombre, direccion, telefono, fecha_nac, salario, cargo, estado, password);
                
                empleados.add(nuevoEmpleado);
            }
            
           fachada.cerrarConexion(conn);
         }
         
         catch(SQLException e){ e.printStackTrace(); }
         catch(Exception e){ System.out.println(e); }
        return empleados;
        
    }
    
    // Nuevo : Jhonier
    public int registrarEmpleado(Empleado empleado){
        
        String sql_guardar;
                 
        sql_guardar = "INSERT INTO empleado VALUES "
                + "('"+empleado.getId()+"', '"+empleado.getNombre()+"', '"+empleado.getDireccion()+"',"
                + "'"+empleado.getTelefono()+"','"+empleado.getFechaNacimiento()+"', '"+empleado.getCargo()+"',"
                + "'"+empleado.getSalario()+"','"+empleado.getEstado()+"','"+empleado.getPassword()+"');";
        try{
            Connection conexion= fachada.conectar();
            Statement sentencia = conexion.createStatement();
            int numFilas = sentencia.executeUpdate(sql_guardar);
            conexion.close();
            return numFilas;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return -1;
        
    }
    
    
    // Nuevo : Jhonier
    public int modificarEmpleado(Empleado empleado){
        
        String sql_guardar;
                 
        sql_guardar = "UPDATE empleado SET "
                + "nombre='"+empleado.getNombre()+"',direccion='"+empleado.getDireccion()+"',"
                + "telefono='"+empleado.getTelefono()+"',fecha_nac='"+empleado.getFechaNacimiento()+"',cargo='"+empleado.getCargo()+"',"
                + "salario='"+empleado.getSalario()+"',estado='"+empleado.getEstado()+"',password='"+empleado.getPassword()+"'"
                + "WHERE id_empleado='"+empleado.getId()+"';";
        try{
            Connection conexion= fachada.conectar();
            Statement sentencia = conexion.createStatement();
            int numFilas = sentencia.executeUpdate(sql_guardar);
            conexion.close();
            return numFilas;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return -1;
        
    }
    
    
    
    
    
    
}
