package Test;

import Hash.HashO;
import Hash.Register;

public class TestHashO {
    public static void main(String[] args) {
        
        HashO hashTable = new HashO(5);

        
        System.out.println("Insertando registros...");
        hashTable.insert(new Register(10, "Juan"));
        hashTable.insert(new Register(15, "Ana"));
        hashTable.insert(new Register(20, "Luis"));
        hashTable.insert(new Register(25, "Rosa"));
        
        hashTable.printTable();
        
        hashTable.insert(new Register(30, "Carlos")); 
        hashTable.insert(new Register(5, "María")); 
        hashTable.insert(new Register(10, "Juan")); 

        
        hashTable.printTable();

        // Buscar 
        System.out.println("Buscando clave 20...");
        Register found = hashTable.search(20);
        if (found != null) {
            System.out.println("Encontrado: " + found);
        } else {
            System.out.println("No encontrado");
        }
        System.out.println();

        // Buscar una clave que no existe
        System.out.println("Buscando clave 30...");
        found = hashTable.search(30);
        if (found != null) {
            System.out.println("Encontrado: " + found);
        } else {
            System.out.println("No encontrado");
        }
        System.out.println();
        
        System.out.println("Buscando clave 90...");
        found = hashTable.search(90);
        if (found != null) {
            System.out.println("Encontrado: " + found);
        } else {
            System.out.println("No encontrado");
        }
        System.out.println();

        // Eliminar la clave 15
        System.out.println("Eliminando clave 15...");
        hashTable.delete(15);

        
        hashTable.printTable();

        // eliminar una clave que no existe
        System.out.println("Intentando eliminar clave 99...");
        hashTable.delete(99);
    }
}
