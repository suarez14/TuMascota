/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Clases.Plan;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 57301
 */
public class ModelPlan {
    
    DbData dbData;

    public ModelPlan(DbData dbData) {
        this.dbData = dbData;
    }
   

    public ModelPlan() {
        this.dbData = new DbData();
    }
    
    public boolean CrearPlan(Plan plan){
        try (Connection conn = DriverManager.getConnection(dbData.getUlr(), dbData.getUser(),dbData.getPassword())){
            String query = "INSERT INTO plan(codigo_plan, nombre_plan, descripcion, precio) VALUES (?,?,?,?)";
            PreparedStatement statementPlan = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statementPlan.setInt(1, plan.getCodigo_plan());
            statementPlan.setString(2, plan.getNombre_plan());
            statementPlan.setString(3, plan.getDescripcion());
            statementPlan.setDouble(4, plan.getPrecio());
            int rowInserted = statementPlan.executeUpdate();
            if (rowInserted > 0){
                return true;
            }else {
                return false;
            }
            
        } catch (Exception e) {
            return false;
        }
      }
    
    public boolean ExistePlan (int codigo_plan){
         try (Connection conn = DriverManager.getConnection(dbData.getUlr(), dbData.getUser(),dbData.getPassword())){
            String query = "select * from plan where codigo_plan = ?";
            PreparedStatement statementPlan = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statementPlan.setInt(1, codigo_plan);
            ResultSet rowSelected = statementPlan.executeQuery();
            while (rowSelected.next()){
                   return true;
            }
            return false;
            
        } catch (Exception e) {
             System.out.println(e.getMessage());
            return false;
        }
    }
    
     public ArrayList<Plan> SeleccionarPlanes (){
         try (Connection conn = DriverManager.getConnection(dbData.getUlr(), dbData.getUser(),dbData.getPassword())){
            ArrayList<Plan> planesList = new ArrayList<>();
            String query = "select * from plan ";
            PreparedStatement statementPlan = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rowSelected = statementPlan.executeQuery();
            while (rowSelected.next()){
                int codigo_plan = rowSelected.getInt("codigo_plan");
                String nombre_plan = rowSelected.getString("nombre_plan");
                String descripcion = rowSelected.getString("descripcion");
                double precio = rowSelected.getDouble("precio");
                 Plan plan = new Plan(codigo_plan, nombre_plan, descripcion, precio);
                planesList.add(plan);
            }
            return planesList;
            
        } catch (Exception e) {
             System.out.println(e.getMessage());
            return null;
        }
    }
    
     public boolean ModificarPlan(Plan plan){
        try (Connection conn = DriverManager.getConnection(dbData.getUlr(), dbData.getUser(),dbData.getPassword())){
            String query = "UPDATE plan SET nombre_plan = ?, descripcion = ?, precio = ? WHERE codigo_plan = ? ";
            PreparedStatement statementPlan = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statementPlan.setString(1, plan.getNombre_plan());
            statementPlan.setString(2, plan.getDescripcion());
            statementPlan.setDouble(3, plan.getPrecio());
            statementPlan.setInt(4, plan.getCodigo_plan());
             int rowUpdated = statementPlan.executeUpdate();
            if (rowUpdated > 0){
                return true;
            }else {
                return false;
            }
            
        } catch (Exception e) {
            return false;
        }
      }
     
     public boolean EliminarPlan(int  codigo_plan){
        try (Connection conn = DriverManager.getConnection(dbData.getUlr(), dbData.getUser(),dbData.getPassword())){
            String query = "Delete from plan where codigo_plan = ? ";
            PreparedStatement statementPlan = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statementPlan.setInt(1, codigo_plan);
             int rowUpdated = statementPlan.executeUpdate();
            if (rowUpdated > 0){
                return true;
            }else {
                return false;
            }
            
        } catch (Exception e) {
            return false;
        }
      } 

    
}
