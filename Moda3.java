package Lab04practica.actividad04;

import java.util.HashMap;
import java.util.Map;

public class Moda3 {
	public static void pivote2(int[] a, int mediana, int prim, int ult, int[] izq, int[] der) {
        int left = prim, right = ult;
        int i = prim;
        while (i <= right) {
            if (a[i] < mediana) {
                swap(a, left++, i++);
            } else if (a[i] > mediana) {
                swap(a, i, right--);
            } else {
                i++;
            }
        }
        izq[0] = left;
        der[0] = right + 1;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int moda3(int[] a, int prim, int ult) {
        SetVectors homogeneo = new SetVectors();
        SetVectors heterogeneo = new SetVectors();
        Limits p = new Limits(a, prim, ult);
        heterogeneo.insertar(p);
        
        HashMap<Integer, Integer> frecuencia = new HashMap<>();
        
        while (heterogeneo.longMayor() > homogeneo.longMayor()) {
            p = heterogeneo.mayor();
            int mediana = a[(p.prim + p.ult) / 2];
            int[] izq = new int[1];
            int[] der = new int[1];
            pivote2(p.a, mediana, p.prim, p.ult, izq, der);
            
            for (int i = p.prim; i <= p.ult; i++) {
                frecuencia.put(a[i], frecuencia.getOrDefault(a[i], 0) + 1);
            }
            
            Limits p1 = new Limits(p.a, p.prim, izq[0] - 1);
            Limits p2 = new Limits(p.a, izq[0], der[0] - 1);
            Limits p3 = new Limits(p.a, der[0], p.ult);
            
            if (p1.prim < p1.ult) heterogeneo.insertar(p1);
            if (p3.prim < p3.ult) heterogeneo.insertar(p3);
            if (p2.prim < p2.ult) homogeneo.insertar(p2);
        }
        
        int moda = a[prim];
        int maxFrecuencia = 0;
        
        for (Map.Entry<Integer, Integer> entry : frecuencia.entrySet()) {
            if (entry.getValue() > maxFrecuencia) {
                maxFrecuencia = entry.getValue();
                moda = entry.getKey();
            }
        }
        
        homogeneo.destruir();
        heterogeneo.destruir();
        return moda;
    }
}