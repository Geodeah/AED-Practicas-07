package Test;

import Hash.HashC;
import Hash.Register;

public class TestHash {

	public static void main(String[] args) {
		 
        HashC hashTable = new HashC(11);

        
        System.out.println("Insertando registros...");
        hashTable.insert(new Register(34, "Registro 34"));
        hashTable.insert(new Register(3, "Registro 3"));
        hashTable.insert(new Register(7, "Registro 7"));
        hashTable.insert(new Register(30, "Registro 30"));
        hashTable.insert(new Register(11, "Registro 11"));
        hashTable.insert(new Register(8, "Registro 8"));
        hashTable.insert(new Register(7, "Registro 7 duplicado")); 
        hashTable.insert(new Register(23, "Registro 23"));
        hashTable.insert(new Register(41, "Registro 41"));
        hashTable.insert(new Register(16, "Registro 16"));
        hashTable.insert(new Register(34, "Registro 34 duplicado")); 

        
        hashTable.printTable();

        
        System.out.println("Buscando clave 23...");
        Register found = hashTable.search(23);
        if (found != null) {
            System.out.println("Encontrado: " + found);
        } else {
            System.out.println("No encontrado");
        }
        System.out.println();

        
        System.out.println("Eliminando clave 30...");
        hashTable.delete(30);

        
        hashTable.printTable();

        
        System.out.println("Clave 23 después de eliminar...");
        found = hashTable.search(23);
        if (found != null) {
            System.out.println("Encontrado: " + found);
        } else {
            System.out.println("No encontrado");
        }
        System.out.println();

        
        System.out.println("Buscando clave 99...");
        found = hashTable.search(99);
        if (found != null) {
            System.out.println("Encontrado: " + found);
        } else {
            System.out.println("No encontrado");
        }
    }
}
