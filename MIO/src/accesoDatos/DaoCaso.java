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
import java.util.*;
import logica.*;

public class DaoCaso {
    
    FachadaBD fachada = new FachadaBD();
    
    
    public int registrarCaso(String descripcion, String motivo, String fecha, int codEstacion, String idPasajero, String idEmpleado){
        
        String sql_guardar;
        
        sql_guardar = "INSERT INTO caso(descripcion, motivo, fecha, estado, cod_estacion, id_pasajero, id_empleado) VALUES( '"
                + descripcion +"', '" + motivo + "', '" + fecha + "', 'Iniciado', " + codEstacion + ", '"+ idPasajero + "', '" + idEmpleado + "');";
        
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
    
    
    /*
    Este metodo obtendrá la descripción, fecha, idPasajero de un numeroCaso dado
    */
    public ArrayList<String> obtenerInfoRestante(int numCaso){
        
        
        ArrayList<String> informacion = new ArrayList<>();
        
        //Se busca la informacion en la tabla empleados
        
        String sql_select, desc="", fecha="", idPasajero ="";
        sql_select = "SELECT descripcion, fecha, id_pasajero from caso where cod_caso = "+numCaso+";";
        try{
            Connection conexion= fachada.conectar();
            Statement sentencia = conexion.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            //
            while(tabla.next()){
                desc = tabla.getString(1);
                fecha = tabla.getString(2);
                idPasajero = tabla.getString(3);
                
                //Se agrega al array que se retornará
                informacion.add(desc); //indice 0
                informacion.add(fecha); //indice 1
                informacion.add(idPasajero); //indice 2
                
            }
             conexion.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        
        return informacion;
    }
    
    
    /*
    Este metodo retornará un array tipo String con la información de los distintos casos presentados en una estación dada
    */
    public ArrayList<String> obtenerInfoCaso(int cod_estacion){
        
        ArrayList<String> unCaso = new ArrayList<>();
        
        //Se busca la informacion en la tabla Caso
        
        String sql_select, cod_caso="", nombre="", motivo="", estado="";
        sql_select = "SELECT cod_caso, nombre, motivo, estado from caso NATURAL JOIN pasajero"
                + " where cod_estacion = "+cod_estacion+" AND estado != 'Solucionado';";
        try{
            Connection conexion= fachada.conectar();
            Statement sentencia = conexion.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            //
            while(tabla.next()){
                cod_caso = tabla.getString(1);
                nombre = tabla.getString(2);
                motivo = tabla.getString(3);
                estado = tabla.getString(4);
                
                //Se agrega al array que se retornará
                unCaso.add(cod_caso); //indice 0
                unCaso.add(nombre); //indice 1
                unCaso.add(motivo); //indice 2
                unCaso.add(estado); //indice 3
                
            }
             conexion.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        
        return unCaso;
    }
    
    /*
    Este metodo retornará un array tipo String con la información de los distintos casos presentados en una estación dada
    */
    public ArrayList<String> obtenerMedidas(int cod_caso){
        
        ArrayList<String> info = new ArrayList<>();
        
        //Se busca la informacion en la tabla Caso
        
        String sql_select, medida="";
        sql_select = "SELECT medida from medidas_casos where cod_caso = "+cod_caso+";";
        try{
            Connection conexion= fachada.conectar();
            Statement sentencia = conexion.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            //
            while(tabla.next()){
                medida = tabla.getString(1);
                
                //Se agrega al array que se retornará
                info.add(medida); //indice 0
                
            }
             conexion.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        
        return info;
    }
    
    
    /*
    Este método se encarga de agregar una medida a un caso
    */
    public int guardarMedida(int cod_caso, String medida){
        String sql = "INSERT INTO medidas_casos VALUES ('" + medida+
                "',"+cod_caso+ ");";
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
    
    
    /*
    Este método se encarga de, dado el código de un caso, marcarlo como solucionado
    */
    public int ponerCasoEnProceso(int cod_caso){
        String sql = "UPDATE caso SET estado = 'En proceso' WHERE cod_caso="+cod_caso;
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
    
    
    /*
    Este método se encarga de, dado el código de un caso, marcarlo como solucionado
    */
    public int solucionarCaso(int cod_caso){
        String sql = "UPDATE caso SET estado = 'Solucionado' WHERE cod_caso="+cod_caso;
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
    
    public ArrayList<String[]> informacionReporteCasos(String nom_estacion, String fecha){
        
        ArrayList<String[]> informacion = new ArrayList<>();
        
        String sql_select, cod_caso="", pasajero="", motivo="", empleado="";
        sql_select = "SELECT cod_caso, nom_pasajero, motivo, id_empleado from caso NATURAL JOIN (SELECT id_pasajero, nombre nom_pasajero FROM pasajero) AS pasajeroCaso"
                   + " NATURAL JOIN (SELECT cod_estacion FROM Estacion WHERE nombre='"+nom_estacion+"') AS estacionCaso "
                   + " WHERE fecha = '"+fecha+"';";
        try{
            Connection conexion= fachada.conectar();
            Statement sentencia = conexion.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            //
            while(tabla.next()){
                cod_caso = tabla.getString(1);
                pasajero = tabla.getString(2);
                motivo = tabla.getString(3);
                empleado = tabla.getString(4);
                
                String[] inf = new String[4];
                inf[0] = cod_caso;
                inf[1] = pasajero;
                inf[2] = motivo;
                
                if(empleado == null){
                    empleado = "N/A";
                }
                inf[3] = empleado;
                
                informacion.add(inf);
            }
             conexion.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        
        return informacion;
    }
    
    
    

    // Nuevo : Jhonier
    
    public ArrayList<String[]> informacionQuejasComunes(){
        
        ArrayList<String[]> informacion = new ArrayList<>();
        
        String sql_select, motivo="", numVeces="";
        sql_select = "SELECT motivo, Count(*) vecesPresentada FROM Caso "
                   + "GROUP BY motivo;";
        try{
            Connection conexion= fachada.conectar();
            Statement sentencia = conexion.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            //
            while(tabla.next()){
                motivo = tabla.getString(1);
                numVeces = tabla.getString(2);
                
                String[] inf = new String[4];
                inf[0] = motivo;
                inf[1] = numVeces;
                
                informacion.add(inf);
            }
             conexion.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        
        return informacion;
    }
    
}




