package Test;

public class HashSinColision {
    private Integer[] table; // Tabla hash para almacenar enteros
    private int size;

    public HashSinColision(int size) {
        this.size = size;
        this.table = new Integer[size];
    }

    
     //Función hash: h(x) = x % 7
     
    private int hash(int key) {
        return key % size;
    }

    // Método para insertar un valor en la tabla hash
     
    public void insert(int value) {
        int index = hash(value);
        
        if (table[index] != null) {
            System.out.println("¡Colisión detectada! El valor " + value + 
                             " colisiona con " + table[index] + " en el índice " + index);
            return;
        }
        
        table[index] = value;
        System.out.println("Insertado " + value + " en el índice " + index);
    }

    // Método para mostrar la tabla hash final
     
    public void printTable() {
        System.out.println("\nTabla Hash Final (Tamaño: " + size + "):");
        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                System.out.println("Índice " + i + ": " + table[i]);
            } else {
                System.out.println("Índice " + i + ": Vacío");
            }
        }
    }

    public static void main(String[] args) {
        
        HashSinColision hashTable = new HashSinColision(7);
        
        // Insertar los valores especificados
        System.out.println("Insertando valores:");
        hashTable.insert(3);
        hashTable.insert(10);
        hashTable.insert(17);
        hashTable.insert(24);
        
        // Mostrar la tabla hash final
        hashTable.printTable();
    }
}
