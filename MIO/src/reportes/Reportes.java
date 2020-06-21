/**
 * Proyecto Bases de Datos I
 * Fecha de entrega: 
 * Profesor: 
 * 
 * Integrantes:
 *
 * Jhonier Andrés Calero Rodas      1424599
 * Fabio Andrés Castañeda Duarte    1424386
 * Juan Pablo Moreno Muñoz          1423437
 * Joan Manuel Tovar Guzmán         1423124
 * 
 * Universidad del Valle
 * 2016-II
 */

package reportes;

import java.util.List;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Jhonier Andres
 */

public class Reportes {
   
    
    public void reporteEmpleados(String codEmpleado, String nomEmpleado){
       Connection conectar;
       JasperReport report = null;
       
       try
       {
            conectar = DriverManager.getConnection("jdbc:postgresql://localhost:5432/miobd", "wayne", "arkham");
       
            URL ruta = this.getClass().getResource("/reportes/reporteEmpleados.jasper");
            URL rutaLogo = this.getClass().getResource("/imagenes/logoMio.png");
            
            
            report = (JasperReport) JRLoader.loadObject(ruta);
            Map parametros = new HashMap();
            parametros.put("codEmpleado", codEmpleado);
            parametros.put("nomEmpleado", nomEmpleado);
            parametros.put("logo", rutaLogo);
            JasperPrint contenido = JasperFillManager.fillReport(report, parametros, conectar);
            JasperViewer visualizar = new JasperViewer(contenido, false);
            visualizar.setZoomRatio(1.0F);
            visualizar.setVisible(true);
       
       }catch(SQLException ex)
       {
           JOptionPane.showMessageDialog(null, "No fue posible conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
       }catch(JRException ex)
       {
           JOptionPane.showMessageDialog(null, "No se pudo generar el reporte " + ex, "Error", JOptionPane.ERROR_MESSAGE);
       }
      
    }
    
    
    public void reporteRutas(String codEmpleado, String nomEmpleado){
       Connection conectar;
       JasperReport report = null;
       
       try
       {
            conectar = DriverManager.getConnection("jdbc:postgresql://localhost:5432/miobd", "wayne", "arkham");
       
            URL ruta = this.getClass().getResource("/reportes/reporteRutas.jasper");
            URL rutaLogo = this.getClass().getResource("/imagenes/logoMio.png");
            
            
            report = (JasperReport) JRLoader.loadObject(ruta);
            Map parametros = new HashMap();
            parametros.put("codEmpleado", codEmpleado);
            parametros.put("nomEmpleado", nomEmpleado);
            parametros.put("logo", rutaLogo);
            JasperPrint contenido = JasperFillManager.fillReport(report, parametros, conectar);
            JasperViewer visualizar = new JasperViewer(contenido, false);
            visualizar.setZoomRatio(1.0F);
            visualizar.setVisible(true);
       
       }catch(SQLException ex)
       {
           JOptionPane.showMessageDialog(null, "No fue posible conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
       }catch(JRException ex)
       {
           JOptionPane.showMessageDialog(null, "No se pudo generar el reporte " + ex, "Error", JOptionPane.ERROR_MESSAGE);
       }
      
    }
    
    
    public void reporteQuejas(String nom_estacion, String fecha){
       Connection conectar;
       JasperReport report = null;
       
       try
       {
            conectar = DriverManager.getConnection("jdbc:postgresql://localhost:5432/miobd", "wayne", "arkham");
       
            URL ruta = this.getClass().getResource("/reportes/reporteQuejas.jasper");
            URL rutaLogo = this.getClass().getResource("/imagenes/logoMio.png");
            report = (JasperReport) JRLoader.loadObject(ruta);
            Map parametros = new HashMap();
            parametros.put("nom_estacion", nom_estacion);
            parametros.put("fecha", fecha);
            parametros.put("logo", rutaLogo);
            JasperPrint contenido = JasperFillManager.fillReport(report, parametros, conectar);
            JasperViewer visualizar = new JasperViewer(contenido, false);
            visualizar.setZoomRatio(1.0F);
            visualizar.setVisible(true);
       
       }catch(SQLException ex)
       {
           JOptionPane.showMessageDialog(null, "No fue posible conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
       }catch(JRException ex)
       {
           JOptionPane.showMessageDialog(null, "No se pudo generar el reporte " + ex, "Error", JOptionPane.ERROR_MESSAGE);
       }
      
    }
    
    
    public void reporteRutasPasajero(String id_pasajero){
       Connection conectar;
       JasperReport report = null;
       
       try
       {
            conectar = DriverManager.getConnection("jdbc:postgresql://localhost:5432/miobd", "wayne", "arkham");
       
            URL ruta = this.getClass().getResource("/reportes/reporteRutasPasajero.jasper");
            URL rutaLogo = this.getClass().getResource("/imagenes/logoMio.png");
            report = (JasperReport) JRLoader.loadObject(ruta);
            Map parametros = new HashMap();
            parametros.put("id_pasajero", id_pasajero);
            parametros.put("logo", rutaLogo);
            JasperPrint contenido = JasperFillManager.fillReport(report, parametros, conectar);
            JasperViewer visualizar = new JasperViewer(contenido, false);
            visualizar.setZoomRatio(1.0F);
            visualizar.setVisible(true);
       
       }catch(SQLException ex)
       {
           JOptionPane.showMessageDialog(null, "No fue posible conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
       }catch(JRException ex)
       {
           JOptionPane.showMessageDialog(null, "No se pudo generar el reporte " + ex, "Error", JOptionPane.ERROR_MESSAGE);
       }
      
    }
    
    

    public void reporteBusesConductores(){
       Connection conectar;
       JasperReport report = null;
       
       try
       {
            conectar = DriverManager.getConnection("jdbc:postgresql://localhost:5432/miobd", "wayne", "arkham");
       
            URL ruta = this.getClass().getResource("/reportes/reporteBusesConductores.jasper");
            URL rutaLogo = this.getClass().getResource("/imagenes/logoMio.png");
            
            
            report = (JasperReport) JRLoader.loadObject(ruta);
            Map parametros = new HashMap();
            parametros.put("logo", rutaLogo);
            JasperPrint contenido = JasperFillManager.fillReport(report, parametros, conectar);
            JasperViewer visualizar = new JasperViewer(contenido, false);
            visualizar.setZoomRatio(1.0F);
            visualizar.setVisible(true);
       
       }catch(SQLException ex)
       {
           JOptionPane.showMessageDialog(null, "No fue posible conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
       }catch(JRException ex)
       {
           JOptionPane.showMessageDialog(null, "No se pudo generar el reporte " + ex, "Error", JOptionPane.ERROR_MESSAGE);
       }
      
    }
    
    
    
 
    public void reportePasajeros(){
       Connection conectar;
       JasperReport report = null;
       
       try
       {
            conectar = DriverManager.getConnection("jdbc:postgresql://localhost:5432/miobd", "wayne", "arkham");
       
            URL ruta = this.getClass().getResource("/reportes/reportePasajeros.jasper");
            URL rutaLogo = this.getClass().getResource("/imagenes/logoMio.png");
            
            
            report = (JasperReport) JRLoader.loadObject(ruta);
            Map parametros = new HashMap();
            parametros.put("logo", rutaLogo);
            JasperPrint contenido = JasperFillManager.fillReport(report, parametros, conectar);
            JasperViewer visualizar = new JasperViewer(contenido, false);
            visualizar.setZoomRatio(1.0F);
            visualizar.setVisible(true);
       
       }catch(SQLException ex)
       {
           JOptionPane.showMessageDialog(null, "No fue posible conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
       }catch(JRException ex)
       {
           JOptionPane.showMessageDialog(null, "No se pudo generar el reporte " + ex, "Error", JOptionPane.ERROR_MESSAGE);
       }
      
    }
    
    
    public void reporteQuejasComunes(){
       Connection conectar;
       JasperReport report = null;
       
       try
       {
            conectar = DriverManager.getConnection("jdbc:postgresql://localhost:5432/miobd", "wayne", "arkham");
       
            URL ruta = this.getClass().getResource("/reportes/reporteQuejasMasComunes.jasper");
            URL rutaLogo = this.getClass().getResource("/imagenes/logoMio.png");
            
            
            report = (JasperReport) JRLoader.loadObject(ruta);
            Map parametros = new HashMap();
            parametros.put("logo", rutaLogo);
            JasperPrint contenido = JasperFillManager.fillReport(report, parametros, conectar);
            JasperViewer visualizar = new JasperViewer(contenido, false);
            visualizar.setZoomRatio(1.0F);
            visualizar.setVisible(true);
       
       }catch(SQLException ex)
       {
           JOptionPane.showMessageDialog(null, "No fue posible conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
       }catch(JRException ex)
       {
           JOptionPane.showMessageDialog(null, "No se pudo generar el reporte " + ex, "Error", JOptionPane.ERROR_MESSAGE);
       }
      
    }
    
    public void reporteMovilizacionRutas(String codEmpleado, String nomEmpleado, String fecha){
       Connection conectar;
       JasperReport report = null;
       
       try
       {
            conectar = DriverManager.getConnection("jdbc:postgresql://localhost:5432/miobd", "wayne", "arkham");
       
            URL ruta = this.getClass().getResource("/reportes/reporteMovilizacionRutas.jasper");
            URL rutaLogo = this.getClass().getResource("/imagenes/logoMio.png");
            report = (JasperReport) JRLoader.loadObject(ruta);
            Map parametros = new HashMap();
            parametros.put("codEmpleado", codEmpleado);
            parametros.put("nomEmpleado", nomEmpleado);
            parametros.put("logo", rutaLogo);
            parametros.put("fecha", fecha);
            JasperPrint contenido = JasperFillManager.fillReport(report, parametros, conectar);
            JasperViewer visualizar = new JasperViewer(contenido, false);
            visualizar.setZoomRatio(1.0F);
            visualizar.setVisible(true);
       
       }catch(SQLException ex)
       {
           JOptionPane.showMessageDialog(null, "No fue posible conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
       }catch(JRException ex)
       {
           JOptionPane.showMessageDialog(null, "No se pudo generar el reporte " + ex, "Error", JOptionPane.ERROR_MESSAGE);
       }
      
    }
    
    
    
    public void reporteVentaTarjetas(String fecha){
       Connection conectar;
       JasperReport report = null;
       
       try
       {
            conectar = DriverManager.getConnection("jdbc:postgresql://localhost:5432/miobd", "wayne", "arkham");
       
            URL ruta = this.getClass().getResource("/reportes/reporteVentaTarjetas.jasper");
            URL rutaLogo = this.getClass().getResource("/imagenes/logoMio.png");
            report = (JasperReport) JRLoader.loadObject(ruta);
            Map parametros = new HashMap();
            parametros.put("fecha", fecha);
            parametros.put("logo", rutaLogo);
            JasperPrint contenido = JasperFillManager.fillReport(report, parametros, conectar);
            JasperViewer visualizar = new JasperViewer(contenido, false);
            visualizar.setZoomRatio(1.0F);
            visualizar.setVisible(true);
       
       }catch(SQLException ex)
       {
           JOptionPane.showMessageDialog(null, "No fue posible conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
       }catch(JRException ex)
       {
           JOptionPane.showMessageDialog(null, "No se pudo generar el reporte " + ex, "Error", JOptionPane.ERROR_MESSAGE);
       }
      
    }
    
}