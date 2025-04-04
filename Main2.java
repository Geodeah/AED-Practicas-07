package Lab03practica.ejercicio;

public class Main2 {
	public static void mergeSort(int[] arr) {
		int[] aux = new int[arr.length]; // Arreglo auxiliar compartido
		mergeSort(arr, aux, 0, arr.length - 1);
	}

	private static void mergeSort(int[] arr, int[] aux, int inicio, int fin) {
		if (inicio >= fin) return;

		int medio = (inicio + fin) / 2;

		// Ordenar recursivamente
		mergeSort(arr, aux, inicio, medio);
		mergeSort(arr, aux, medio + 1, fin);

		// Fusionar usando aux
		merge(arr, aux, inicio, medio, fin);
	}

	private static void merge(int[] arr, int[] aux, int inicio, int medio, int fin) {
		// Copiar a auxiliar
		for (int i = inicio; i <= fin; i++) {
			aux[i] = arr[i];
		}

		int i = inicio;
		int j = medio + 1;
		int k = inicio;

		// Fusionar
		while (i <= medio && j <= fin) {
			if (aux[i] <= aux[j]) {
				arr[k++] = aux[i++];
			} else {
				arr[k++] = aux[j++];
			}
		}

		// Copiar lo restante de la izquierda
		while (i <= medio) {
			arr[k++] = aux[i++];
		}
	}

	public static void main(String[] args) {
		int[] arreglo = {38, 27, 43, 3, 9, 82, 10};
		mergeSort(arreglo);
		for (int i : arreglo) {
			System.out.print(i + " ");
		}
	}
}
