package Lab03practica.ejercicio;

public class Potencia {
	public static int potenciaRapida(int x, int y) {
        if (y == 0) {
            return 1;
        } else if (y % 2 == 0) {
            int mitad = potenciaRapida(x, y / 2);
            return mitad * mitad;
        } else {
            return x * potenciaRapida(x, y - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("2^10 = " + potenciaRapida(2, 10)); // 1024
        System.out.println("3^5 = " + potenciaRapida(3, 5));   // 243
    }
}