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
public class Pasajero {
    
    private String id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String fechaNacimiento;
    private String pinTarjeta;

    public Pasajero(String id, String nombre, String direccion, String telefono, String fechaNacimiento, String pinTarjeta) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.pinTarjeta = pinTarjeta;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getPinTarjeta() {
        return pinTarjeta;
    }
    
    
    
}
