package Lab03practica.ejercicio;
import java.util.HashMap;
import java.util.Map;

public class Moda {
	public static int moda(int[] v) {
		Map<Integer, Integer> frecuencia = new HashMap<>(); // Diccionario para contar frecuencias
		int maxFrecuencia = 0;
		int moda = v[0]; // Inicialmente asumimos que la moda es el primer número

		for (int num : v) {
			int f = frecuencia.getOrDefault(num, 0) + 1; // Suma 1 a la frecuencia actual
			frecuencia.put(num, f); // Actualiza el valor en el mapa

			if (f > maxFrecuencia) {
				maxFrecuencia = f; // Si encontramos una frecuencia mayor, la guardamos
				moda = num;        // Y actualizamos la moda
			}
		}
		return moda; // Devolvemos el número con mayor frecuencia
	}

	public static void main(String[] args) {
		int[] vector = {1, 3, 2, 1, 4, 3, 1, 2, 1}; // Vector de prueba
		int resultado = moda(vector);
		System.out.println("La moda del arreglo es: " + resultado);
	}
}
