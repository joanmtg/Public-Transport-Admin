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
public class RutaBus {
    
    private String placa;
    private String codRuta;
    private String fechaAsig;

    public RutaBus(String placa, String codRuta, String fechaAsig) {
        this.placa = placa;
        this.codRuta = codRuta;
        this.fechaAsig = fechaAsig;
    }

    public String getPlaca() {
        return placa;
    }

    public String getCodRuta() {
        return codRuta;
    }

    public String getFechaAsig() {
        return fechaAsig;
    }
    
    
    
}
