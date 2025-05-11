package Lab06practica.ejercicio04;

public class StackLink<E> implements Stack<E> {
	private Node<E> top;

	public StackLink() {
		this.top = null;
	}

	public void push(E x) {
		Node<E> nuevo = new Node<>(x);
		nuevo.setNext(top);
		top = nuevo;
	}

	public E pop() throws ExceptionIsEmpty {
		if (isEmpty()) {
			throw new ExceptionIsEmpty("Pila vacía");
		}
		E valor = top.getData();
		top = top.getNext();
		return valor;
	}

	public E top() throws ExceptionIsEmpty {
		if (isEmpty()) {
			throw new ExceptionIsEmpty("Pila vacía");
		}
		return top.getData();
	}

	public boolean isEmpty() {
		return top == null;
	}
}
