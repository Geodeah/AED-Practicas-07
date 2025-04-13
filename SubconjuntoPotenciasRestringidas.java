package Lab04practica.ejercicio01;

public class SubconjuntoPotenciasRestringidas {

    public static boolean subconjuntoSumObjetivo(int[] arr, int objetivo) {
        return subconjuntoSumObjetivo(arr, 0, objetivo, false);
    }

    private static boolean subconjuntoSumObjetivo(int[] arr, int indice, int objetivo, boolean previoEsImpar) {
        // Caso base: si hemos revisado todos los elementos
        if (indice == arr.length) {
            return objetivo == 0;
        }

        int numeroActual = arr[indice];

        // Opción 1: No incluir el elemento actual
        boolean resultado = subconjuntoSumObjetivo(arr, indice + 1, objetivo, false);

        // Opción 2: Incluir el elemento actual (si es posible según las restricciones)
        if (esPotenciaDeDos(numeroActual)) {
            // Si es potencia de 2, debe incluirse obligatoriamente
            return subconjuntoSumObjetivo(arr, indice + 1, objetivo - numeroActual, esImpar(numeroActual));
        } else if (numeroActual % 5 == 0) {
            // Si es múltiplo de 5, verificar si el número anterior es impar
            if (previoEsImpar) {
                // Si el número anterior es impar, no se puede incluir este múltiplo de 5
                return resultado; // Retornar solo la opción de NO incluirlo
            } else {
                // Si el número anterior NO es impar, se puede incluir el múltiplo de 5
                resultado = resultado || subconjuntoSumObjetivo(arr, indice + 1, objetivo - numeroActual, esImpar(numeroActual));
            }
        } else {
            // Si no es potencia de 2 ni múltiplo de 5, se puede incluir
            resultado = resultado || subconjuntoSumObjetivo(arr, indice + 1, objetivo - numeroActual, esImpar(numeroActual));
        }

        return resultado;
    }

    private static boolean esPotenciaDeDos(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    private static boolean esImpar(int n) {
        return n % 2 != 0;
    }

    public static void main(String[] args) {
        // Casos de prueba
        int[] arr1 = {4, 8, 10, 3, 5};
        int objetivo1 = 27;
        System.out.println(subconjuntoSumObjetivo(arr1, objetivo1)); // true

        int[] arr2 = {4, 8, 10, 3, 6};
        int objetivo2 = 27;
        System.out.println(subconjuntoSumObjetivo(arr2, objetivo2)); // false

        int[] arr3 = {2, 16, 5, 7, 10};
        int objetivo3 = 33;
        System.out.println(subconjuntoSumObjetivo(arr3, objetivo3)); // true

        int[] arr5 = {2, 5, 1, 6};
        int objetivo5 = 13;
        System.out.println(subconjuntoSumObjetivo(arr5, objetivo5)); // true
        
        int[] arr4 = {2, 16, 5, 3, 10};
        int objetivo4 = 33;
        System.out.println(subconjuntoSumObjetivo(arr4, objetivo4)); // false

        
    }
}
