/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Clases.Cantidad_Mascotas_Por_Cliente;
import Clases.Cliente;
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
public class ModelCliente {
    DbData dbData;
    
    public ModelCliente (DbData dbData){
        this.dbData = dbData;
    }
    
    public ModelCliente () {
        this.dbData = new DbData();
    }
    
    public boolean CrearCliente (Cliente cliente){
        
        try (Connection conn = DriverManager.getConnection(dbData.getUlr(), dbData.getUser(),dbData.getPassword())){
            String query = "INSERT INTO clientes(Identificacion_cliente, nombre, apellidos, direccion, telefono) VALUES (?,?,?,?,?)";
            PreparedStatement statementEmpresa = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statementEmpresa.setString(1, cliente.getIdentificacion_cliente());
            statementEmpresa.setString(2, cliente.getNombre());
            statementEmpresa.setString(3, cliente.getApellidos());
            statementEmpresa.setString(4, cliente.getDireccion());
            statementEmpresa.setString(5, cliente.getTelefono());
            int rowInserted = statementEmpresa.executeUpdate();
            if (rowInserted > 0){
                return true;
            }else {
                return false;
            }
            
        } catch (Exception e) {
            return false;
        }
        
    }
    
    
    public boolean ExisteCliente (String identificacion_cliente) {
        
                 try (Connection conn = DriverManager.getConnection(dbData.getUlr(), dbData.getUser(),dbData.getPassword())){
            String query = "select * from clientes where Identificacion_cliente = ?";
            PreparedStatement statementEmpresa = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statementEmpresa.setString(1, identificacion_cliente);
            ResultSet rowSelected = statementEmpresa.executeQuery();
            while (rowSelected.next()){
                   return true;
            }
            return false;
            
        } catch (Exception e) {
             System.out.println(e.getMessage());
            return false;
        }
        
    }
    
    public ArrayList<Cliente> SeleccionarClientes () {
        
        try (Connection conn = DriverManager.getConnection(dbData.getUlr(), dbData.getUser(),dbData.getPassword())){
            ArrayList<Cliente> clientesList = new ArrayList<>();
            String query = "select * from clientes ";
            PreparedStatement statementEmpresa = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rowSelected = statementEmpresa.executeQuery();
            while (rowSelected.next()){
                String identificacion_cliente = rowSelected.getString("Identificacion_cliente");
                String nombre = rowSelected.getString("nombre");
                String apellidos = rowSelected.getString("apellidos");
                String direccion = rowSelected.getString("direccion");
                String telefono = rowSelected.getString("telefono");
                
                 Cliente cliente = new Cliente(identificacion_cliente, nombre, apellidos, direccion, telefono);
                clientesList.add(cliente);
            }
            return clientesList;
            
        } catch (Exception e) {
             System.out.println(e.getMessage());
            return null;
        }
        
    }
    
    public boolean ModificarCliente (Cliente cliente) {
        try (Connection conn = DriverManager.getConnection(dbData.getUlr(), dbData.getUser(),dbData.getPassword())){
            String query = "UPDATE clientes SET nombre = ?, apellidos = ?, direccion = ?, telefono = ? WHERE Identificacion_cliente = ? ";
            PreparedStatement statementEmpresa = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statementEmpresa.setString(1, cliente.getNombre());
            statementEmpresa.setString(2, cliente.getApellidos());
            statementEmpresa.setString(3, cliente.getDireccion());
            statementEmpresa.setString(4, cliente.getTelefono());
            statementEmpresa.setString(5, cliente.getIdentificacion_cliente());
             int rowUpdated = statementEmpresa.executeUpdate();
            if (rowUpdated > 0){
                return true;
            }else {
                return false;
            }
            
        } catch (Exception e) {
            return false;
        }        
    }
    public boolean EliminarCliente (String identificacion_cliente) {
        try (Connection conn = DriverManager.getConnection(dbData.getUlr(), dbData.getUser(),dbData.getPassword())){
            String query = "Delete from clientes where Identificacion_cliente = ? ";
            PreparedStatement statementCliente = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statementCliente.setString(1, identificacion_cliente);
             int rowUpdated = statementCliente.executeUpdate();
            if (rowUpdated > 0){
                return true;
            }else {
                return false;
            }
            
        } catch (Exception e) {
            return false;
        }
    }
    
    
         public ArrayList<Cantidad_Mascotas_Por_Cliente> CantidadMascotasCliente(){
          try (Connection conn = DriverManager.getConnection(dbData.getUlr(), dbData.getUser(),dbData.getPassword())){
            ArrayList<Cantidad_Mascotas_Por_Cliente> cMascotasList = new ArrayList<>();
            String query = "select clientes.nombre, count(mascota.especie) as cantidad from mascota inner join clientes on mascota.Identificacion_cliente = clientes.Identificacion_cliente GROUP BY clientes.nombre";
            PreparedStatement statementReporte = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rowSelected = statementReporte.executeQuery();
            while (rowSelected.next()){
                String nombre = rowSelected.getString("nombre");
                int cantidad = rowSelected.getInt("cantidad");
                 Cantidad_Mascotas_Por_Cliente cMascotas = new Cantidad_Mascotas_Por_Cliente(nombre, cantidad);
                cMascotasList.add(cMascotas);
            }
            return cMascotasList;
            
        } catch (Exception e) {
             System.out.println(e.getMessage());
             return null;
        }
     }
    
    
    
}
