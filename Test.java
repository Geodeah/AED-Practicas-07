package Lab06practica.ejercicio03;

public class Test {

	public static void main(String[] args) {
		try {
			PriorityQueue<String> pq = new PriorityQueueLinked<>(3); // 3 niveles: 0 (alta), 1, 2 (baja)

			pq.enqueue("Alta1", 0);
			pq.enqueue("Baja1", 2);
			pq.enqueue("Media1", 1);
			pq.enqueue("Alta2", 0);
			pq.enqueue("Media2", 1);


			System.out.println("Contenido de la cola por prioridad:");
			System.out.println(pq);

			System.out.println("Front: " + pq.front());
			System.out.println("Back: " + pq.back());

			System.out.println("Dequeue: " + pq.dequeue());
			System.out.println("Después del dequeue:");
			System.out.println(pq);

		} catch (ExceptionIsEmpty e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
