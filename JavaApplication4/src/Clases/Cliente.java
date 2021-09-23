/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author 57301
 */
public class Cliente {
    private String identificacion_cliente;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String telefono;

    public Cliente(String identificacion_cliente, String nombre, String apellidos, String direccion, String telefono) {
        this.identificacion_cliente = identificacion_cliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getIdentificacion_cliente() {
        return identificacion_cliente;
    }

    public void setIdentificacion_cliente(String identificacion_cliente) {
        this.identificacion_cliente = identificacion_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    
    
    
      
    
    
}
