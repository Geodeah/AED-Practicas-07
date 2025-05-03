package Lab05practica.ejercicios;

public class Ejercicio3 {
	
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

    
    public static void main(String[] args) {
    	Node<String> lista = null;

        lista = insertarAlFinal(lista, "Comprar");
        lista = insertarAlFinal(lista, "Estudiar");
        lista = insertarAlFinal(lista, "Dormir");

        imprimirLista(lista);
    }
}

