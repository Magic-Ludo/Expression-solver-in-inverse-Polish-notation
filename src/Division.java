/**
 * Classe Division - Utile pour la division de deux nombres.
 * 
 * @author Vincent Boursat & Ludovic Corcos
 * @version Avril 2019
 */
abstract class Division {

    /**
     * Effectue la division du membre de gauche par celui de droite.
     *
     * @param membreDroit La valeur situé à gauche lors de la division.
     * @param membreDroit La valeur situé à droite lors de la division.
     *
     * @return Le résultat de la division.
     * 
     * @since 1.0
     */
    static double division(double membreDroit, double membreGauche) {
        double result;

        try {
            result = membreDroit / membreGauche;
            if (result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY) {
                throw new ArithmeticException();
            }
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Une division par 0 est impossible.");
        }

        return result;
    }

}