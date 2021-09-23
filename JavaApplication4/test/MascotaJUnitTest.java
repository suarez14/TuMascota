/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class MascotaJUnitTest {

    public MascotaJUnitTest() {
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
    public void PruebaGetSetCodigo_mascota() {

        Mascota mascota = new Mascota(123, "Peter", 2, 3.1, "canino", "123456");

        mascota.setCodigo_mascota(987);

        assertEquals(mascota.getCodigo_mascota(), 987);
    }

    @Test
    public void PruebaGetSetnombre_mascota() {

        Mascota mascota = new Mascota(123, "Peter", 2, 3.1, "canino", "123456");

        mascota.setNombre_mascota("Reus");

        assertEquals(mascota.getNombre_mascota(), "Reus");
    }
    
    
        @Test
    public void PruebaGetSEdad() {

        Mascota mascota = new Mascota(123, "Peter", 2, 3.1, "canino", "123456");

        mascota.setEdad(10);

        assertEquals(mascota.getEdad(),10);
    }
    
        @Test
    public void PruebaGetSetPeso() {

        Mascota mascota = new Mascota(123, "Peter", 2, 3.1, "canino", "123456");

        mascota.setPeso(5.1);

        assertEquals(mascota.getPeso(),5.1,0);
    }
    
        @Test
    public void PruebaGetSetEspecie() {

        Mascota mascota = new Mascota(123, "Peter", 2, 3.1, "canino", "123456");

        mascota.setEspecie("canino");

        assertEquals(mascota.getEspecie(),"canino");
    }
    
        @Test
    public void PruebaGetSetIdentificacionCliente() {

        Mascota mascota = new Mascota(123, "Peter", 2, 3.1, "canino", "123456");

        mascota.setIdentificacion_cliente("987456");

        assertEquals(mascota.getIdentificacion_cliente(), "987456");
    }

}
