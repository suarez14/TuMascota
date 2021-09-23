/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Clases.Mascota;
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
public class ModelMascota {
    
    
    DbData dbData;
    

    public ModelMascota(DbData dbData) {
        this.dbData = dbData;
    }

    public ModelMascota() {
        this.dbData = new DbData();
    }

    public boolean CrearMascota(Mascota mascota){
        try (Connection conn = DriverManager.getConnection(dbData.getUlr(), dbData.getUser(),dbData.getPassword())){
            String query = "INSERT INTO mascota(codigo_mascota, edad, especie,nombre_mascota, peso, Identificacion_cliente ) VALUES (?,?,?,?,?,?)";
            PreparedStatement statementMascota = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statementMascota.setInt(1, mascota.getCodigo_mascota());
            statementMascota.setInt(2, mascota.getEdad());
            statementMascota.setString(3, mascota.getEspecie());
            statementMascota.setString(4, mascota.getNombre_mascota());
            statementMascota.setDouble(5, mascota.getPeso());
            statementMascota.setString(6, mascota.getIdentificacion_cliente());
            int rowInserted = statementMascota.executeUpdate();
            if (rowInserted > 0){
                return true;
            }else {
                return false;
            }
            
        } catch (Exception e) {
            return false;
        }
      }
    
    public boolean ExisteMascota (int codigo_mascota){
         try (Connection conn = DriverManager.getConnection(dbData.getUlr(), dbData.getUser(),dbData.getPassword())){
            String query = "select * from mascota where codigo_mascota = ?";
            PreparedStatement statementMascota = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statementMascota.setInt(1, codigo_mascota);
            ResultSet rowSelected = statementMascota.executeQuery();
            while (rowSelected.next()){
                   return true;
            }
            return false;
            
        } catch (Exception e) {
             System.out.println(e.getMessage());
            return false;
        }
    }
    
     public ArrayList<Mascota> SeleccionarMascotas (){
         try (Connection conn = DriverManager.getConnection(dbData.getUlr(), dbData.getUser(),dbData.getPassword())){
            ArrayList<Mascota> mascotasList = new ArrayList<>();
            String query = "select * from Mascota ";
            PreparedStatement statementMascota = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rowSelected = statementMascota.executeQuery();
            while (rowSelected.next()){
                int codigo_mascota = rowSelected.getInt("codigo_mascota");
                int edad = rowSelected.getInt("edad");
                String especie = rowSelected.getString("especie");
                String nombre_mascota = rowSelected.getString("nombre_mascota");
                double peso = rowSelected.getDouble("peso");
                String Identificacion_cliente = rowSelected.getString("Identificacion_cliente");
                 Mascota mascota = new Mascota(codigo_mascota, nombre_mascota, edad, peso, especie, Identificacion_cliente);
                mascotasList.add(mascota);
            }
            return mascotasList;
            
        } catch (Exception e) {
             System.out.println(e.getMessage());
            return null;
        }
    }
    
     public boolean ModificarMascota(Mascota mascota){
        try (Connection conn = DriverManager.getConnection(dbData.getUlr(), dbData.getUser(),dbData.getPassword())){
            String query = "UPDATE mascota SET edad = ?, especie = ?, nombre_mascota = ?, peso = ?,Identificacion_cliente = ? WHERE codigo_mascota = ? ";
            PreparedStatement statementMascota = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statementMascota.setInt(1, mascota.getEdad());
            statementMascota.setString(2, mascota.getEspecie());
            statementMascota.setString(3, mascota.getNombre_mascota());
            statementMascota.setDouble(4, mascota.getPeso());
            statementMascota.setString(5, mascota.getIdentificacion_cliente());
            statementMascota.setInt(6, mascota.getCodigo_mascota());
             int rowUpdated = statementMascota.executeUpdate();
            if (rowUpdated > 0){
                return true;
            }else {
                return false;
            }
            
        } catch (Exception e) {
            return false;
        }
      }
     
     public boolean EliminarMascota(int  codigo_mascota){
        try (Connection conn = DriverManager.getConnection(dbData.getUlr(), dbData.getUser(),dbData.getPassword())){
            String query = "Delete from mascota where codigo_mascota = ? ";
            PreparedStatement statementMascota = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statementMascota.setInt(1, codigo_mascota);
             int rowUpdated = statementMascota.executeUpdate();
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
