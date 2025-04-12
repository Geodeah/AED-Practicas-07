package Lab04practica.actividad04;

public class Limits {
	int[] a;
    int prim, ult;

    public Limits(int[] a, int prim, int ult) {
        this.a = a;
        this.prim = prim;
        this.ult = ult;
    }

    public int longitud() {
        return ult - prim + 1;
    }
}
