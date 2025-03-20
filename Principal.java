package Lab02practica.actividad;

public class Principal {

	public static void main(String[] args) {

		Bolsa<Golosina> bolsaGol = new Bolsa<Golosina>(3);
		Golosina g1 = new Golosina("Caramelo", 10.5);
		Golosina g2 = new Golosina("Chupetin", 5.2);
		Golosina g3 = new Golosina("Chicle", 3.0);
		bolsaGol.add(g1);
		bolsaGol.add(g2);
		bolsaGol.add(g3);
		for (Golosina golosina : bolsaGol) {
			System.out.println("Golosina: " + golosina.getNombre() + ", Peso: " + golosina.getPeso());
		}
	}
}

