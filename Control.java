package Lab03practica.ejercicio;

public class Control {
	public static int conteoDuplicados(int[] v, int n) {
        int conteo = 0; 

        for (int i = 0; i < n - 1; i++) { 
            for (int j = i + 1; j < n; j++) { 
                if (v[i] == v[j]) {
                    conteo++; 
                }
            }
        }
        return conteo; 
    }

    public static void main(String[] args) {
        int[] vector = {1, 2, 3, 2, 4, 1, 5, 3, 6, 2}; 
        int n = vector.length;

        System.out.println("Número de pares duplicados: " + conteoDuplicados(vector, n));
    }
}
