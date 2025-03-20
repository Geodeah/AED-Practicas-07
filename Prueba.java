package Lab02practica.ejercicio;
import java.util.Scanner;

public class Prueba {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el tipo de datos (1: Integer, 2: Double):");
        int tipo = scanner.nextInt();
        if (tipo == 1) {
            ejecutarOperaciones(new OperacionesMatInteger(), scanner);
        } else if (tipo == 2) {
            ejecutarOperaciones(new OperacionesMatDouble(), scanner);
        } else {
            System.out.println("Opción inválida.");
        }
        scanner.close();
    }
    private static <T extends Number> void ejecutarOperaciones(Operable<T> operacion, Scanner scanner) {
        while (true) {
            System.out.println("Menú de Operaciones Clases Genéricas:");
            System.out.println("1. Suma\n2. Resta\n3. Producto\n4. División\n5. Potencia\n6. Raíz Cuadrada\n7. Raíz Cúbica\n8. Salir");
            int opcion = scanner.nextInt();
            if (opcion == 8) break;
            T num1 = leerNumero(scanner, "Ingrese el primer número: ", operacion instanceof OperacionesMatDouble);
            T num2 = (opcion <= 5) ? leerNumero(scanner, "Ingrese el segundo número: ", operacion instanceof OperacionesMatDouble) : null;
            T resultado = switch (opcion) {
                case 1 -> operacion.suma(num1, num2);
                case 2 -> operacion.resta(num1, num2);
                case 3 -> operacion.producto(num1, num2);
                case 4 -> operacion.division(num1, num2);
                case 5 -> operacion.potencia(num1, num2);
                case 6 -> operacion.raizCuadrada(num1);
                case 7 -> operacion.raizCubica(num1);
                default -> null;
            };
            System.out.println("Resultado: " + resultado);
        }
    }   
    private static <T extends Number> T leerNumero(Scanner scanner, String mensaje, boolean esDouble) {
        while (true) {
            System.out.print(mensaje);
            try {
                return esDouble ? (T) Double.valueOf(scanner.nextDouble()) : (T) Integer.valueOf(scanner.nextInt());
            } catch (Exception e) {
                System.out.println("Entrada inválida. Intente de nuevo.");
                scanner.next();
            }
        }
    }
}
