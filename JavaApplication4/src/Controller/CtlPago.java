/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Clases.Pago;
import Model.ModelPago;
import java.util.ArrayList;

/**
 *
 * @author 57301
 */
public class CtlPago {

    
    
    private final ModelPago modelPago;
    
    
    public CtlPago() {
        this.modelPago = new ModelPago();
    }
    
    public String CrearPago(Pago pago){
        try {
           if (!this.modelPago.ExistePago(pago.getCodigo_pago())){
               // No se encontro el cliente se procede a crear
               if (this.modelPago.CrearPago(pago)){
                    return "Se creo exitosamente el pago";
               }
               else{
                   return "No se pudo crear el pago";
               }
            }
           else {
               // se encontro el pago
               return "El pago ya se encuentra registrada";
           }
         } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return "Error al crear el pago, verifique con el admnistrador";
        }
    }
    
     public String ModificarPago(Pago pago){
        try {
           if (this.modelPago.ExistePago(pago.getCodigo_pago())){
               //se encontro el pago, se procede a modificar
               if (this.modelPago.ModificarPago(pago)){
                    return "Se modifico exitosamente el pago";
               }
               else{
                   return "No se pudo modificar el pago";
               }
            }
           else {
               //NO se encontro el pago
               return "El pago no se encuentra registrado";
           }
         } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return "Error al modificar el pago, verifique con el admnistrador";
        }
    }
     
      public String EliminarPago(int codigo_pago){
        try {
           if (this.modelPago.ExistePago(codigo_pago)){
               //se encontro el pago se procede a modificar
               if (this.modelPago.EliminarPago(codigo_pago)){
                    return "Se elimino el pago exitosamente ";
               }
               else{
                   return "No se pudo eliminar el pago";
               }
            }
           else {
               //No se encontro el pago
               return "El pago no se encuentra registrado";
           }
         } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return "Error al eliminar el pago, verifique con el admnistrador";
        }
    }
    
     public ArrayList<Pago> ConsultarPagos(){
        try {
           return this.modelPago.SeleccionarPagos();
         } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return null;
        }
    }
  
}
