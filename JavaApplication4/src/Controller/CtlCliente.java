/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Clases.Cantidad_Mascotas_Por_Cliente;
import Clases.Cliente;
import Model.ModelCliente;
import java.util.ArrayList;

/**
 *
 * @author 57301
 */
public class CtlCliente {

    private ModelCliente modelCliente;

    public CtlCliente() {
        this.modelCliente = new ModelCliente();
    }

    public String CrearCliente(Cliente cliente) {
        try {
            if (!this.modelCliente.ExisteCliente(cliente.getIdentificacion_cliente())) {
                // No se encontro el cliente se procede a crear
                if (this.modelCliente.CrearCliente(cliente)) {
                    return "Se creo exitosamente el cliente";
                } else {
                    return "No se pudo crear el cliente";
                }
            } else {
                // se encontro el cliente
                return "El cliente ya se encuentra registrada";
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return "Error al crear cliente verifique con el admnistrador";
        }
    }

    public String ModificarCliente(Cliente cliente) {
        try {
            if (this.modelCliente.ExisteCliente(cliente.getIdentificacion_cliente())) {
                //se encontro el cliente, se procede a modificar
                if (this.modelCliente.ModificarCliente(cliente)) {
                    return "Se modifico exitosamente el cliente";
                } else {
                    return "No se pudo modificar el cliente";
                }
            } else {
                //NO se encontro el cliente
                return "El cliente No se encuentra registrado";
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return "Error al Modificar el cliente, verifique con el admnistrador";
        }
    }

    public String EliminarCliente(String identificacionCliente) {
        try {
            if (this.modelCliente.ExisteCliente(identificacionCliente)) {
                //se encontro el cliente se procede a modificar
                if (this.modelCliente.EliminarCliente(identificacionCliente)) {
                    return "Se elimino el cliente exitosamente ";
                } else {
                    return "No se pudo eliminar el cliente";
                }
            } else {
                //NO se encontro el cliente
                return "El cliente No se encuentra registrado";
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return "Error al eliminar el cliente, verifique con el admnistrador";
        }
    }

    public ArrayList<Cliente> ConsultarCliente() {
        try {
            return this.modelCliente.SeleccionarClientes();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return null;
        }
    }

    public ArrayList<Cantidad_Mascotas_Por_Cliente> ArrayCantidadMascotas() {
        return this.modelCliente.CantidadMascotasCliente();
    }

}
