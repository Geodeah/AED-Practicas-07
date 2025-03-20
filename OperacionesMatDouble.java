package Lab02practica.ejercicio;

public class OperacionesMatDouble implements Operable<Double> {
	 @Override
	    public Double suma(Double a, Double b) { return a + b; }
	    @Override
	    public Double resta(Double a, Double b) { return a - b; }
	    @Override
	    public Double producto(Double a, Double b) { return a * b; }
	    @Override
	    public Double division(Double a, Double b) { return (b != 0) ? a / b : 0.0; }
	    @Override
	    public Double potencia(Double a, Double b) { return Math.pow(a, b); }
	    @Override
	    public Double raizCuadrada(Double a) { return Math.sqrt(a); }
	    @Override
	    public Double raizCubica(Double a) { return Math.cbrt(a); }
	}
