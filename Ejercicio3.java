package Lab05practica.ejercicios;

public class Ejercicio3 {
	// Método genérico para insertar un nodo al final de la lista enlazada
    public static <T> Node<T> insertarAlFinal(Node<T> head, T valor) {
    	Node<T> nuevo = new Node<>(valor);

        // Si la lista está vacía, el nuevo nodo es la cabeza
        if (head == null) {
            return nuevo;
        }

        // Recorremos hasta el último nodo
        Node<T> actual = head;
        while (actual.next != null) {
            actual = actual.next;
        }

        // Insertamos al final
        actual.next = nuevo;
        return head; // retornamos la cabeza (no cambia si ya existía)
    }

    // Método para imprimir la lista (útil para pruebas)
    public static <T> void imprimirLista(Node<T> head) {
    	Node<T> actual = head;
        while (actual != null) {
            System.out.print(actual.data + " -> ");
            actual = actual.next;
        }
        System.out.println("null");
    }

    // Método de prueba
    public static void main(String[] args) {
    	Node<String> lista = null;

        lista = insertarAlFinal(lista, "Comprar");
        lista = insertarAlFinal(lista, "Estudiar");
        lista = insertarAlFinal(lista, "Dormir");

        imprimirLista(lista);
    }
}

