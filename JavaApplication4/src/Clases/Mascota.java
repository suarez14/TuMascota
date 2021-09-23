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
public class Mascota {
    private int codigo_mascota;
    private String nombre_mascota;
    private int edad;
    private double peso;
    private String especie;
    private String Identificacion_cliente;

    public Mascota(int codigo_mascota, String nombre_mascota, int edad, double peso, String especie, String Identificacion_cliente) {
        this.codigo_mascota = codigo_mascota;
        this.nombre_mascota = nombre_mascota;
        this.edad = edad;
        this.peso = peso;
        this.especie = especie;
        this.Identificacion_cliente = Identificacion_cliente;
    }

    public String getIdentificacion_cliente() {
        return Identificacion_cliente;
    }

    public void setIdentificacion_cliente(String Identificacion_cliente) {
        this.Identificacion_cliente = Identificacion_cliente;
    }

    public int getCodigo_mascota() {
        return codigo_mascota;
    }

    public void setCodigo_mascota(int codigo_mascota) {
        this.codigo_mascota = codigo_mascota;
    }

    public String getNombre_mascota() {
        return nombre_mascota;
    }

    public void setNombre_mascota(String nombre_mascota) {
        this.nombre_mascota = nombre_mascota;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    
    
    
    
}
