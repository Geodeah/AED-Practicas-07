package Lab01practica;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        // Solicitar datos para el primer rectángulo
        System.out.println("Ingrese las coordenadas del primer rectángulo (esquina1 y esquina2):");
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
        Rectangulo rectanguloA = new Rectangulo(c1, c2);
        
        // Solicitar datos para el segundo rectángulo
        System.out.println("Ingrese las coordenadas del segundo rectángulo (esquina1 y esquina2):");
        System.out.print("Esquina 1 - x: ");
        double x3 = scanner.nextDouble();
        System.out.print("Esquina 1 - y: ");
        double y3 = scanner.nextDouble();
        System.out.print("Esquina 2 - x: ");
        double x4 = scanner.nextDouble();
        System.out.print("Esquina 2 - y: ");
        double y4 = scanner.nextDouble();
        
        Coordenada c3 = new Coordenada(x3, y3);
        Coordenada c4 = new Coordenada(x4, y4);
        Rectangulo rectanguloB = new Rectangulo(c3, c4);
        
        // Mostrar los rectángulos creados
        System.out.println("\nRectángulos creados:");
        System.out.println("Rectángulo A: " + rectanguloA);
        System.out.println("Rectángulo B: " + rectanguloB);
        
     // Determinar la relación entre los rectángulos
        if (Verificador.esSobrePos(rectanguloA, rectanguloB)) {
            System.out.println("Los rectángulos A y B se sobreponen.");
            Rectangulo sobreposicion = rectanguloSobre(rectanguloA, rectanguloB);
            System.out.println("Area de sobreposicion = " + sobreposicion.calculoArea());
        } else if (Verificador.esJunto(rectanguloA, rectanguloB)) {
            System.out.println("Los rectángulos A y B están juntos.");
        } else {
            System.out.println("Los rectángulos A y B son disjuntos.");
        }
        
        scanner.close();
    }
	
	public static void mostrarInformacionRectangulo(String nombre, Rectangulo rectangulo) {
        System.out.println(nombre + ": " + rectangulo);
    }
	
	public static Rectangulo rectanguloSobre(Rectangulo r1, Rectangulo r2) {
		double xInferiorIzq = Math.max(
		        Math.min(r1.getEsquina1().getX(), r1.getEsquina2().getX()),
		        Math.min(r2.getEsquina1().getX(), r2.getEsquina2().getX())
		    );

		    double yInferiorIzq = Math.max(
		        Math.min(r1.getEsquina1().getY(), r1.getEsquina2().getY()),
		        Math.min(r2.getEsquina1().getY(), r2.getEsquina2().getY())
		    );

		    double xSuperiorDer = Math.min(
		        Math.max(r1.getEsquina1().getX(), r1.getEsquina2().getX()),
		        Math.max(r2.getEsquina1().getX(), r2.getEsquina2().getX())
		    );

		    double ySuperiorDer = Math.min(
		        Math.max(r1.getEsquina1().getY(), r1.getEsquina2().getY()),
		        Math.max(r2.getEsquina1().getY(), r2.getEsquina2().getY())
		    );

		    // Verifica si hay una intersección válida
		    if (xInferiorIzq >= xSuperiorDer || yInferiorIzq >= ySuperiorDer) {
		        return new Rectangulo(new Coordenada(0, 0), new Coordenada(0, 0)); // No hay sobreposición
		    }

		    return new Rectangulo(new Coordenada(xInferiorIzq, yInferiorIzq), new Coordenada(xSuperiorDer, ySuperiorDer));
		}
}
