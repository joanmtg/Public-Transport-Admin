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
public class Empleado {
    
    private String id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String fechaNacimiento;
    private double salario;
    private String cargo;
    private String estado;
    private String password;
    
    private String placaBus;
        

    public Empleado(String id, String nombre, String direccion, String telefono, String fechaNacimiento, double salario, String cargo, String estado, String password) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.salario = salario;
        this.cargo = cargo;
        this.estado = estado;
        this.password = password;
        
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

    public double getSalario() {
        return salario;
    }

    public String getCargo() {
        return cargo;
    }

    public String getEstado() {
        return estado;
    }
       
    public String getPassword() {
        return password;
    }

    public String getPlacaBus() {
        return placaBus;
    }

    public void setPlacaBus(String placaBus) {
        this.placaBus = placaBus;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

        
    
    
}
