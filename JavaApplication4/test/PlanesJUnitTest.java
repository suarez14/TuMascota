/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Clases.Cliente;
import Clases.Plan;
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
public class PlanesJUnitTest {

    public PlanesJUnitTest() {
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
    public void PruebaGetSetCodigo_plan() {

        Plan plan = new Plan(852741, "Diamante", "Full", 10000);

        plan.setCodigo_plan(123456);

        assertEquals(plan.getCodigo_plan(),123456);
    }
    
        @Test
    public void PruebaGetSetNombre_plan() {

        Plan plan = new Plan(852741, "Diamante", "Full", 10000);

        plan.setNombre_plan("Bienestar");

        assertEquals(plan.getNombre_plan(),"Bienestar");
    }
    
        @Test
    public void PruebaGetSetDescripcion() {

        Plan plan = new Plan(852741, "Diamante", "Full", 10000);

        plan.setDescripcion("Basico");

        assertEquals(plan.getDescripcion(),"Basico");
    }
    
        @Test
    public void PruebaGetSetPrecio() {

        Plan plan = new Plan(852741, "Diamante", "Full", 10000);

        plan.setPrecio(50000);

        assertEquals(plan.getPrecio(),50000,0);
    }

}
