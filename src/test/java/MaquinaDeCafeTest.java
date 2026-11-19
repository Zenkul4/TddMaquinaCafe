import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaquinaDeCafeTest {
    private MaquinaDeCafe maquina;
    private Vaso pequeno, mediano, grande;

    @Before public void preparar() {
        maquina = new MaquinaDeCafe();
        maquina.setCafetera(new Cafetera(50));
        pequeno = new Vaso(5, 10);
        mediano = new Vaso(5, 20);
        grande = new Vaso(5, 30);
        maquina.setVasosPequeno(pequeno);
        maquina.setVasosMediano(mediano);
        maquina.setVasosGrande(grande);
        maquina.setAzucarero(new Azucarero(20));
    }
    @Test public void seleccionaLosTresTiposDeVaso() {
        assertSame(pequeno, maquina.getTipoDeVaso("pequeno"));
        assertSame(mediano, maquina.getTipoDeVaso("mediano"));
        assertSame(grande, maquina.getTipoDeVaso("grande"));
    }
    @Test public void avisaSiNoHayVasos() {
        assertEquals("No hay Vasos", maquina.getVasoDeCafe(pequeno, 10, 2));
    }
    @Test public void avisaSiNoHayCafe() {
        maquina.setCafetera(new Cafetera(5));
        assertEquals("No hay Cafe", maquina.getVasoDeCafe(pequeno, 1, 2));
    }
    @Test public void avisaSiNoHayAzucar() {
        maquina.setAzucarero(new Azucarero(2));
        assertEquals("No hay Azucar", maquina.getVasoDeCafe(pequeno, 1, 3));
    }
    @Test public void entregaYDescuentaRecursos() {
        assertEquals("Felicitaciones", maquina.getVasoDeCafe(pequeno, 1, 3));
        assertEquals(40, maquina.getCafetera().getCantidadCafe());
        assertEquals(4, maquina.getVasosPequeno().getCantidadVasos());
        assertEquals(17, maquina.getAzucarero().getCantidadAzucar());
    }
    @Test public void noConsumeRecursosSiFaltaAzucar() {
        maquina.setAzucarero(new Azucarero(2));
        maquina.getVasoDeCafe(pequeno, 1, 3);
        assertEquals(50, maquina.getCafetera().getCantidadCafe());
        assertEquals(5, pequeno.getCantidadVasos());
        assertEquals(2, maquina.getAzucarero().getCantidadAzucar());
    }
    @Test public void multiplicaCafePorCantidadDeVasos() {
        assertEquals("Felicitaciones", maquina.getVasoDeCafe(pequeno, 2, 3));
        assertEquals(30, maquina.getCafetera().getCantidadCafe());
        assertEquals(3, pequeno.getCantidadVasos());
        assertEquals(17, maquina.getAzucarero().getCantidadAzucar());
    }
    @Test public void admiteCafeSinAzucar() {
        assertEquals("Felicitaciones", maquina.getVasoDeCafe(pequeno, 1, 0));
        assertEquals(20, maquina.getAzucarero().getCantidadAzucar());
    }
    @Test(expected = IllegalArgumentException.class) public void rechazaVasosNegativos() {
        maquina.getVasoDeCafe(pequeno, -1, 0);
    }
    @Test(expected = IllegalArgumentException.class) public void rechazaAzucarNegativa() {
        maquina.getVasoDeCafe(pequeno, 1, -1);
    }
    @Test(expected = IllegalArgumentException.class) public void rechazaTipoDesconocido() {
        maquina.getTipoDeVaso("extra");
    }
}
