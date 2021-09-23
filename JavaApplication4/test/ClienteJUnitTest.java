/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Clases.Cliente;
import Clases.Mascota;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 57301
 */
public class ClienteJUnitTest {

    public ClienteJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void PruebaGetSetIdentificacionCliente() {

        Cliente cliente = new Cliente("123456", "Sergio", "Herrera Gomez", "Calle 140 70", "301854");
        
        cliente.setIdentificacion_cliente("987456");

        assertEquals(cliente.getIdentificacion_cliente(), "987456");
    }
    
    
        @Test
    public void PruebaGetSetNombre() {

        Cliente cliente = new Cliente("123456", "Sergio", "Herrera Gomez", "Calle 140 70", "301854");
        
        cliente.setNombre("Esteban");

        assertEquals(cliente.getNombre(), "Esteban");
    }
    
        @Test
    public void PruebaGetSetApellidos() {
        Cliente cliente = new Cliente("123456", "Sergio", "Herrera Gomez", "Calle 140 70", "301854");
        
        cliente.setApellidos("Sanchez Cristo");

        assertEquals(cliente.getApellidos(), "Sanchez Cristo");
    }
    
        @Test
    public void PruebaGetSetDireccion() {

        Cliente cliente = new Cliente("123456", "Sergio", "Herrera Gomez", "Calle 140 70", "301854");
        
        cliente.setDireccion("Carrera 140");

        assertEquals(cliente.getDireccion(), "Carrera 140");
    }
    
        @Test
    public void PruebaGetSetTelefono() {

        Cliente cliente = new Cliente("123456", "Sergio", "Herrera Gomez", "Calle 140 70", "301854");
        
        cliente.setTelefono("852741");

        assertEquals(cliente.getTelefono(), "852741");
    }

}
