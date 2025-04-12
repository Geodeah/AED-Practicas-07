package Lab04practica.actividad04;

import java.util.ArrayList;

public class SetVectors {
    private ArrayList<Limits> lista;

    public SetVectors() {
        lista = new ArrayList<>();
    }

    public void insertar(Limits l) {
        lista.add(l);
    }

    public Limits mayor() {
        int idx = 0;
        int maxLen = -1;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).longitud() > maxLen) {
                maxLen = lista.get(i).longitud();
                idx = i;
            }
        }
        return lista.remove(idx);
    }

    public int longMayor() {
        int maxLen = 0;
        for (Limits l : lista) {
            maxLen = Math.max(maxLen, l.longitud());
        }
        return maxLen;
    }

    public void destruir() {
        lista.clear();
    }
}