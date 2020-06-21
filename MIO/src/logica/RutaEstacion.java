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
public class RutaEstacion {
    
    private int codEstacion;
    private String codRuta;

    public RutaEstacion(int codEstacion, String codRuta) {
        this.codEstacion = codEstacion;
        this.codRuta = codRuta;
    }

    public int getCodEstacion() {
        return codEstacion;
    }

    public String getCodRuta() {
        return codRuta;
    }
    
        
    
}
