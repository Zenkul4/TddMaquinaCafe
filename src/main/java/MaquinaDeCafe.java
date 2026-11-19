import java.util.Locale;
import java.util.Objects;

public class MaquinaDeCafe {
    private Cafetera cafetera;
    Vaso vasosPequeno, vasosMediano, vasosGrande;
    private Azucarero azucarero;

    public Cafetera getCafetera() { return cafetera; }
    public void setCafetera(Cafetera valor) { cafetera = Objects.requireNonNull(valor); }
    public Vaso getVasosPequeno() { return vasosPequeno; }
    public void setVasosPequeno(Vaso valor) { vasosPequeno = Objects.requireNonNull(valor); }
    public Vaso getVasosMediano() { return vasosMediano; }
    public void setVasosMediano(Vaso valor) { vasosMediano = Objects.requireNonNull(valor); }
    public Vaso getVasosGrande() { return vasosGrande; }
    public void setVasosGrande(Vaso valor) { vasosGrande = Objects.requireNonNull(valor); }
    public Azucarero getAzucarero() { return azucarero; }
    public void setAzucarero(Azucarero valor) { azucarero = Objects.requireNonNull(valor); }

    public Vaso getTipoDeVaso(String tipo) {
        if (tipo == null) throw new IllegalArgumentException("Seleccione un tamaño de vaso");
        switch (tipo.trim().toLowerCase(Locale.ROOT)) {
            case "pequeno": case "pequeño": return vasosPequeno;
            case "mediano": return vasosMediano;
            case "grande": return vasosGrande;
            default: throw new IllegalArgumentException("Tamaño de vaso desconocido");
        }
    }

    // La cantidad de azúcar corresponde al total de la solicitud, como en la guía.
    public String getVasoDeCafe(Vaso vaso, int cantidadVasos, int cantidadAzucar) {
        Objects.requireNonNull(vaso, "El vaso no puede ser nulo");
        Objects.requireNonNull(cafetera, "Configure la cafetera");
        Objects.requireNonNull(azucarero, "Configure el azucarero");
        if (cantidadVasos <= 0 || cantidadAzucar < 0)
            throw new IllegalArgumentException("Indique vasos positivos y azúcar no negativa");
        if (!vaso.hasVasos(cantidadVasos)) return "No hay Vasos";
        long cafeNecesario = (long) vaso.getContenido() * cantidadVasos;
        if (cafeNecesario > Integer.MAX_VALUE || !cafetera.hasCafe((int) cafeNecesario)) return "No hay Cafe";
        if (!azucarero.hasAzucar(cantidadAzucar)) return "No hay Azucar";
        vaso.giveVasos(cantidadVasos);
        cafetera.giveCafe((int) cafeNecesario);
        azucarero.giveAzucar(cantidadAzucar);
        return "Felicitaciones";
    }
}
