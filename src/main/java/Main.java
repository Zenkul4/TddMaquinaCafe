import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MaquinaDeCafe maquina = new MaquinaDeCafe();
        maquina.setCafetera(new Cafetera(100));
        maquina.setAzucarero(new Azucarero(30));
        maquina.setVasosPequeno(new Vaso(5, 3));
        maquina.setVasosMediano(new Vaso(5, 5));
        maquina.setVasosGrande(new Vaso(5, 7));
        Scanner entrada = new Scanner(System.in);
        System.out.println("=== MÁQUINA DE CAFÉ ===");
        while (true) {
            System.out.println("\n1. Preparar café  2. Ver existencias  0. Salir");
            System.out.print("Opción: ");
            if (!entrada.hasNextLine()) break;
            String opcion = entrada.nextLine().trim();
            if (opcion.equals("0")) break;
            if (opcion.equals("2")) {
                System.out.printf("Café: %d oz | Azúcar: %d cucharadas%n", maquina.getCafetera().getCantidadCafe(), maquina.getAzucarero().getCantidadAzucar());
                System.out.printf("Vasos: pequeños %d | medianos %d | grandes %d%n", maquina.getVasosPequeno().getCantidadVasos(), maquina.getVasosMediano().getCantidadVasos(), maquina.getVasosGrande().getCantidadVasos());
                continue;
            }
            if (!opcion.equals("1")) { System.out.println("Opción inválida."); continue; }
            System.out.print("Tamaño (pequeño 3 oz, mediano 5 oz, grande 7 oz): ");
            if (!entrada.hasNextLine()) break;
            String tipo = entrada.nextLine();
            Vaso vaso;
            try { vaso = maquina.getTipoDeVaso(tipo); }
            catch (IllegalArgumentException e) { System.out.println(e.getMessage()); continue; }
            System.out.print("Cucharadas de azúcar (0 o más): ");
            if (!entrada.hasNextLine()) break;
            int azucar;
            try {
                azucar = Integer.parseInt(entrada.nextLine().trim());
                if (azucar < 0) throw new NumberFormatException();
            } catch (NumberFormatException e) { System.out.println("Introduzca un número entero no negativo."); continue; }
            String resultado = maquina.getVasoDeCafe(vaso, 1, azucar);
            if (resultado.equals("Felicitaciones"))
                System.out.printf("¡Café listo! Recoja su vaso de %d oz con %d cucharada(s) de azúcar.%n", vaso.getContenido(), azucar);
            else System.out.println(resultado + ". No se preparó el café.");
        }
        System.out.println("Hasta luego.");
    }
}
