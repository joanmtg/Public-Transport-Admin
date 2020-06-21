/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Joan
 */
public class Caso {
    
    private int codigo;
    private String descripcion;
    private String motivo;
    private String fecha;
    private String estado;
    private int codEstacion;
    private String idPasajero;
    private String idEmpleado;
    
    public Caso(int codigo, String descripcion, String motivo, String fecha, String estado, int codEstacion, String idPasajero, String idEmpleado) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.motivo = motivo;
        this.fecha = fecha;
        this.estado = estado;
        this.codEstacion = codEstacion;
        this.idPasajero = idPasajero;
        this.idEmpleado = idEmpleado;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public int getCodEstacion() {
        return codEstacion;
    }

    public String getIdPasajero() {
        return idPasajero;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }
    
    
    
}
