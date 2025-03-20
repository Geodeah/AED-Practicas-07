package Lab01practica.ejercicio;

public class ContainerRect {
    private Rectangulo[] rectangulos;
    private double[] distancias;
    private double[] areas;
    private int n;
    private static int numRec = 0;

    // Constructor
    public ContainerRect(int n) {
        this.n = n;
        this.rectangulos = new Rectangulo[n];
        this.distancias = new double[n];
        this.areas = new double[n];
    }

    // Método para agregar un rectángulo al final del arreglo
    public void addRectangulo(Rectangulo rectangulo) {
        if (numRec < n) {
            rectangulos[numRec] = rectangulo;
            distancias[numRec] = rectangulo.getEsquina1().distancia(rectangulo.getEsquina2());
            areas[numRec] = rectangulo.calculoArea();
            numRec++;
        } else {
            System.out.println("No es posible guardar más rectángulos. Capacidad máxima alcanzada.");
        }
    }

    // Método toString para mostrar la tabla de rectángulos
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-15s %-30s %-15s %-10s%n", "Rectángulo", "Coordenadas", "Distancia", "Área"));
        sb.append("--------------------------------------------------------------------------------\n");

        for (int i = 0; i < numRec; i++) {
            sb.append(String.format("%-15d %-30s %-15.3f %-10.2f%n", 
                    (i + 1), rectangulos[i], distancias[i], areas[i]));
        }

        return sb.toString();
    }

    // Getter para numRec
    public static int getNumRec() {
        return numRec;
    }
}

