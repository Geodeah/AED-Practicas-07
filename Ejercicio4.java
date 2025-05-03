package Lab05practica.ejercicios;

public class Ejercicio4 {
	
	public static <T> int contarNodos(Node<T> head) {
		int contador = 0;
		Node<T> actual = head;

		while (actual != null) {
			contador++;
			actual = actual.next;
		}

		return contador;
	}

	
	public static void main(String[] args) {
		Node<String> lista = null;

		lista = insertarAlFinal(lista, "Comprar");
		lista = insertarAlFinal(lista, "Estudiar");
		lista = insertarAlFinal(lista, "Dormir");

		System.out.println("Total de nodos: " + contarNodos(lista)); 
	}

	
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
