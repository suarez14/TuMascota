/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Clases.Mascota;
import Model.ModelMascota;
import java.util.ArrayList;

/**
 *
 * @author 57301
 */
public class CtlMascota {
 
    private ModelMascota modelMascota;
    
    
    public CtlMascota() {
        this.modelMascota = new ModelMascota();
    }
    
    public String CrearMascota(Mascota mascota){
        try {
           if (!this.modelMascota.ExisteMascota(mascota.getCodigo_mascota())){
               // No se encontro la mascota se procede a crear
               if (this.modelMascota.CrearMascota(mascota)){
                    return "Se creo exitosamente la mascota";
               }
               else{
                   return "No se pudo crear la mascota";
               }
            }
           else {
               // se encontro el cliente
               return "La mascota ya se encuentra registrada";
           }
         } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return "Error al crear la mascota verifique con el admnistrador";
        }
    }
    
     public String ModificarMascota(Mascota mascota){
        try {
           if (this.modelMascota.ExisteMascota(mascota.getCodigo_mascota())){
               //se encontro la mascota, se procede a modificar
               if (this.modelMascota.ModificarMascota(mascota)){
                    return "Se modifico exitosamente la mascota";
               }
               else{
                   return "No se pudo modificar la mascota";
               }
            }
           else {
               //NO se encontro el cliente
               return "La mascota No se encuentra registrada";
           }
         } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return "Error al modificar la mascota, verifique con el admnistrador";
        }
    }
     
      public String EliminarMascota(int codigo_mascota){
        try {
           if (this.modelMascota.ExisteMascota(codigo_mascota)){
               //se encontro la mascota se procede a modificar
               if (this.modelMascota.EliminarMascota(codigo_mascota)){
                    return "Se elimino la mascota exitosamente ";
               }
               else{
                   return "No se pudo eliminar la mascota";
               }
            }
           else {
               //NO se encontro el cliente
               return "La mascota no se encuentra registrada";
           }
         } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return "Error al eliminar la mascota, verifique con el admnistrador";
        }
    }
    
     public ArrayList<Mascota> ConsultarMascota(){
        try {
           return this.modelMascota.SeleccionarMascotas();
         } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return null;
        }
    }
    

    
}
