package Lab04practica.actividad04;

public class Main {

	public static void main(String[] args) {
		int[] arreglo = {5, 1, 3, 5, 2, 5, 1, 3, 5};
        int moda = Moda3.moda3(arreglo, 0, arreglo.length - 1);
        System.out.println("La moda es: " + moda);
    }
}
