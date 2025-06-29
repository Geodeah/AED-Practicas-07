package Test;

public class HashSondeoLineal {
    private Integer[] table; 
    private int size;
    private static final Integer DELETED = Integer.MIN_VALUE; 

    public HashSondeoLineal(int size) {
        this.size = size;
        this.table = new Integer[size];
    }

    // Función hash: h(x) = x % 6
     
    private int hash(int key) {
        return key % size;
    }

    // Método para insertar un valor con sondeo lineal
     
    public void insert(int value) {
        int index = hash(value);
        int originalIndex = index;
        int probeCount = 0;
        
        System.out.println("\nIntentando insertar " + value + ":");
        
        do {
            // Si la posición está vacía o marcada como eliminada
            if (table[index] == null || table[index] == DELETED) {
                table[index] = value;
                System.out.println("  Insertado " + value + " en el índice " + index);
                printTableState();
                return;
            }
            
            // Si la posición está ocupada
            System.out.println("  Colisión en índice " + index + " (valor actual: " + table[index] + ")");
            System.out.println("  Aplicando sondeo lineal...");
            
            index = (index + 1) % size; // Sondeo lineal
            probeCount++;
            
        } while (index != originalIndex && probeCount < size);
        
        System.out.println("  ¡Error! No se pudo insertar " + value + " - tabla llena o demasiadas colisiones");
    }

    
    public void printTableState() {
        System.out.println("  Estado actual de la tabla:");
        for (int i = 0; i < size; i++) {
            String value;
            if (table[i] == null) {
                value = "Vacío";
            } else if (table[i] == DELETED) {
                value = "Eliminado";
            } else {
                value = table[i].toString();
            }
            System.out.println("  Índice " + i + ": " + value);
        }
    }

    public static void main(String[] args) {
        
        HashSondeoLineal hashTable = new HashSondeoLineal(6);
        
        
        System.out.println("=== INSERTANDO VALORES ===");
        hashTable.insert(12);
        hashTable.insert(18);
        hashTable.insert(24);
        hashTable.insert(30);
        
        
        System.out.println("\n=== TABLA HASH FINAL ===");
        hashTable.printTableState();
    }
}
