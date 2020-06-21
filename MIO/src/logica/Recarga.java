/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.sql.*;

/**
 *
 * @author Joan
 */
public class Recarga {
    
    private String pinTarjeta;
    private int codEstacion;
    private Timestamp fechaHora;
    private int num_pasajes;

    public Recarga(String pinTarjeta, int codEstacion, Timestamp fechaHora, int num_pasajes) {
        this.pinTarjeta = pinTarjeta;
        this.codEstacion = codEstacion;
        this.fechaHora = fechaHora;
        this.num_pasajes = num_pasajes;
    }

    public String getPinTarjeta() {
        return pinTarjeta;
    }

    public int getCodEstacion() {
        return codEstacion;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public int getNum_pasajes() {
        return num_pasajes;
    }
    
    
}
