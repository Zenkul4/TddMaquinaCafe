import static org.junit.Assert.*;
import org.junit.Test;

public class ComponentesTest {
    @Test public void compruebaYEntregaVasos() {
        Vaso vasos = new Vaso(5, 10);
        assertTrue(vasos.hasVasos(1));
        assertFalse(vasos.hasVasos(6));
        vasos.giveVasos(1);
        assertEquals(4, vasos.getCantidadVasos());
    }
    @Test public void compruebaYEntregaCafe() {
        Cafetera cafetera = new Cafetera(10);
        assertTrue(cafetera.hasCafe(5));
        assertFalse(cafetera.hasCafe(11));
        cafetera.giveCafe(7);
        assertEquals(3, cafetera.getCantidadCafe());
    }
    @Test public void compruebaYEntregaAzucar() {
        Azucarero azucarero = new Azucarero(10);
        assertTrue(azucarero.hasAzucar(5));
        assertTrue(azucarero.hasAzucar(10));
        assertFalse(azucarero.hasAzucar(15));
        azucarero.giveAzucar(5);
        azucarero.giveAzucar(2);
        assertEquals(3, azucarero.getCantidadAzucar());
    }
    @Test(expected = IllegalArgumentException.class) public void noPermiteRetiroExcesivo() {
        new Cafetera(3).giveCafe(4);
    }
}
