package Lab05practica.ejercicios;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ejercicio2 {
	
	public static <T> List<T> invertirLista(List<T> listaOriginal) {
		List<T> listaInvertida = new ArrayList<>();

		
		for (int i = listaOriginal.size() - 1; i >= 0; i--) {
			listaInvertida.add(listaOriginal.get(i));
		}

		return listaInvertida;
	}

	
	public static void main(String[] args) {
		List<String> tareas = List.of("Comprar", "Estudiar", "Dormir");
		List<String> tareasInvertidas = invertirLista(tareas);

		System.out.println("Original: " + tareas);
		System.out.println("Invertida: " + tareasInvertidas);
	}
}
