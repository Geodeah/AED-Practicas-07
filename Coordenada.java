package Lab01practica.ejercicio;
import java.util.*;

public class Coordenada {
	private double x;
	private double y;
	//Constructor, initialize x, y attributes to zero
	public Coordenada( ){
		this.x = 0;
		this.y = 0;
	}
	//Constructor
	public Coordenada(double x, double y ){
		this.x = x;
		this.y = y;
	}
	//Constructor
	public Coordenada(Coordenada c ){
		this.x = c.x;
        this.y = c.y;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	
	double distancia(Coordenada c){
		return Math.sqrt(Math.pow(this.x - c.x, 2) + Math.pow(this.y - c.y, 2));
	}
	
	
	static double distancia(Coordenada c1, Coordenada c2){
		return Math.sqrt(Math.pow(c1.x - c2.x, 2) + Math.pow(c1.y - c2.y, 2));
	}
	
	@Override
	public String toString() {
		return "x=" + x + ", y=" + y ;
	}
	
}
