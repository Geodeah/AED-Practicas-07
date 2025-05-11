package Lab06practica.ejercicio03;

public class PriorityQueueLinked<E> implements PriorityQueue<E> {
	private QueueLink<E>[] colas;
	private int niveles; // número de prioridades (0 = más alta)

	@SuppressWarnings("unchecked")
	public PriorityQueueLinked(int niveles) {
		this.niveles = niveles;
		this.colas = (QueueLink<E>[]) new QueueLink[niveles];
		for (int i = 0; i < niveles; i++) {
			colas[i] = new QueueLink<>();
		}
	}

	public void enqueue(E x, int pr) {
		if (pr < 0 || pr >= niveles) {
			throw new IllegalArgumentException("Prioridad inválida");
		}
		colas[pr].enqueue(x);
	}

	public E dequeue() throws ExceptionIsEmpty {
		for (int i = 0; i < niveles; i++) {
			if (!colas[i].isEmpty()) {
				return colas[i].dequeue();
			}
		}
		throw new ExceptionIsEmpty("La cola de prioridad está vacía");
	}

	public E front() throws ExceptionIsEmpty {
		for (int i = 0; i < niveles; i++) {
			if (!colas[i].isEmpty()) {
				return colas[i].front();
			}
		}
		throw new ExceptionIsEmpty("La cola está vacía");
	}

	public E back() throws ExceptionIsEmpty {
		for (int i = niveles - 1; i >= 0; i--) {
			if (!colas[i].isEmpty()) {
				return colas[i].back();
			}
		}
		throw new ExceptionIsEmpty("La cola está vacía");
	}

	public boolean isEmpty() {
		for (QueueLink<E> q : colas) {
			if (!q.isEmpty()) return false;
		}
		return true;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < niveles; i++) {
			sb.append("P").append(i).append(": ").append(colas[i].toString()).append("\n");
		}
		return sb.toString();
	}
}
