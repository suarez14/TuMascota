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
public class Plan {
    public int codigo_plan;
    public String nombre_plan;
    public String descripcion;
    public double precio;

    public Plan(int codigo_plan, String nombre_plan, String descripcion, double precio) {
        this.codigo_plan = codigo_plan;
        this.nombre_plan = nombre_plan;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getCodigo_plan() {
        return codigo_plan;
    }

    public void setCodigo_plan(int codigo_plan) {
        this.codigo_plan = codigo_plan;
    }

    public String getNombre_plan() {
        return nombre_plan;
    }

    public void setNombre_plan(String nombre_plan) {
        this.nombre_plan = nombre_plan;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }    
}
