public class Vaso {
    private int cantidadVasos;
    private int contenido;

    public Vaso(int cantidadVasos, int contenido) {
        setCantidadVasos(cantidadVasos);
        setContenido(contenido);
    }
    public int getCantidadVasos() { return cantidadVasos; }
    public int getContenido() { return contenido; }
    public void setCantidadVasos(int cantidad) {
        if (cantidad < 0) throw new IllegalArgumentException("La cantidad de vasos no puede ser negativa");
        cantidadVasos = cantidad;
    }
    public void setContenido(int contenido) {
        if (contenido <= 0) throw new IllegalArgumentException("El contenido debe ser positivo");
        this.contenido = contenido;
    }
    public boolean hasVasos(int cantidad) { return cantidad >= 0 && cantidadVasos >= cantidad; }
    public void giveVasos(int cantidad) {
        if (!hasVasos(cantidad)) throw new IllegalArgumentException("Cantidad de vasos no disponible");
        cantidadVasos -= cantidad;
    }
}
