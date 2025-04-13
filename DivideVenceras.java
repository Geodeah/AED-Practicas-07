package Lab04practica.ejercicio02;

import java.util.Random;

public class DivideVenceras {
	static Random rand = new Random();

	public static int quickSelect(int[] arr, int k) {
		return quickSelectRec(arr, 0, arr.length - 1, k - 1); // k-1 porque los índices inician en 0
	}

	private static int quickSelectRec(int[] arr, int left, int right, int k) {
		if (left == right)
			return arr[left];

		int pivotIndex = partition(arr, left, right);

		if (k == pivotIndex) {
			return arr[k];
		} else if (k < pivotIndex) {
			return quickSelectRec(arr, left, pivotIndex - 1, k);
		} else {
			return quickSelectRec(arr, pivotIndex + 1, right, k);
		}
	}

	private static int partition(int[] arr, int left, int right) {
		int pivotIndex = left + rand.nextInt(right - left + 1);
		int pivot = arr[pivotIndex];

		swap(arr, pivotIndex, right);
		int storeIndex = left;

		for (int i = left; i < right; i++) {
			if (arr[i] < pivot) {
				swap(arr, i, storeIndex);
				storeIndex++;
			}
		}

		swap(arr, storeIndex, right);
		return storeIndex;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[][] arreglos = { { 4, 2, 7, 10, 4, 17 }, { 4, 2, 7, 10, 4, 1, 6 }, { 4, 2, 7, 1, 4, 6 },
				{ 9, 2, 7, 1, 7 } };

		int[] ks = { 3, 5, 1, 4 };

		for (int i = 0; i < arreglos.length; i++) {
			int resultado = quickSelect(arreglos[i].clone(), ks[i]);
			System.out.println("Caso " + (i + 1) + ": " + resultado);
		}
	}
}
