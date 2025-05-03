package Lab05practica.ejercicios;
import java.util.List;

public class Ejercicio1 {
	// Método genérico para buscar un elemento en una lista
    public static <T> boolean buscarElemento(List<T> lista, T valor) {
        // Recorremos cada elemento de la lista
        for (T elemento : lista) {
            if (elemento.equals(valor)) {
                return true; // Si encontramos el valor, retornamos true
            }
        }
        return false; // Si no se encuentra el valor, retornamos false
    }

    // Método de prueba
    public static void main(String[] args) {
        List<String> tareas = List.of("Comprar", "Estudiar", "Dormir");

        System.out.println(buscarElemento(tareas, "Estudiar")); // true
        System.out.println(buscarElemento(tareas, "Correr"));   // false
        System.out.println(buscarElemento(tareas, "Dormir"));    
    }
}
