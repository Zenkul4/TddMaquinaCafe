public class Azucarero {
    private int cantidadAzucar;
    public Azucarero(int cantidadAzucar) { setCantidadAzucar(cantidadAzucar); }
    public int getCantidadAzucar() { return cantidadAzucar; }
    public void setCantidadAzucar(int cantidad) {
        if (cantidad < 0) throw new IllegalArgumentException("El azúcar no puede ser negativo");
        cantidadAzucar = cantidad;
    }
    public boolean hasAzucar(int cantidad) { return cantidad >= 0 && cantidadAzucar >= cantidad; }
    public void giveAzucar(int cantidad) {
        if (!hasAzucar(cantidad)) throw new IllegalArgumentException("Cantidad de azúcar no disponible");
        cantidadAzucar -= cantidad;
    }
}
