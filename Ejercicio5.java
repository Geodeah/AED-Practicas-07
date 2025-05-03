package Lab05practica.ejercicios;

public class Ejercicio5 {
	public static <T> boolean sonIguales(Node<T> head1, Node<T> head2) {
		Node<T> actual1 = head1;
		Node<T> actual2 = head2;

		while (actual1 != null && actual2 != null) {
			if (!actual1.data.equals(actual2.data)) {
				return false;
			}
			actual1 = actual1.next;
			actual2 = actual2.next;
		}

		// Si ambas listas llegaron al final, son iguales
		return actual1 == null && actual2 == null;
	}

	// Método de prueba
	public static void main(String[] args) {
		Node<String> lista1 = null;
		Node<String> lista2 = null;

		lista1 = insertarAlFinal(lista1, "Comprar");
		lista1 = insertarAlFinal(lista1, "Estudiar");

		lista2 = insertarAlFinal(lista2, "Comprar");
		lista2 = insertarAlFinal(lista2, "Estudiar");

		System.out.println("¿Listas iguales? " + sonIguales(lista1, lista2)); // true

		lista2 = insertarAlFinal(lista2, "Dormir");
		
		System.out.println("¿Listas iguales? " + sonIguales(lista1, lista2)); // false
	}

	// Método auxiliar de ejercicios anteriores
	public static <T> Node<T> insertarAlFinal(Node<T> head, T valor) {
		Node<T> nuevo = new Node<>(valor);
		if (head == null) {
			return nuevo;
		}
		Node<T> actual = head;
		while (actual.next != null) {
			actual = actual.next;
		}
		actual.next = nuevo;
		return head;
	}
}