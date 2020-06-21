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
public class Medida {
    
    private String medida;
    private int codigoCaso;

    public Medida(String medida, int codigoCaso) {
        this.medida = medida;
        this.codigoCaso = codigoCaso;
    }

    public String getMedida() {
        return medida;
    }

    public int getCodigoCaso() {
        return codigoCaso;
    }
    
    
    
}
