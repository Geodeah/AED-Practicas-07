package Lab06practica.ejercicio03;

public class QueueLink<E> {
	private Node<E> first;
	private Node<E> last;

	public QueueLink() {
		this.first = null;
		this.last = null;
	}

	public void enqueue(E x) {
		Node<E> nuevo = new Node<>(x);
		if (isEmpty()) {
			first = nuevo;
		} else {
			last.setNext(nuevo);
		}
		last = nuevo;
	}

	public E dequeue() throws ExceptionIsEmpty {
		if (isEmpty()) {
			throw new ExceptionIsEmpty("Cola vacía");
		}
		E value = first.getData();
		first = first.getNext();
		if (first == null) last = null;
		return value;
	}

	public E front() throws ExceptionIsEmpty {
		if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
		return first.getData();
	}

	public E back() throws ExceptionIsEmpty {
		if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
		return last.getData();
	}

	public boolean isEmpty() {
		return first == null;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<E> actual = first;
		while (actual != null) {
			sb.append(actual.getData()).append(" -> ");
			actual = actual.getNext();
		}
		return sb.toString();
	}
}
