public class Cafetera {
    private int cantidadCafe;
    public Cafetera(int cantidadCafe) { setCantidadCafe(cantidadCafe); }
    public int getCantidadCafe() { return cantidadCafe; }
    public void setCantidadCafe(int cantidad) {
        if (cantidad < 0) throw new IllegalArgumentException("El café no puede ser negativo");
        cantidadCafe = cantidad;
    }
    public boolean hasCafe(int cantidad) { return cantidad >= 0 && cantidadCafe >= cantidad; }
    public void giveCafe(int cantidad) {
        if (!hasCafe(cantidad)) throw new IllegalArgumentException("Cantidad de café no disponible");
        cantidadCafe -= cantidad;
    }
}
