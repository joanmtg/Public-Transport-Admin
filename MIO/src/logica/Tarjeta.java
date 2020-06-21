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
public class Tarjeta {
    
    private String pin;
    private int pasajes;
    private String estado;
    private String fechaAdq;
    private int codigoEstacion;

    public Tarjeta(String pin, int pasajes, String estado, String fechaAdq, int codigoEstacion) {
        this.pin = pin;
        this.pasajes = pasajes;
        this.estado = estado;
        this.fechaAdq = fechaAdq;
        this.codigoEstacion = codigoEstacion;
    }

    public String getPin() {
        return pin;
    }

    public int getPasajes() {
        return pasajes;
    }

    public String getEstado() {
        return estado;
    }

    public String getFechaAdq() {
        return fechaAdq;
    }

    public int getCodigoEstacion() {
        return codigoEstacion;
    }
    
    
    
    
}
