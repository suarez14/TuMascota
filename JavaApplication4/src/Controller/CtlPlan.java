/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Clases.Plan;
import Model.ModelPlan;
import java.util.ArrayList;

/**
 *
 * @author 57301
 */
public class CtlPlan {
  
    
    private ModelPlan modelPlan;
    
    
    public CtlPlan() {
        this.modelPlan = new ModelPlan();
    }
    
    public String CrearPlan(Plan plan){
        try {
           if (!this.modelPlan.ExistePlan(plan.getCodigo_plan())){
               // No se encontro el plan se procede a crear
               if (this.modelPlan.CrearPlan(plan)){
                    return "Se creo exitosamente el plan";
               }
               else{
                   return "No se pudo crear el plan";
               }
            }
           else {
               // se encontro el plan
               return "El plan ya se encuentra registrado";
           }
         } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return "Error al crear el plan, verifique con el admnistrador";
        }
    }
    
     public String ModificarPlan(Plan plan){
        try {
           if (this.modelPlan.ExistePlan(plan.getCodigo_plan())){
               //se encontro el plan, se procede a modificar
               if (this.modelPlan.ModificarPlan(plan)){
                    return "Se modifico exitosamente el plan";
               }
               else{
                   return "No se pudo modificar el plan";
               }
            }
           else {
               //NO se encontro el plan
               return "El plan no se encuentra registrado";
           }
         } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return "Error al modificar el plan, verifique con el admnistrador";
        }
    }
     
      public String EliminarPlan(int codigo_plan){
        try {
           if (this.modelPlan.ExistePlan(codigo_plan)){
               //se encontro el plan se procede a modificar
               if (this.modelPlan.EliminarPlan(codigo_plan)){
                    return "Se elimino el plan exitosamente ";
               }
               else{
                   return "No se pudo eliminar el plan";
               }
            }
           else {
               //NO se encontro el cliente
               return "El plan no se encuentra registrado";
           }
         } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return "Error al eliminar el plan, verifique con el admnistrador";
        }
    }
    
     public ArrayList<Plan> ConsultarPlanes(){
        try {
           return this.modelPlan.SeleccionarPlanes();
         } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return null;
        }
    }
    

}
