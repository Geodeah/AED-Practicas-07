package Lab06practica.actividad03;

public class Test {

	public static void main(String[] args) {
		try {
			PriorityQueue<String, Integer> pq = new PriorityQueueLinkSort<>();

			pq.enqueue("Tarea1", 3);
			pq.enqueue("Tarea2", 1);
			pq.enqueue("Tarea3", 5);
			pq.enqueue("Tarea4", 2);

			System.out.println("Cola de prioridad: " + pq);
			System.out.println("Elemento con mayor prioridad (front): " + pq.front());
			System.out.println("Elemento con menor prioridad (back): " + pq.back());
			System.out.println("Desencolando: " + pq.dequeue());
			System.out.println("Cola después del dequeue: " + pq);
		} catch (ExceptionIsEmpty e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
