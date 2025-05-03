package Lab05practica.ejercicios;
import java.util.List;

public class Ejercicio1 {
	
    public static <T> boolean buscarElemento(List<T> lista, T valor) {
      
        for (T elemento : lista) {
            if (elemento.equals(valor)) {
                return true; 
            }
        }
        return false; 
    }

    
    public static void main(String[] args) {
        List<String> tareas = List.of("Comprar", "Estudiar", "Dormir");

        System.out.println(buscarElemento(tareas, "Estudiar")); 
        System.out.println(buscarElemento(tareas, "Correr"));   
        System.out.println(buscarElemento(tareas, "Dormir"));    
    }
}
