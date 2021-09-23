/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Clases.Pago;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 57301
 */
public class ModelPago {
    
    DbData dbData;

    public ModelPago(DbData dbData) {
        this.dbData = dbData;
    }
   

    public ModelPago() {
        this.dbData = new DbData();
    }
    
    public boolean CrearPago(Pago pago){
        try (Connection conn = DriverManager.getConnection(dbData.getUlr(), dbData.getUser(),dbData.getPassword())){
            String query = "INSERT INTO pago(codigo_pago, abono, saldo, ctd_cuotas, fecha_pago, plan_afiliacion, codigo_mascota, codigo_plan) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement statementPago = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statementPago.setInt(1, pago.getCodigo_pago());
            statementPago.setDouble(2, pago.getAbono());
            statementPago.setDouble(3, pago.getSaldo());
            statementPago.setInt(4, pago.getCtd_cuotas());
            statementPago.setString(5, pago.getFecha_pago());
            statementPago.setString(6, pago.getPlan_afiliacion());
            statementPago.setInt(7, pago.getCodigo_mascota());
            statementPago.setInt(8, pago.getCodigo_plan());
            System.out.println(statementPago);
            int rowInserted = statementPago.executeUpdate();
            if (rowInserted > 0){
                return true;
            }else {
                return false;
            }
            
        } catch (Exception e) {
            return false;
        }
      }
    
    public boolean ExistePago (int codigo_pago){
         try (Connection conn = DriverManager.getConnection(dbData.getUlr(), dbData.getUser(),dbData.getPassword())){
            String query = "select * from pago where codigo_pago = ?";
            PreparedStatement statementPago = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statementPago.setInt(1, codigo_pago);
            ResultSet rowSelected = statementPago.executeQuery();
            while (rowSelected.next()){
                   return true;
            }
            return false;
            
        } catch (Exception e) {
             System.out.println(e.getMessage());
            return false;
        }
    }
    
     public ArrayList<Pago> SeleccionarPagos (){
         try (Connection conn = DriverManager.getConnection(dbData.getUlr(), dbData.getUser(),dbData.getPassword())){
            ArrayList<Pago> pagosList = new ArrayList<>();
            String query = "select * from pago ";
            PreparedStatement statementPago = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rowSelected = statementPago.executeQuery();
            while (rowSelected.next()){
                int codigo_pago = rowSelected.getInt("codigo_pago");
                double abono = rowSelected.getDouble("abono");
                double saldo = rowSelected.getDouble("saldo");
                int ctd_cuotas = rowSelected.getInt("ctd_cuotas");
                String fecha_pago = rowSelected.getString("fecha_pago");
                String plan_afiliacion = rowSelected.getString("plan_afiliacion");
                int codigo_mascota = rowSelected.getInt("codigo_mascota");
                int codigo_plan = rowSelected.getInt("codigo_plan");
                 Pago pago = new Pago(codigo_pago, abono, saldo, ctd_cuotas, fecha_pago, plan_afiliacion, codigo_mascota, codigo_plan);
                pagosList.add(pago);
            }
            return pagosList;
            
        } catch (Exception e) {
             System.out.println(e.getMessage());
            return null;
        }
    }
    
     public boolean ModificarPago(Pago pago){
        try (Connection conn = DriverManager.getConnection(dbData.getUlr(), dbData.getUser(),dbData.getPassword())){
            String query = "UPDATE pago SET abono = ?, saldo = ?, ctd_cuotas = ?, fecha_pago = ?, plan_afiliacion = ?, codigo_mascota = ?, codigo_plan = ? WHERE codigo_pago = ? ";
            PreparedStatement statementPago = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statementPago.setDouble(1, pago.getAbono());
            statementPago.setDouble(2, pago.getSaldo());
            statementPago.setInt(3, pago.getCtd_cuotas());
            statementPago.setString(4, pago.getFecha_pago());
            statementPago.setString(5, pago.getPlan_afiliacion());
            statementPago.setInt(6, pago.getCodigo_mascota());
            statementPago.setInt(7, pago.getCodigo_plan());
            statementPago.setInt(8, pago.getCodigo_pago());
             int rowUpdated = statementPago.executeUpdate();
            if (rowUpdated > 0){
                return true;
            }else {
                return false;
            }
            
        } catch (Exception e) {
            return false;
        }
      }
     
     public boolean EliminarPago(int  codigo_pago){
        try (Connection conn = DriverManager.getConnection(dbData.getUlr(), dbData.getUser(),dbData.getPassword())){
            String query = "Delete from pago where codigo_pago = ? ";
            PreparedStatement statementPago = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statementPago.setInt(1, codigo_pago);
             int rowUpdated = statementPago.executeUpdate();
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
