package Lab06practica.actividad03;

public class PriorityQueueLinkSort<E, N extends Comparable<N>> implements PriorityQueue<E, N> {

	private class EntryNode {
		E data;
		N priority;

		EntryNode(E data, N priority) {
			this.data = data;
			this.priority = priority;
		}

		public String toString() {
			return data + "(" + priority + ")";
		}
	}

	private Node<EntryNode> first;
	private Node<EntryNode> last;

	public PriorityQueueLinkSort() {
		this.first = null;
		this.last = null;
	}

	public void enqueue(E x, N pr) {
		EntryNode entry = new EntryNode(x, pr);
		Node<EntryNode> nuevo = new Node<>(entry);

		if (isEmpty()) {
			first = last = nuevo;
		} else if (entry.priority.compareTo(first.getData().priority) > 0) {
			nuevo.setNext(first);
			first = nuevo;
		} else {
			Node<EntryNode> actual = first;
			Node<EntryNode> anterior = null;
			while (actual != null && entry.priority.compareTo(actual.getData().priority) <= 0) {
				anterior = actual;
				actual = actual.getNext();
			}
			nuevo.setNext(actual);
			if (anterior != null) {
				anterior.setNext(nuevo);
			}
			if (nuevo.getNext() == null) {
				last = nuevo;
			}
		}
	}

	public E dequeue() throws ExceptionIsEmpty {
		if (isEmpty()) {
			throw new ExceptionIsEmpty("La cola de prioridad está vacía");
		}
		E dato = first.getData().data;
		first = first.getNext();
		if (first == null) {
			last = null;
		}
		return dato;
	}

	public E front() throws ExceptionIsEmpty {
		if (isEmpty()) throw new ExceptionIsEmpty("La cola de prioridad está vacía");
		return first.getData().data;
	}

	public E back() throws ExceptionIsEmpty {
		if (isEmpty()) throw new ExceptionIsEmpty("La cola de prioridad está vacía");
		return last.getData().data;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<EntryNode> actual = first;
		while (actual != null) {
			sb.append(actual.getData()).append(" -> ");
			actual = actual.getNext();
		}
		return sb.toString();
	}
}
