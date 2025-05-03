package Lab05practica.ejercicios;

public class Node<T> {
	T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}