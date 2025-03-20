package Lab01practica;

public class Verificador {
	// Método para verificar si dos rectángulos se sobreponen
    public static boolean esSobrePos(Rectangulo r1, Rectangulo r2) {
    	 double x1_min = Math.min(r1.getEsquina1().getX(), r1.getEsquina2().getX());
         double x1_max = Math.max(r1.getEsquina1().getX(), r1.getEsquina2().getX());
         double y1_min = Math.min(r1.getEsquina1().getY(), r1.getEsquina2().getY());
         double y1_max = Math.max(r1.getEsquina1().getY(), r1.getEsquina2().getY());

         double x2_min = Math.min(r2.getEsquina1().getX(), r2.getEsquina2().getX());
         double x2_max = Math.max(r2.getEsquina1().getX(), r2.getEsquina2().getX());
         double y2_min = Math.min(r2.getEsquina1().getY(), r2.getEsquina2().getY());
         double y2_max = Math.max(r2.getEsquina1().getY(), r2.getEsquina2().getY());

         // Condición de superposición en ambos ejes
         boolean sobreX = x1_max > x2_min && x2_max > x1_min;
         boolean sobreY = y1_max > y2_min && y2_max > y1_min;

         return sobreX && sobreY;
     }
    
    // Método para verificar si dos rectángulos están juntos (comparten un lado)
    public static boolean esJunto(Rectangulo r1, Rectangulo r2) {
        return (r1.getEsquina2().getX() == r2.getEsquina1().getX() ||
                r1.getEsquina1().getX() == r2.getEsquina2().getX() ||
                r1.getEsquina2().getY() == r2.getEsquina1().getY() ||
                r1.getEsquina1().getY() == r2.getEsquina2().getY());
    }
    
    // Método para verificar si dos rectángulos son disjuntos (no se tocan ni se sobreponen)
    public static boolean esDisjunto(Rectangulo r1, Rectangulo r2) {
        return !esSobrePos(r1, r2) && !esJunto(r1, r2);
    }

}
