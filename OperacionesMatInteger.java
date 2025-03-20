package Lab02practica.ejercicio;

class OperacionesMatInteger implements Operable<Integer> {
    @Override
    public Integer suma(Integer a, Integer b) { return a + b; }
    @Override
    public Integer resta(Integer a, Integer b) { return a - b; }
    @Override
    public Integer producto(Integer a, Integer b) { return a * b; }
    @Override
    public Integer division(Integer a, Integer b) { return (b != 0) ? a / b : 0; }
    @Override
    public Integer potencia(Integer a, Integer b) { return (int) Math.pow(a, b); }
    @Override
    public Integer raizCuadrada(Integer a) { return (int) Math.sqrt(a); }
    @Override
    public Integer raizCubica(Integer a) { return (int) Math.cbrt(a); }
}
