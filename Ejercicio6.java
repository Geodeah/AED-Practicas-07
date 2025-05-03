package Lab05practica.ejercicios;

public class Ejercicio6 {
	// Método genérico que concatena dos listas enlazadas y retorna una nueva lista
    public static <T> Node<T> concatenarListas(Node<T> lista1, Node<T> lista2) {
        if (lista1 == null) return copiarLista(lista2); // Si la primera lista es vacía
        if (lista2 == null) return copiarLista(lista1); // Si la segunda lista es vacía

        Node<T> nuevaLista = copiarLista(lista1); // Copiamos la primera lista
        Node<T> actual = nuevaLista;

        // Ir al final de la nueva lista
        while (actual.next != null) {
            actual = actual.next;
        }

        // Copiar la segunda lista y unirla al final
        actual.next = copiarLista(lista2);

        return nuevaLista;
    }

    // Método para copiar una lista (para no modificar las originales)
    public static <T> Node<T> copiarLista(Node<T> head) {
        if (head == null) return null;

        Node<T> nuevaCabeza = new Node<>(head.data);
        Node<T> actualOriginal = head.next;
        Node<T> actualNueva = nuevaCabeza;

        while (actualOriginal != null) {
            actualNueva.next = new Node<>(actualOriginal.data);
            actualOriginal = actualOriginal.next;
            actualNueva = actualNueva.next;
        }

        return nuevaCabeza;
    }

    // Método de prueba
    public static void main(String[] args) {
        Node<String> lista1 = null;
        Node<String> lista2 = null;

        lista1 = insertarAlFinal(lista1, "Comprar");
        lista1 = insertarAlFinal(lista1, "Estudiar");

        lista2 = insertarAlFinal(lista2, "Dormir");
        lista2 = insertarAlFinal(lista2, "Leer");

        Node<String> listaConcatenada = concatenarListas(lista1, lista2);
        imprimirLista(listaConcatenada);
    }

    // Métodos auxiliares
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

    public static <T> void imprimirLista(Node<T> head) {
        Node<T> actual = head;
        while (actual != null) {
            System.out.print(actual.data + " -> ");
            actual = actual.next;
        }
        System.out.println("null");
    }
}
