package Lab03practica.ejercicio;

public class BM {
	public static int buscarMaximo(int[] v, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("El tamaño del vector debe ser mayor que 0.");
        }

        int m = v[0]; 
        for (int i = 1; i < n; i++) {
            if (v[i] > m) {
                m = v[i]; 
            }
        }
        return m; 
    }

    public static void main(String[] args) {
        int[] vector = {3, 8, 1, 7, 4, 9, 2};
        int n = vector.length;
        System.out.println("El valor máximo en el vector es: " + buscarMaximo(vector, n));
    }
}
