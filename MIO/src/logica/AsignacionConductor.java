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
public class AsignacionConductor {
    
    private String idConductor;
    private String placa;
    private String turno;
    
    public AsignacionConductor(String idConductor, String placa, String turno) {
        this.idConductor = idConductor;
        this.placa = placa;
        this.turno = turno;
    }

    public String getIdConductor() {
        return idConductor;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTurno() {
        return turno;
    }      
    
}
