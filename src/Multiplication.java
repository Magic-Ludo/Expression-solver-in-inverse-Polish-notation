/**
 * Classe Multiplication - Utile pour la multiplication de deux nombres.
 * 
 * @author Vincent Boursat & Ludovic Corcos
 * @version Avril 2019
 */
abstract class Multiplication {

    /**
     * Effectue la multiplication du membre de gauche par celui de droite.
     *
     * @param membreDroit La valeur situé à gauche lors de la multiplication.
     * @param membreDroit La valeur situé à droite lors de la multiplication.
     *
     * @return Le résultat de la multiplication.
     *
     * @since 1.0
     */
    static double multiplication(double membreDroit, double membreGauche) {
        return membreDroit * membreGauche;
    }

}