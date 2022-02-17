/**
 * Classe Soustraction - Utile pour la soustraction de deux nombres.
 * 
 * @author Vincent Boursat & Ludovic Corcos
 * @version Avril 2019
 */
abstract class Soustraction {

    /**
     * Effectue la soustraction du membre de droite a celui de gauche.
     *
     * @param membreDroit La valeur situé à gauche lors de la soustraction.
     * @param membreDroit La valeur situé à droite lors de la soustraction.
     *
     * @return Le résultat de la soustraction.
     *
     * @since 1.0
     */
    static double soustraction(double membreDroit, double membreGauche) {
        return membreDroit - membreGauche;
    }

}