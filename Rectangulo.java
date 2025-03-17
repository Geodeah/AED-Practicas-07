package Lab01practica.ejercicio;
import java.util.*;

public class Rectangulo {
	private Coordenada esquina1;
	 private Coordenada esquina2;

	 
	 public Rectangulo(Coordenada c1, Coordenada c2) {
	 setEsquina1(c1);
	 setEsquina2(c2);
	 }

	 
	 public Coordenada getEsquina1() {
		return esquina1;
	}


	public void setEsquina1(Coordenada esquina1) {
		this.esquina1 = esquina1;
	}


	public Coordenada getEsquina2() {
		return esquina2;
	}


	public void setEsquina2(Coordenada esquina2) {
		this.esquina2 = esquina2;
	}
	
	public double calculoArea() {
	    double base = Math.abs(esquina1.getX() - esquina2.getX());
	    double altura = Math.abs(esquina1.getY() - esquina2.getY());
	    return base * altura;
	}


	@Override
	public String toString() {
		return "([" + esquina1 +"]" + ","+ "[" + esquina2 + "])";
	}

}
