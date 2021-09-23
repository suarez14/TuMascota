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
public class Cantidad_Mascotas_Por_Cliente {
    
    private String nombreCliente;
    private int cantidadMacotas;

    public Cantidad_Mascotas_Por_Cliente(String nombreCliente, int cantidadMacotas) {
        this.nombreCliente = nombreCliente;
        this.cantidadMacotas = cantidadMacotas;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombre(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getCantidadMacotas() {
        return this.cantidadMacotas;
    }

    public void setCantidadMacotas(int cantidadMascotas) {
        this.cantidadMacotas = cantidadMascotas;
    }
    
}
