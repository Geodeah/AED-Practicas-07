package Lab06practica.ejercicio03;

public interface PriorityQueue<E> {
	void enqueue(E x, int pr); // 'pr' representa la prioridad (entero)
	E dequeue() throws ExceptionIsEmpty;
	E front() throws ExceptionIsEmpty;
	E back() throws ExceptionIsEmpty;
	boolean isEmpty();
}
