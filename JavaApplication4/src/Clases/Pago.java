/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;

/**
 *
 * @author 57301
 */
public class Pago {
    
    private int codigo_pago;
    private double abono;
    private double saldo;
    private int ctd_cuotas;
    private String fecha_pago;
    private String plan_afiliacion;
    private int codigo_mascota;
    private int codigo_plan;
    
    
    public Pago(int codigo_pago, double abono, double saldo, int ctd_cuotas, String fecha_pago, String plan_afiliacion, int codigo_mascota, int codigo_plan) {
        this.codigo_pago = codigo_pago;
        this.abono = abono;
        this.saldo = saldo;
        this.ctd_cuotas = ctd_cuotas;
        this.fecha_pago = fecha_pago;
        this.plan_afiliacion = plan_afiliacion;
        this.codigo_mascota = codigo_mascota;
        this.codigo_plan = codigo_plan;
    }
    
    
    public int getCodigo_mascota() {
        return codigo_mascota;
    }

    public void setCodigo_mascota(int codigo_mascota) {
        this.codigo_mascota = codigo_mascota;
    }

    public int getCodigo_plan() {
        return codigo_plan;
    }

    public void setCodigo_plan(int codigo_plan) {
        this.codigo_plan = codigo_plan;
    }
    
    
    public int getCodigo_pago() {
        return codigo_pago;
    }

    public void setCodigo_pago(int codigo_pago) {
        this.codigo_pago = codigo_pago;
    }

    public double getAbono() {
        return abono;
    }

    public void setAbono(double abono) {
        this.abono = abono;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getCtd_cuotas() {
        return ctd_cuotas;
    }

    public void setCtd_cuotas(int ctd_cuotas) {
        this.ctd_cuotas = ctd_cuotas;
    }

    public String getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(String fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public String getPlan_afiliacion() {
        return plan_afiliacion;
    }

    public void setPlan_afiliacion(String plan_afiliacion) {
        this.plan_afiliacion = plan_afiliacion;
    }

    


    
    
    
    
    
}
