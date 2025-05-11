package Lab06practica.ejercicio04;

public class Test {
	public static void main(String[] args) {
		String[] entradas = {
				"()()()[()]()",
				"((()))[]",
				"([])[](",
				"([{)]}",
				"[",
				"[][][]{{{}}}"
		};

		for (String s : entradas) {
			boolean balanceado = Application.symbolBalancing(s);
			System.out.println(s + " -> " + balanceado);
		}
	}
}
