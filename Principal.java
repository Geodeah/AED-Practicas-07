package Lab01practica.ejercicio;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad máxima de rectángulos a almacenar: ");
        int capacidad = scanner.nextInt();

        // Crear contenedor de rectángulos
        ContainerRect container = new ContainerRect(capacidad);

        while (true) {
            // Solicitar datos para un nuevo rectángulo
            System.out.println("\nIngrese las coordenadas del nuevo rectángulo:");
            System.out.print("Esquina 1 - x: ");
            double x1 = scanner.nextDouble();
            System.out.print("Esquina 1 - y: ");
            double y1 = scanner.nextDouble();
            System.out.print("Esquina 2 - x: ");
            double x2 = scanner.nextDouble();
            System.out.print("Esquina 2 - y: ");
            double y2 = scanner.nextDouble();

            Coordenada c1 = new Coordenada(x1, y1);
            Coordenada c2 = new Coordenada(x2, y2);
            Rectangulo nuevoRectangulo = new Rectangulo(c1, c2);

            // Agregar al contenedor
            container.addRectangulo(nuevoRectangulo);

            // Preguntar si desea agregar otro rectángulo
            System.out.print("¿Desea agregar otro rectángulo? (s/n): ");
            char respuesta = scanner.next().charAt(0);
            if (respuesta == 'n' || respuesta == 'N') {
                break;
            }
        }

        // Mostrar rectángulos almacenados
        System.out.println("\nRectángulos almacenados:");
        System.out.println(container);

        scanner.close();
    }
}
